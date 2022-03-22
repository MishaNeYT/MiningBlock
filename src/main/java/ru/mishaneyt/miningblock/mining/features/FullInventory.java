package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class FullInventory {

    public static void sendTitle(Player p) {
        if (ConfigManager.FULLINV_ENABLE) {
            p.sendTitle(ConfigManager.FULLINV_TITLE, ConfigManager.FULLINV_SUBTITLE, 0, 80, 0);
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
        }
    }
}