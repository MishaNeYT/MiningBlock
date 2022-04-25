package ru.mishaneyt.miningblock;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ru.mishaneyt.miningblock.commands.Commands;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.config.ConfigUtils;
import ru.mishaneyt.miningblock.mining.MiningListener;
import ru.mishaneyt.miningblock.utils.LoaderPlugin;

public class Main extends JavaPlugin implements Listener {
    private static Main instance = null;
    public static Economy economy = null;

    @Override
    public void onEnable() {
        instance = this;

        ConfigUtils.onCheckConfig(this);

        ConfigManager.onLoad();
        LoaderPlugin.onLoadPlugin(this);

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MiningListener(), this);

        new Commands(this);

        LoaderPlugin.MessageConsole();
    }

    public static Main getInstance() {
        return instance;
    }

    public static Economy getEconomy() {
        return economy;
    }
}