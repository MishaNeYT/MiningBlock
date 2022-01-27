package ru.mishaneyt.miningblock;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import ru.mishaneyt.miningblock.commands.Commands;
import ru.mishaneyt.miningblock.gui.Menu;
import ru.mishaneyt.miningblock.mining.MiningOre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends JavaPlugin implements Listener, CommandExecutor {
    private static Main instance;
    public static Economy economy = null;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        saveDefaultConfig();
        instance = this;

        setupPlaceholder();
        setupEconomy();
        getCommand();
        registerEvents();

        System.out.println(ChatColor.GREEN + "---------------------------------------------------------------");
        System.out.println(ChatColor.GREEN + "MiningBlock - успешно включён, приятного использования!");
        System.out.println(ChatColor.GREEN + "---------------------------------------------------------------");

        saveConfig();
    }

    private void getCommand() {
        getCommand("miningblock").setExecutor(new Commands());
        getCommand("miningblock").setTabCompleter(this);
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new MiningOre(), this);
        Bukkit.getPluginManager().registerEvents(new Menu(), this);
    }

    private void setupPlaceholder() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
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

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("reload", "menu");
        }
        return new ArrayList<>();
    }
}