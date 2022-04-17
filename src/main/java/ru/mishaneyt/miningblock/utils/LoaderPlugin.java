package ru.mishaneyt.miningblock.utils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import ru.mishaneyt.miningblock.Main;

public class LoaderPlugin {
    public static void onLoadPlugin(Main main) {
        setupPlaceholder(main);
        setupEconomy(main);
    }

    public static void MessageConsole() {
        Logger.empty("");
        Logger.empty("&2 ---------------------------------------------------------------");
        Logger.empty("&b  MiningBlock "  + Main.getInstance().getDescription().getVersion() + " &f- успешно включён!");
        Logger.empty("&b  Подробная информация: https://spigotmc.ru/resources/850/");
        Logger.empty("&2 ---------------------------------------------------------------");
        Logger.empty("");
    }

    static void setupPlaceholder(Main main) {
        PluginManager pm = Bukkit.getPluginManager();

        if (pm.getPlugin("PlaceholderAPI") != null) {
            pm.registerEvents(main, main);
        } else Logger.error("У вас не установлен PlaceholderAPI. Рекомендую его поставить!");
    }

    static void setupEconomy(Main main) {
        if (main.getServer().getPluginManager().getPlugin("Vault") == null) return;

        RegisteredServiceProvider<Economy> rsp = main.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return;

        Main.economy = rsp.getProvider();
    }
}