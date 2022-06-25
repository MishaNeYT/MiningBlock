package ru.mishaneyt.miningblock;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.mining.MiningListener;
import ru.mishaneyt.miningblock.utils.Loader;
import ru.mishaneyt.miningblock.utils.Logger;

public class Main extends JavaPlugin {
    private static Main instance;
    public Economy economy = null;

    @Override
    public void onEnable() {
        instance = this;

        // Load Depends and SoftDepends
        Loader loader = new Loader(this);
        loader.setupEconomy();
        loader.setupPlaceholder();

        // Check configurations
        ConfigManager configManager = new ConfigManager(this);
        configManager.checkConfigurations();

        // Register events
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MiningListener(this), this);

        // Register commands
        loader.register();

        // Info enable
        Logger.info("");
        Logger.info("§2 ---------------------------------------------------------------");
        Logger.info("§b  MiningBlock "  + getDescription().getVersion() + " §f- успешно включён!");
        Logger.info("§f  Подробная информация: https://spigotmc.ru/resources/850/");
        Logger.info("§2 ---------------------------------------------------------------");
        Logger.info("");
    }

    public static synchronized Main getInstance() {
        return instance;
    }

    public Economy getEconomy() {
        return this.economy;
    }
}