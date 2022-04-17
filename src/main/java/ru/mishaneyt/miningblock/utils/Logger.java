package ru.mishaneyt.miningblock.utils;

import org.bukkit.Bukkit;

public class Logger {

    public static void empty(String m) {
        Bukkit.getConsoleSender().sendMessage(UtilsManager.getColor(m));
    }

    public static void warn(String m) {
        Bukkit.getConsoleSender().sendMessage("§e[MiningBlock] " + m);
    }

    public static void error(String m) {
        Bukkit.getConsoleSender().sendMessage("§c[MiningBlock] " + m);
    }
}