package ru.mishaneyt.miningblock;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import ru.mishaneyt.miningblock.utils.Logger;

public class Main extends JavaPlugin implements Listener {
    private static Main instance;
    public static Economy economy = null;

    public static Main getInstance() {
        return instance;
    }
    public static Main getPluginMain() {
        return Main.getPlugin(Main.class);
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        saveResource("mining.yml", false);
        instance = this;

        Register.MessageConsole();

        setupPlaceholder();
        setupEconomy();

        Register.getCommand();
        Register.registerEvents();

        saveConfig();
    }

    private void setupPlaceholder() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            Logger.warn("&cCould not find PlaceholderAPI!");
        }
    }

    private void setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return;
        }
        economy = rsp.getProvider();
    }
}