package ru.mishaneyt.miningblock;

import org.bukkit.Bukkit;
import ru.mishaneyt.miningblock.commands.Commands;
import ru.mishaneyt.miningblock.gui.MenuClick;
import ru.mishaneyt.miningblock.mining.*;
import ru.mishaneyt.miningblock.utils.Logger;

public class Register {

    public static void getCommand() {
        Main.getInstance().getCommand("miningblock").setExecutor(new Commands());
        Main.getInstance().getCommand("miningblock").setTabCompleter(Main.getPlugin(Main.class));
    }

    public static void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new MiningCoal(), Main.getPlugin(Main.class));
        Bukkit.getPluginManager().registerEvents(new MiningIron(), Main.getPlugin(Main.class));
        Bukkit.getPluginManager().registerEvents(new MiningGold(), Main.getPlugin(Main.class));
        Bukkit.getPluginManager().registerEvents(new MiningDiamond(), Main.getPlugin(Main.class));
        Bukkit.getPluginManager().registerEvents(new MiningEmerald(), Main.getPlugin(Main.class));

        Bukkit.getPluginManager().registerEvents(new MiningLapis(), Main.getPlugin(Main.class));
        Bukkit.getPluginManager().registerEvents(new MiningRedstone(), Main.getPlugin(Main.class));
        Bukkit.getPluginManager().registerEvents(new MiningQuartz(), Main.getPlugin(Main.class));

        Bukkit.getPluginManager().registerEvents(new MenuClick(), Main.getPlugin(Main.class));
    }

    public static void MessageConsole() {
        Logger.empty("");
        Logger.empty("&2---------------------------------------------------------------");
        Logger.empty("&fMiningBlock "  + Main.getInstance().getDescription().getVersion() + " - успешно включён!");
        Logger.empty("&fСоздатель: GhostSetuper");
        Logger.empty("&2---------------------------------------------------------------");
        Logger.empty("");
    }
}