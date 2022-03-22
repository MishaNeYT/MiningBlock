package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.utils.Logger;

public class PlaySound {

    public static void playSound(Player p) {
        String sound = ConfigManager.SOUND;

        if (ConfigManager.SOUND_ENABLE) {
            if (sound != null) {
                p.playSound(p.getLocation(), Sound.valueOf(sound), 1.0F, 1.0F);
            } else {
                Logger.warn("Пожалуйста, проверьте звук в config.yml. Ваша версия ядра, может его не поддерживать.");
            }
        }
    }
}