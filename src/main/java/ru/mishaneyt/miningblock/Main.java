package ru.mishaneyt.miningblock;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends JavaPlugin implements Listener {
    public static Economy economy = null;
    public boolean enabled = false;

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
        Bukkit.getPluginManager().registerEvents(new Mining(this), this);

        System.out.println(ChatColor.GREEN + "---------------------------------------------------------------");
        System.out.println(ChatColor.GREEN + "MiningBlock - has been enabled!");
        System.out.println(ChatColor.GREEN + "---------------------------------------------------------------");
        setupEconomy();
    }

    public void onDisable() { saveConfig(); }


    private void setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null)
            economy = economyProvider.getProvider();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) return false;
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("miningblock")) {
                if (sender.hasPermission("miningblock.admin")) {
                    if (args.length == 1 && args[0].equalsIgnoreCase("menu")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                        openGUI(player);
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



    public void openGUI(Player player) {
        Inventory menu = Bukkit.createInventory(null, InventoryType.HOPPER, " ");

        String enableCoal, enableCoalCMD, enableIron, enableIronCMD, enableGold, enableGoldCMD, enableDiamond, enableDiamondCMD, enableEmerald, enableEmeraldCMD;
        if (getConfig().getBoolean("Mining.coal.enable")) {
            enableCoal = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY;
        } else {
            enableCoal = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY;
        }

        if (getConfig().getBoolean("Mining.coal.commandBreak.enable")) {
            enableCoalCMD = ChatColor.GREEN + "✔";
        } else {
            enableCoalCMD = ChatColor.RED + "✖";
        }

        if (getConfig().getBoolean("Mining.iron.enable")) {
            enableIron = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.WHITE;
        } else {
            enableIron = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.WHITE;
        }

        if (getConfig().getBoolean("Mining.iron.commandBreak.enable")) {
            enableIronCMD = ChatColor.GREEN + "✔";
        } else {
            enableIronCMD = ChatColor.RED + "✖";
        }

        if (getConfig().getBoolean("Mining.gold.enable")) {
            enableGold = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW;
        } else {
            enableGold = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW;
        }

        if (getConfig().getBoolean("Mining.gold.commandBreak.enable")) {
            enableGoldCMD = ChatColor.GREEN + "✔";
        } else {
            enableGoldCMD = ChatColor.RED + "✖";
        }

        if (getConfig().getBoolean("Mining.diamond.enable")) {
            enableDiamond = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.AQUA;
        } else {
            enableDiamond = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.AQUA;
        }

        if (getConfig().getBoolean("Mining.diamond.commandBreak.enable")) {
            enableDiamondCMD = ChatColor.GREEN + "✔";
        } else {
            enableDiamondCMD = ChatColor.RED + "✖";
        }

        if (getConfig().getBoolean("Mining.diamond.enable")) {
            enableEmerald = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
        } else {
            enableEmerald = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
        }

        if (getConfig().getBoolean("Mining.diamond.commandBreak.enable")) {
            enableEmeraldCMD = ChatColor.GREEN + "✔";
        } else {
            enableEmeraldCMD = ChatColor.RED + "✖";
        }

        ItemStack coal = new ItemStack(Material.COAL_ORE);
        ItemMeta coal_meta = coal.getItemMeta();
        coal_meta.setDisplayName(enableCoal + " Каменный уголь");
        coal.setItemMeta(coal_meta);
        menu.addItem(coal);
        menu.setItem(0, coal);
        ArrayList<String> coal_lore = new ArrayList<>();
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + getConfig().getString("Mining.coal.delay") + " сек."));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + getConfig().getString("Mining.coal.moneyDrop")));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + getConfig().getString("Mining.coal.expDrop")));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + getConfig().getString("Mining.coal.replaceBlock")));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Команда: " + enableCoalCMD));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));

        coal_meta.setLore(coal_lore);
        coal.setItemMeta(coal_meta);


        ItemStack iron = new ItemStack(Material.IRON_ORE);
        ItemMeta iron_meta = iron.getItemMeta();
        iron_meta.setDisplayName(enableIron + " Железная руда");
        iron.setItemMeta(iron_meta);
        menu.addItem(iron);
        menu.setItem(1, iron);
        ArrayList<String> iron_lore = new ArrayList<>();
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + getConfig().getString("Mining.iron.delay") + " сек."));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + getConfig().getString("Mining.iron.moneyDrop")));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + getConfig().getString("Mining.iron.expDrop")));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + getConfig().getString("Mining.iron.replaceBlock")));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Команда: " + enableIronCMD));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));

        iron_meta.setLore(iron_lore);
        iron.setItemMeta(iron_meta);


        ItemStack gold = new ItemStack(Material.GOLD_ORE);
        ItemMeta gold_meta = gold.getItemMeta();
        gold_meta.setDisplayName(enableGold + " Золотая руда");
        gold.setItemMeta(gold_meta);
        menu.addItem(gold);
        menu.setItem(2, gold);
        ArrayList<String> gold_lore = new ArrayList<>();
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + getConfig().getString("Mining.gold.delay") + " сек."));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + getConfig().getString("Mining.gold.moneyDrop")));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + getConfig().getString("Mining.gold.expDrop")));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + getConfig().getString("Mining.gold.replaceBlock")));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Команда: " + enableGoldCMD));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));

        gold_meta.setLore(gold_lore);
        gold.setItemMeta(gold_meta);


        ItemStack diamond = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta diamond_meta = gold.getItemMeta();
        diamond_meta.setDisplayName(enableDiamond + " Алмазная руда");
        diamond.setItemMeta(diamond_meta);
        menu.addItem(diamond);
        menu.setItem(3, diamond);
        ArrayList<String> diamond_lore = new ArrayList<>();
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + getConfig().getString("Mining.diamond.delay") + " сек."));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + getConfig().getString("Mining.diamond.moneyDrop")));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + getConfig().getString("Mining.diamond.expDrop")));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + getConfig().getString("Mining.diamond.replaceBlock")));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Команда: " + enableDiamondCMD));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));

        diamond_meta.setLore(diamond_lore);
        diamond.setItemMeta(diamond_meta);


        ItemStack emerald = new ItemStack(Material.EMERALD_ORE);
        ItemMeta emerald_meta = emerald.getItemMeta();
        emerald_meta.setDisplayName(enableEmerald + " Изумрудная руда");
        emerald.setItemMeta(emerald_meta);
        menu.addItem(emerald);
        menu.setItem(4, emerald);
        ArrayList<String> emerald_lore = new ArrayList<>();
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + getConfig().getString("Mining.emerald.delay") + " сек."));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + getConfig().getString("Mining.emerald.moneyDrop")));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + getConfig().getString("Mining.emerald.expDrop")));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + getConfig().getString("Mining.emerald.replaceBlock")));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Команда: " + enableEmeraldCMD));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));

        emerald_meta.setLore(emerald_lore);
        emerald.setItemMeta(emerald_meta);


        ItemStack[] menu_item = {coal, iron, gold, diamond, emerald};
        menu.setContents(menu_item);
        player.openInventory(menu);
    }


    public void setEnabledCoal(boolean status) {
        this.enabled = status;
        getConfig().set("Mining.coal.enable", status);
        saveConfig();
    }
    public void setEnabledIron(boolean status) {
        this.enabled = status;
        getConfig().set("Mining.iron.enable", status);
        saveConfig();
    }
    public void setEnabledGold(boolean status) {
        this.enabled = status;
        getConfig().set("Mining.gold.enable", status);
        saveConfig();
    }
    public void setEnabledDiamond(boolean status) {
        this.enabled = status;
        getConfig().set("Mining.diamond.enable", status);
        saveConfig();
    }
    public void setEnabledEmerald(boolean status) {
        this.enabled = status;
        getConfig().set("Mining.emerald.enable", status);
        saveConfig();
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem().getType().equals(Material.COAL_ORE)) {
            if (event.getClick() == ClickType.LEFT) {
                this.setEnabledCoal(true);
                reloadConfig();
                player.updateInventory();
            }
            if (event.getClick() == ClickType.RIGHT) {
                this.setEnabledCoal(false);
                reloadConfig();
                player.updateInventory();
            }
            event.setCancelled(true);
        }

        if (event.getCurrentItem().getType().equals(Material.IRON_ORE)) {
            if (event.getClick() == ClickType.LEFT) {
                this.setEnabledIron(true);
                reloadConfig();
                player.updateInventory();
                event.setCancelled(true);
            }
            if (event.getClick() == ClickType.RIGHT) {
                this.setEnabledIron(false);
                reloadConfig();
                player.updateInventory();
                event.setCancelled(true);
            }
        }

        if (event.getCurrentItem().getType().equals(Material.GOLD_ORE)) {
            if (event.getClick() == ClickType.LEFT) {
                this.setEnabledGold(true);
                reloadConfig();
                player.updateInventory();
                event.setCancelled(true);
            }
            if (event.getClick() == ClickType.RIGHT) {
                this.setEnabledGold(false);
                reloadConfig();
                player.updateInventory();
                event.setCancelled(true);
            }
        }

        if (event.getCurrentItem().getType().equals(Material.DIAMOND_ORE)) {
            if (event.getClick() == ClickType.LEFT) {
                this.setEnabledDiamond(true);
                reloadConfig();
                player.updateInventory();
                event.setCancelled(true);
            }
            if (event.getClick() == ClickType.RIGHT) {
                this.setEnabledDiamond(false);
                reloadConfig();
                player.updateInventory();
                event.setCancelled(true);
            }
        }

        if (event.getCurrentItem().getType().equals(Material.EMERALD_ORE)) {
            if (event.getClick() == ClickType.LEFT) {
                this.setEnabledEmerald(true);
                reloadConfig();
                player.updateInventory();
                event.setCancelled(true);
            }
            if (event.getClick() == ClickType.RIGHT) {
                this.setEnabledEmerald(false);
                reloadConfig();
                player.updateInventory();
                event.setCancelled(true);
            }
        }
    }
}