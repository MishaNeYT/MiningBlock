package ru.mishaneyt.miningblock;

import org.bukkit.Bukkit;
import ru.mishaneyt.miningblock.commands.Commands;
import ru.mishaneyt.miningblock.commands.CommandsTab;
import ru.mishaneyt.miningblock.gui.MenuClick;
import ru.mishaneyt.miningblock.mining.*;
import ru.mishaneyt.miningblock.utils.Logger;

public class Register {

    public static void getCommand() {
        Main.getInstance().getCommand("miningblock").setExecutor(new Commands());
        Main.getInstance().getCommand("miningblock").setTabCompleter(new CommandsTab());
    }

    public static void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new MiningCoal(), Main.getPluginMain());
        Bukkit.getPluginManager().registerEvents(new MiningIron(), Main.getPluginMain());
        Bukkit.getPluginManager().registerEvents(new MiningGold(), Main.getPluginMain());
        Bukkit.getPluginManager().registerEvents(new MiningDiamond(), Main.getPluginMain());
        Bukkit.getPluginManager().registerEvents(new MiningEmerald(), Main.getPluginMain());

        Bukkit.getPluginManager().registerEvents(new MiningLapis(), Main.getPluginMain());
        Bukkit.getPluginManager().registerEvents(new MiningRedstone(), Main.getPluginMain());
        Bukkit.getPluginManager().registerEvents(new MiningQuartz(), Main.getPluginMain());

        Bukkit.getPluginManager().registerEvents(new MenuClick(), Main.getPluginMain());
    }

    public static void MessageConsole() {
        Logger.empty("");
        Logger.empty("&2---------------------------------------------------------------");
        Logger.empty("&bMiningBlock "  + Main.getInstance().getDescription().getVersion() + " &f- успешно включён!");
        Logger.empty("&fСоздатель: &bGhostSetuper");
        Logger.empty("&2---------------------------------------------------------------");
        Logger.empty("");
    }
}