package ru.mishaneyt.miningblock.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.mishaneyt.miningblock.Main;

import java.util.ArrayList;

public class Menu implements Listener {
    private final Main plugin;
    public boolean enabled = false;

    public Menu(Main plugin) {
        this.plugin = plugin;
    }

    public static void openGUI(Player player) {
        Inventory menu = Bukkit.createInventory(null, InventoryType.HOPPER, " ");

        String enableCoal, enableCoalCMD, enableCoalDrop, enableIron, enableIronCMD, enableIronDrop, enableGold, enableGoldCMD, enableGoldDrop, enableDiamond, enableDiamondCMD, enableDiamondDrop, enableEmerald, enableEmeraldCMD, enableEmeraldDrop;
        if (Main.getInstance().getConfig().getBoolean("Mining.coal.enable")) {
            enableCoal = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY;
        } else {
            enableCoal = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY;
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.coal.commandBreak.enable")) {
            enableCoalCMD = ChatColor.GREEN + "✔";
        } else {
            enableCoalCMD = ChatColor.RED + "✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.coal.enableDropBlock")) {
            enableCoalDrop = ChatColor.GREEN + "✔";
        } else {
            enableCoalDrop = ChatColor.RED + "✖";
        }



        if (Main.getInstance().getConfig().getBoolean("Mining.iron.enable")) {
            enableIron = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.WHITE;
        } else {
            enableIron = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.WHITE;
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.iron.commandBreak.enable")) {
            enableIronCMD = ChatColor.GREEN + "✔";
        } else {
            enableIronCMD = ChatColor.RED + "✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.iron.enableDropBlock")) {
            enableIronDrop = ChatColor.GREEN + "✔";
        } else {
            enableIronDrop = ChatColor.RED + "✖";
        }



        if (Main.getInstance().getConfig().getBoolean("Mining.gold.enable")) {
            enableGold = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW;
        } else {
            enableGold = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW;
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.gold.commandBreak.enable")) {
            enableGoldCMD = ChatColor.GREEN + "✔";
        } else {
            enableGoldCMD = ChatColor.RED + "✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.gold.enableDropBlock")) {
            enableGoldDrop = ChatColor.GREEN + "✔";
        } else {
            enableGoldDrop = ChatColor.RED + "✖";
        }



        if (Main.getInstance().getConfig().getBoolean("Mining.diamond.enable")) {
            enableDiamond = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.AQUA;
        } else {
            enableDiamond = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.AQUA;
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.diamond.commandBreak.enable")) {
            enableDiamondCMD = ChatColor.GREEN + "✔";
        } else {
            enableDiamondCMD = ChatColor.RED + "✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.diamond.enableDropBlock")) {
            enableDiamondDrop = ChatColor.GREEN + "✔";
        } else {
            enableDiamondDrop = ChatColor.RED + "✖";
        }



        if (Main.getInstance().getConfig().getBoolean("Mining.diamond.enable")) {
            enableEmerald = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
        } else {
            enableEmerald = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.diamond.commandBreak.enable")) {
            enableEmeraldCMD = ChatColor.GREEN + "✔";
        } else {
            enableEmeraldCMD = ChatColor.RED + "✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.emerald.enableDropBlock")) {
            enableEmeraldDrop = ChatColor.GREEN + "✔";
        } else {
            enableEmeraldDrop = ChatColor.RED + "✖";
        }


        ItemStack coal = new ItemStack(Material.COAL_ORE);
        ItemMeta coal_meta = coal.getItemMeta();
        coal_meta.setDisplayName(enableCoal + " Каменный уголь");
        coal.setItemMeta(coal_meta);
        menu.addItem(coal);
        menu.setItem(0, coal);
        ArrayList<String> coal_lore = new ArrayList<>();
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + Main.getInstance().getConfig().getString("Mining.coal.delay") + " сек."));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + Main.getInstance().getConfig().getString("Mining.coal.moneyDrop")));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + Main.getInstance().getConfig().getString("Mining.coal.expDrop")));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + Main.getInstance().getConfig().getString("Mining.coal.replaceBlock")));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Дроп: " + enableCoalDrop));
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
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + Main.getInstance().getConfig().getString("Mining.iron.delay") + " сек."));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + Main.getInstance().getConfig().getString("Mining.iron.moneyDrop")));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + Main.getInstance().getConfig().getString("Mining.iron.expDrop")));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + Main.getInstance().getConfig().getString("Mining.iron.replaceBlock")));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Дроп: " + enableIronDrop));
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
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + Main.getInstance().getConfig().getString("Mining.gold.delay") + " сек."));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + Main.getInstance().getConfig().getString("Mining.gold.moneyDrop")));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + Main.getInstance().getConfig().getString("Mining.gold.expDrop")));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + Main.getInstance().getConfig().getString("Mining.gold.replaceBlock")));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Дроп: " + enableGoldDrop));
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
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + Main.getInstance().getConfig().getString("Mining.diamond.delay") + " сек."));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + Main.getInstance().getConfig().getString("Mining.diamond.moneyDrop")));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + Main.getInstance().getConfig().getString("Mining.diamond.expDrop")));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + Main.getInstance().getConfig().getString("Mining.diamond.replaceBlock")));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Дроп: " + enableDiamondDrop));
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
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + Main.getInstance().getConfig().getString("Mining.emerald.delay") + " сек."));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + Main.getInstance().getConfig().getString("Mining.emerald.moneyDrop")));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + Main.getInstance().getConfig().getString("Mining.emerald.expDrop")));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + Main.getInstance().getConfig().getString("Mining.emerald.replaceBlock")));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Дроп: " + enableEmeraldDrop));
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
        this.plugin.getConfig().set("Mining.coal.enable", status);
        this.plugin.saveConfig();
    }
    public void setEnabledIron(boolean status) {
        this.enabled = status;
        this.plugin.getConfig().set("Mining.iron.enable", status);
        this.plugin.saveConfig();
    }
    public void setEnabledGold(boolean status) {
        this.enabled = status;
        this.plugin.getConfig().set("Mining.gold.enable", status);
        this.plugin.saveConfig();
    }
    public void setEnabledDiamond(boolean status) {
        this.enabled = status;
        this.plugin.getConfig().set("Mining.diamond.enable", status);
        this.plugin.saveConfig();
    }
    public void setEnabledEmerald(boolean status) {
        this.enabled = status;
        this.plugin.getConfig().set("Mining.emerald.enable", status);
        this.plugin.saveConfig();
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() == InventoryType.HOPPER) {
            if (event.getCurrentItem().getType() == Material.COAL_ORE) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledCoal(true);
                    this.plugin.reloadConfig();
                    player.updateInventory();
                }
                if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledCoal(false);
                    this.plugin.reloadConfig();
                    player.updateInventory();
                }
                event.setCancelled(true);
            }
        }

        if (event.getInventory().getType() == InventoryType.HOPPER) {
            if (event.getCurrentItem().getType() == Material.IRON_ORE) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledIron(true);
                    this.plugin.reloadConfig();
                    player.updateInventory();
                    event.setCancelled(true);
                }
                if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledIron(false);
                    this.plugin.reloadConfig();
                    player.updateInventory();
                    event.setCancelled(true);
                }
            }
        }

        if (event.getInventory().getType() == InventoryType.HOPPER) {
            if (event.getCurrentItem().getType() == Material.GOLD_ORE) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledGold(true);
                    this.plugin.reloadConfig();
                    player.updateInventory();
                    event.setCancelled(true);
                }
                if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledGold(false);
                    this.plugin.reloadConfig();
                    player.updateInventory();
                    event.setCancelled(true);
                }
            }
        }

        if (event.getInventory().getType() == InventoryType.HOPPER) {
            if (event.getCurrentItem().getType() == Material.DIAMOND_ORE) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledDiamond(true);
                    this.plugin.reloadConfig();
                    player.updateInventory();
                    event.setCancelled(true);
                }
                if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledDiamond(false);
                    this.plugin.reloadConfig();
                    player.updateInventory();
                    event.setCancelled(true);
                }
            }
        }

        if (event.getInventory().getType() == InventoryType.HOPPER) {
            if (event.getCurrentItem().getType() == Material.EMERALD_ORE) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledEmerald(true);
                    this.plugin.reloadConfig();
                    player.updateInventory();
                    event.setCancelled(true);
                }
                if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledEmerald(false);
                    this.plugin.reloadConfig();
                    player.updateInventory();
                    event.setCancelled(true);
                }
            }
        }
    }
}
