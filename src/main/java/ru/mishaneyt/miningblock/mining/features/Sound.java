package ru.mishaneyt.miningblock.mining.features;

import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Sound {
    private final Player player;

    public Sound(Player player) {
        this.player = player;
    }

    public void play() {
        if (ConfigManager.getConfig().getBoolean("SoundPickup.Enabled")) {
            this.player.playSound(this.player.getLocation(), org.bukkit.Sound.valueOf(ConfigManager.getConfig().getString("SoundPickup.Sound")), 1.0F, 1.0F);
        }
    }

    public void errorPlay() {
        if (ConfigManager.getConfig().getBoolean("SoundPickup.Enabled")) {
            this.player.playSound(this.player.getLocation(), org.bukkit.Sound.valueOf(ConfigManager.getConfig().getString("SoundPickup.ErrorSound")), 1.0F, 1.0F);
        }
    }
}