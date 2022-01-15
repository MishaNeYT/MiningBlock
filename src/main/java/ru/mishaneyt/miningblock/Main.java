package ru.mishaneyt.miningblock;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import org.jetbrains.annotations.NotNull;
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

    public static void setInstance(Main instance) {
        Main.instance = instance;
    }

    public void onEnable() {
        saveDefaultConfig();

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        getCommand("miningblock").setExecutor(this);
        getCommand("miningblock").setTabCompleter(this);
        Bukkit.getPluginManager().registerEvents(new MiningOre(this), this);

        Bukkit.getPluginManager().registerEvents(new Menu(this), this);

        System.out.println(ChatColor.GREEN + "---------------------------------------------------------------");
        System.out.println(ChatColor.GREEN + "MiningBlock - has been enabled!");
        System.out.println(ChatColor.GREEN + "---------------------------------------------------------------");

        setInstance(this);
        setupEconomy();
        saveConfig();
    }

    public void onDisable() { saveConfig(); }


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


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("miningblock")) {
            if (sender.hasPermission("miningblock.admin")) {
                if (args.length == 1 && args[0].equalsIgnoreCase("menu")) {
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                    Menu.openGUI(player);
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.noPerm")));
            }


            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("miningblock.admin")) {
                    this.reloadConfig();
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.reload")));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.noPerm")));
                }
            }
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("reload", "menu");
        }
        return new ArrayList<>();
    }
}