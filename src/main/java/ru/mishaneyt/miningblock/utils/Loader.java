package ru.mishaneyt.miningblock.utils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import ru.mishaneyt.miningblock.Main;

public class Loader {
    public final Main main;

    public Loader(Main main) {
        this.main = main;
    }

    public void setupPlaceholder() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            Logger.warn("У вас не установлен PlaceholderAPI. Рекомендую его поставить.");
        }
    }

    public void setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            Logger.error("У вас не установлен Vault. Рекомендую его поставить. Без него плагин не будет работать.");
            Bukkit.getPluginManager().disablePlugin(this.main);
            return;
        }

        RegisteredServiceProvider<Economy> rsp = this.main.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return;

        this.main.economy = rsp.getProvider();
    }
}