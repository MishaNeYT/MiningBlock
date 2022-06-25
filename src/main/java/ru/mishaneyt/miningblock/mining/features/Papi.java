package ru.mishaneyt.miningblock.mining.features;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.config.ConfigManager;

public class Papi {

    public static void connect(Player p, String s) {
        if (ConfigManager.getConfig().getBoolean("Settings.SoftDepends.Placeholder"))
            PlaceholderAPI.setPlaceholders(p, s);
    }
}