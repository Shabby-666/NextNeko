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

        Player owner = event.getEntity();
        if (dyingPlayers.contains(owner.getUniqueId())) {
            return;
        }

        Set<Player> nekos = nekoManager.getNekosByOwner(owner);
        if (nekos.isEmpty()) {
            return;
        }

        for (Player neko : nekos) {
            if (dyingPlayers.contains(neko.getUniqueId())) {
                continue;
            }
            dyingPlayers.add(neko.getUniqueId());
            neko.sendMessage("§c你的主人已死亡，你也随之倒下了...");
            neko.setHealth(0.0);
        }

        dyingPlayers.remove(owner.getUniqueId());
    }
}