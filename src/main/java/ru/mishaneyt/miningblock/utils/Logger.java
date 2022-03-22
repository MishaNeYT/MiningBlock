package ru.mishaneyt.miningblock.utils;

import org.bukkit.Bukkit;
import ru.mishaneyt.miningblock.Main;

public class Logger {

    public static void empty(String m) {
        Bukkit.getConsoleSender().sendMessage(UtilsManager.getColor(m));
    }

    public static void warn(String m) {
        Bukkit.getConsoleSender().sendMessage("§e[" + Main.getInstance().getName() + "] " + m);
    }
}