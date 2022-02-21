package ru.mishaneyt.miningblock.utils;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;

import java.util.List;

public class Utils {
    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String getString(String configStringMsg) {
        return Main.getInstance().getConfig().getString(configStringMsg);
    }

    public static List<String> getStringList(String configStringListMsg) {
        return Main.getInstance().getConfig().getStringList(configStringListMsg);
    }

    public static void getSound(Player player) {
        player.playSound(player.getLocation(), Sound.valueOf(Utils.getString("Sound.SoundPickup")), 1.0F, 1.0F);
    }
}