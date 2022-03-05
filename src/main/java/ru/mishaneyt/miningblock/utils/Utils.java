package ru.mishaneyt.miningblock.utils;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;

import java.util.List;

public class Utils {
    static final Main plugin = Main.getPlugin(Main.class);

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String colorString(String string) {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(string));
    }

    public static String getString(String configStringMsg) {
        return plugin.getConfig().getString(configStringMsg);
    }

    public static List<String> getStringList(String configStringListMsg) {
        return plugin.getConfig().getStringList(configStringListMsg);
    }

    public static void getSound(Player player) {
        player.playSound(player.getLocation(), Sound.valueOf(Utils.getString("Sound.SoundPickup")), 1.0F, 1.0F);
    }
}