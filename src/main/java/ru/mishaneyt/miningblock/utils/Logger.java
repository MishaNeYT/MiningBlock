package ru.mishaneyt.miningblock.utils;

import org.bukkit.Bukkit;

public class Logger {

    public static void info(String message) {
        Bukkit.getConsoleSender().sendMessage("§b[MiningBlock] §f" + message);
    }

    public static void warn(String message) {
        Bukkit.getConsoleSender().sendMessage("§e[MiningBlock] §e" + message);
    }

    public static void error(String message) {
        Bukkit.getConsoleSender().sendMessage("§c[MiningBlock] §c" + message);
    }
}