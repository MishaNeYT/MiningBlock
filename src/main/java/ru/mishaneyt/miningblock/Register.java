package ru.mishaneyt.miningblock;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import ru.mishaneyt.miningblock.commands.Commands;
import ru.mishaneyt.miningblock.commands.CommandsTab;
import ru.mishaneyt.miningblock.gui.MenuClick;
import ru.mishaneyt.miningblock.mining.*;
import ru.mishaneyt.miningblock.utils.Logger;

public class Register {
    static final Main plugin = Main.getPlugin(Main.class);

    public static void getCommand() {
        plugin.getCommand("miningblock").setExecutor(new Commands());
        plugin.getCommand("miningblock").setTabCompleter(new CommandsTab());
    }

    public static void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new MiningCoal(), plugin);
        Bukkit.getPluginManager().registerEvents(new MiningIron(), plugin);
        Bukkit.getPluginManager().registerEvents(new MiningGold(), plugin);
        Bukkit.getPluginManager().registerEvents(new MiningDiamond(), plugin);
        Bukkit.getPluginManager().registerEvents(new MiningEmerald(), plugin);
        Bukkit.getPluginManager().registerEvents(new MiningLapis(), plugin);
        Bukkit.getPluginManager().registerEvents(new MiningRedstone(), plugin);
        Bukkit.getPluginManager().registerEvents(new MiningQuartz(), plugin);

        Bukkit.getPluginManager().registerEvents(new MenuClick(), plugin);
    }

    public static void MessageConsole() {
        Logger.empty("");
        Logger.empty("&2---------------------------------------------------------------");
        Logger.empty("&bMiningBlock "  + plugin.getDescription().getVersion() + " &f- успешно включён!");
        Logger.empty("&fСоздатель: &bGhostSetuper");
        Logger.empty("&2---------------------------------------------------------------");
        Logger.empty("");
    }

    public static void setupPlaceholder() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(plugin, plugin);
        } else {
            Logger.warn("Could not find PlaceholderAPI!");
        }
    }

    public static void setupEconomy() {
        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            return;
        }
        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return;
        }
        Main.economy = rsp.getProvider();
    }
}