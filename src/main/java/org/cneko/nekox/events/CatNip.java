package org.cneko.nekox.events;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.cneko.nekox.NextNeko;
import org.cneko.nekox.utils.VersionUtils;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CatNip implements Listener {
    private final NextNeko plugin;
    private static final Map<UUID, Long> activeCatnip = new ConcurrentHashMap<>();

    public CatNip(NextNeko plugin) {
        this.plugin = plugin;
    }

    /**
     * 猫薄荷效果放大器（Speed/JumpBoost 等级）
     */
    public static int getCatnipAmplifier() {
        return 1;
    }

    /**
     * 检查玩家是否有生效中的猫薄荷效果
     */
    public static boolean isCatnipActive(Player player) {
        Long until = activeCatnip.get(player.getUniqueId());
        if (until == null) {
            return false;
        }
        if (System.currentTimeMillis() < until) {
            return true;
        }
        activeCatnip.remove(player.getUniqueId());
        return false;
    }
    
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        // 忽略副手持物的交互
        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }
        
        FileConfiguration config = plugin.getConfig();
        
        if (!config.getBoolean("cat-nip.enabled", true)) {
            return;
        }
        
        Player player = event.getPlayer();
        
        // 检查玩家是否是猫娘
        if (!plugin.getNekoManager().isNeko(player)) {
            return;
        }
        
        // 检查玩家是否手持猫薄荷物品
        String itemConfig = config.getString("cat-nip.item", "WHEAT_SEEDS");
        Material catnipMaterial = Material.matchMaterial(itemConfig);
        if (catnipMaterial == null) {
            // 如果配置的物品ID无效，使用默认的小麦种子
            catnipMaterial = Material.WHEAT_SEEDS;
        }
        
        if (player.getInventory().getItemInMainHand().getType() != catnipMaterial) {
            return;
        }
        
        // 检查物品数量
        if (player.getInventory().getItemInMainHand().getAmount() <= 0) {
            return;
        }
        
        // 应用猫薄荷效果
        int duration = config.getInt("cat-nip.duration", 60) * 20; // 转换为刻
        long until = System.currentTimeMillis() + (duration * 50L);
        activeCatnip.put(player.getUniqueId(), until);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, 1, false, false));
                player.addPotionEffect(new PotionEffect(VersionUtils.getJumpBoostEffect(), duration, 1, false, false));
        
        // 发送消息（支持多语言）
        String message = plugin.getLanguageManager().getMessage("catnip.effect");
        if (message == null || message.isEmpty()) {
            message = "§e你感到异常兴奋！喵~♪";
        }
        player.sendMessage(message);
        
        // 消耗一个猫薄荷
        player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
    }
}