package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class PlaySound {

    public static void playSound(Player p) {
        if (ConfigManager.SOUND_ENABLE) {
            p.playSound(p.getLocation(), Sound.valueOf(ConfigManager.SOUND), 1.0F, 1.0F);
        }
    }
}