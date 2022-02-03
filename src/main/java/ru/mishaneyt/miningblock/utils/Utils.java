package ru.mishaneyt.miningblock.utils;

import org.bukkit.ChatColor;
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
}