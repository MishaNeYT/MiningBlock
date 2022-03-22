package ru.mishaneyt.miningblock.utils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.commands.Commands;
import ru.mishaneyt.miningblock.commands.CommandsTab;
import ru.mishaneyt.miningblock.mining.MiningListener;

public class LoaderPlugin {
    public static void onLoadPlugin() {
        onCommands();
        onEvents();
        setupPlaceholder();
        setupEconomy();
    }

    public static void MessageConsole() {
        Logger.empty("");
        Logger.empty("&2 ---------------------------------------------------------------");
        Logger.empty("&b  MiningBlock "  + Main.getInstance().getDescription().getVersion() + " &f- успешно включён!");
        Logger.empty("&f  Создатель: &bGhostSetuper");
        Logger.empty("&2 ---------------------------------------------------------------");
        Logger.empty("");
    }

    static void onCommands() {
        Main.getInstance().getCommand("miningblock").setExecutor(new Commands());
        Main.getInstance().getCommand("miningblock").setTabCompleter(new CommandsTab());
    }

    static void onEvents() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new MiningListener(), Main.getInstance());
    }

    static void setupPlaceholder() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(Main.getInstance(), Main.getInstance());
        } else {
            Logger.warn("Внимание! У вас не установлен PlaceholderAPI. Рекомендую его поставить!");
        }
    }

    static void setupEconomy() {
        if (Main.getInstance().getServer().getPluginManager().getPlugin("Vault") == null) return;

        RegisteredServiceProvider<Economy> rsp = Main.getInstance().getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return;

        Main.economy = rsp.getProvider();
    }
}