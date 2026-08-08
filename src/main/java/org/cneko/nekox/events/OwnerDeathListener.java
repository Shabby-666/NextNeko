package org.cneko.nekox.events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.cneko.nekox.NextNeko;
import org.cneko.nekox.utils.NekoManager;

import java.util.HashSet;
import java.util.Set;

public class OwnerDeathListener implements Listener {
    private final NextNeko plugin;
    private final NekoManager nekoManager;
    private final Set<java.util.UUID> dyingPlayers = new HashSet<>();

    public OwnerDeathListener(NextNeko plugin) {
        this.plugin = plugin;
        this.nekoManager = plugin.getNekoManager();
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onOwnerDeath(PlayerDeathEvent event) {
        FileConfiguration config = plugin.getConfig();

        if (!config.getBoolean("owner-death.feature.enabled", true)) {
            return;
        }

        Player dead = event.getEntity();

        // 如果是上一轮被"主人死亡连锁"杀掉的猫娘，其死亡事件会再次进入本监听器。
        // 此时只移除其标记（避免缓存泄漏导致后续死亡无法连锁），不再进一步连锁其自己的猫娘。
        if (dyingPlayers.contains(dead.getUniqueId())) {
            dyingPlayers.remove(dead.getUniqueId());
            return;
        }

        Set<Player> nekos = nekoManager.getNekosByOwner(dead);
        if (nekos.isEmpty()) {
            return;
        }

        String deathMessage = config.getString("owner-death.message", "&c你的主人已死亡，你也随之倒下了...")
                .replace("&", "§");

        for (Player neko : nekos) {
            if (dyingPlayers.contains(neko.getUniqueId())) {
                continue;
            }
            dyingPlayers.add(neko.getUniqueId());
            neko.sendMessage(deathMessage);
            neko.setHealth(0.0);
            // 安全网：正常情况下猫娘死亡会触发自己的 PlayerDeathEvent 并清理标记。
            // 若其死亡被其他插件拦截（如 god 模式），延迟清理标记，避免永久泄漏导致后续死亡无法连锁。
            final java.util.UUID nekoUuid = neko.getUniqueId();
            plugin.getServer().getScheduler().runTaskLater(plugin, () -> dyingPlayers.remove(nekoUuid), 5L);
        }
    }
}