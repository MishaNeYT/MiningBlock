package ru.mishaneyt.miningblock;

import org.bukkit.ChatColor;

public class Utils {
    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String getString(String configStringMsg) {
        return Main.getInstance().getConfig().getString(configStringMsg);
    }

    public static Integer getInt(Integer configIntMsg) {
        return Main.getInstance().getConfig().getInt(String.valueOf(configIntMsg));
    }

    public static Boolean getBoolean(Boolean configBooleanMsg) {
        return Main.getInstance().getConfig().getBoolean(String.valueOf(configBooleanMsg));
    }
}