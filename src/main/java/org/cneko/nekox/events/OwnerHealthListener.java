package org.cneko.nekox.events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffectType;
import org.cneko.nekox.NextNeko;
import org.cneko.nekox.commands.HealthCommand;
import org.cneko.nekox.utils.NekoManager;
import org.cneko.nekox.utils.SkillManager;

import java.util.Set;

/**
 * 主人血量过低时自动触发猫娘的生命恢复技能。
 * 当主人受到伤害后剩余血量低于阈值时，其名下所有猫娘自动发动 /health 恢复，
 * 该自动触发不消耗饱食度、不进入冷却，猫娘之后仍可手动使用技能。
 */
public class OwnerHealthListener implements Listener {
    private static final double LOW_HEALTH_THRESHOLD = 6.0;

    private final NextNeko plugin;
    private final NekoManager nekoManager;
    private final HealthCommand healthCommand;

    public OwnerHealthListener(NextNeko plugin) {
        this.plugin = plugin;
        this.nekoManager = plugin.getNekoManager();
        this.healthCommand = new HealthCommand(plugin);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onOwnerDamaged(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        FileConfiguration config = plugin.getConfig();
        if (!config.getBoolean("owner-health.feature.enabled", true)) {
            return;
        }

        Player owner = (Player) event.getEntity();
        if (owner.isDead()) {
            return;
        }

        // 计算受到这次伤害后的剩余血量
        double newHealth = owner.getHealth() - event.getFinalDamage();
        if (newHealth >= LOW_HEALTH_THRESHOLD) {
            return;
        }

        // 主人已处于再生效果中时不再重复触发，避免刷效果
        if (owner.hasPotionEffect(PotionEffectType.REGENERATION)) {
            return;
        }

        Set<Player> nekos = nekoManager.getNekosByOwner(owner);
        if (nekos.isEmpty()) {
            return;
        }

        for (Player neko : nekos) {
            if (!neko.isOnline() || neko.isDead()) {
                continue;
            }
            // 被动技能冷却检查（60秒，独立于主动 /health 的冷却）
            if (plugin.getSkillManager().isSkillOnCooldown(neko, SkillManager.SkillType.HEALTH_RESTORE_PASSIVE)) {
                continue;
            }
            // 触发自动恢复（不消耗饱食度），并进入被动冷却
            healthCommand.autoTriggerRestore(neko);
            plugin.getSkillManager().setCooldown(neko, SkillManager.SkillType.HEALTH_RESTORE_PASSIVE);
        }
    }
}
