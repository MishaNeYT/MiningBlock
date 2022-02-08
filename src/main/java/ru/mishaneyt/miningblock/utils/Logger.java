package ru.mishaneyt.miningblock.utils;

import org.bukkit.Bukkit;
import ru.mishaneyt.miningblock.Main;

public class Logger {
    public static void empty(String msg) {
        Bukkit.getConsoleSender().sendMessage(Utils.color(msg));
    }

    public static void warn(String msg) {
        Bukkit.getConsoleSender().sendMessage(Utils.color("§e[" +  Main.getInstance().getDescription().getName() + "/WARN] " + msg));
    }
}