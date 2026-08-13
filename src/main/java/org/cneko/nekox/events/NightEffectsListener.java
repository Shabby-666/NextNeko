package org.cneko.nekox.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.potion.PotionEffect;
import org.cneko.nekox.NextNeko;
import org.cneko.nekox.utils.NekoManager;
import org.cneko.nekox.utils.VersionUtils;

public class NightEffectsListener implements Listener {
    private final NextNeko plugin;
    private final NekoManager nekoManager;
    private int taskId;

    public NightEffectsListener(NextNeko plugin) {
        this.plugin = plugin;
        this.nekoManager = plugin.getNekoManager();
        startNightEffectsTask();
    }

    private void startNightEffectsTask() {
        FileConfiguration config = plugin.getConfig();
        if (!config.getBoolean("night-effects.enabled", true)) {
            return;
        }

        int checkInterval = config.getInt("night-effects.check-interval", 10) * 20; // 转换为游戏刻

        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this::checkNightEffects, 0, checkInterval);
    }

    private void checkNightEffects() {
        FileConfiguration config = plugin.getConfig();
        if (!config.getBoolean("night-effects.enabled", true)) {
            return;
        }

        long startTime = config.getLong("night-effects.start-time", 13000);
        long endTime = config.getLong("night-effects.end-time", 23000);
        long peakTime = config.getLong("night-effects.peak-time", 18000);
        int maxLevel = config.getInt("night-effects.max-level", 5);

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!nekoManager.isNeko(player)) continue;

            World playerWorld = player.getWorld();
            long time = playerWorld.getTime();
            boolean isNight = (time >= startTime && time <= endTime);
            boolean catnipActive = CatNip.isCatnipActive(player);

            if (!isNight) {
                // 白天：只清除夜视；猫薄荷生效时保留速度/跳跃
                player.removePotionEffect(VersionUtils.getNightVisionEffect());
                if (!catnipActive) {
                    player.removePotionEffect(VersionUtils.getSpeedEffect());
                    player.removePotionEffect(VersionUtils.getJumpBoostEffect());
                }
            } else {
                int level = calculateEffectLevel(time, startTime, endTime, peakTime, maxLevel);
                // 猫薄荷生效时，等级与夜间buff相加
                int amplifier = level - 1;
                if (catnipActive) {
                    amplifier += CatNip.getCatnipAmplifier();
                }
                player.addPotionEffect(new PotionEffect(VersionUtils.getNightVisionEffect(), 300, 0, false, false));
                player.addPotionEffect(new PotionEffect(VersionUtils.getSpeedEffect(), 300, amplifier, false, false));
                player.addPotionEffect(new PotionEffect(VersionUtils.getJumpBoostEffect(), 300, amplifier, false, false));
            }
        }
    }

    /**
     * 计算夜间效果的等级
     * 
     * @param currentTime 当前世界时间
     * @param startTime 夜间效果开始时间
     * @param endTime 夜间效果结束时间
     * @param peakTime 夜间效果峰值时间
     * @param maxLevel 最大效果等级
     * @return 计算出的效果等级
     */
    private int calculateEffectLevel(long currentTime, long startTime, long endTime, long peakTime, int maxLevel) {
        if (currentTime == peakTime) {
            return maxLevel;
        }

        long totalDuration = endTime - startTime;
        // 防止除零异常
        if (totalDuration <= 0) {
            return 1;
        }

        long distanceFromPeak;

        if (currentTime < peakTime) {
            distanceFromPeak = peakTime - currentTime;
        } else {
            distanceFromPeak = currentTime - peakTime;
        }

        // 计算距离峰值的百分比
        double halfDuration = totalDuration / 2.0;
        if (halfDuration <= 0) {
            return 1;
        }
        
        double percentage = 1.0 - (double) distanceFromPeak / halfDuration;
        int level = (int) Math.ceil(percentage * maxLevel);

        // 确保等级在合理范围内
        return Math.max(1, Math.min(maxLevel, level));
    }

    /**
     * 监听服务器命令事件，检测时间设置命令并立即更新效果
     */
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onServerCommand(ServerCommandEvent event) {
        String command = event.getCommand().toLowerCase();
        // 检测/time set命令
        if (command.startsWith("time set") || command.startsWith("/time set")) {
            // 延迟一小段时间，确保时间已经实际更改
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, this::checkNightEffects, 1);
        }
    }

    // 当插件禁用时取消任务
    public void cancelTask() {
        if (taskId != 0) {
            Bukkit.getScheduler().cancelTask(taskId);
            // 移除所有猫娘的夜间效果
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (nekoManager.isNeko(player)) {
                    player.removePotionEffect(VersionUtils.getNightVisionEffect());
                    player.removePotionEffect(VersionUtils.getSpeedEffect());
                    player.removePotionEffect(VersionUtils.getJumpBoostEffect());
                }
            }
        }
    }
}