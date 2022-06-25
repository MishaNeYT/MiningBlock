package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Sound {

    public static void play(Player p) {
        if (ConfigManager.getConfig().getBoolean("SoundPickup.Enabled")) {
            p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(ConfigManager.getConfig().getString("SoundPickup.Sound")), 1.0F, 1.0F);
        }
    }
}