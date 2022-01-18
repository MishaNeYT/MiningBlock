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
    public boolean enabled = false;

    public static void openGUI(Player player) {
        Inventory menu = Bukkit.createInventory(null, 45, " ");

        String enableCoal, enableCoalCMD, enableCoalDrop, enableIron, enableIronCMD, enableIronDrop, enableGold, enableGoldCMD, enableGoldDrop, enableDiamond, enableDiamondCMD, enableDiamondDrop, enableEmerald, enableEmeraldCMD, enableEmeraldDrop, enableVault, enableMusic, enableTitle, enableActionbar, enableChat;
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

        if (Main.getInstance().getConfig().getBoolean("Settings.enableVault")) {
            enableVault = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.GOLD;
        } else {
            enableVault = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.GOLD;
        }

        if (Main.getInstance().getConfig().getBoolean("Settings.enableSoundPickup")) {
            enableMusic = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.BLUE;
        } else {
            enableMusic = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.BLUE;
        }

        if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.enableTitles")) {
            enableTitle = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
        } else {
            enableTitle = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
        }

        if (Main.getInstance().getConfig().getBoolean("Actionbar.enableActionbar")) {
            enableActionbar = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
        } else {
            enableActionbar = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
        }

        if (Main.getInstance().getConfig().getBoolean("MessageToChat.enableMessageToChat")) {
            enableChat = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "✔" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
        } else {
            enableChat = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "✖" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
        }


        ItemStack air = new ItemStack(Material.AIR);
        menu.addItem(air);
        menu.setItem(0, air);


        ItemStack coal = new ItemStack(Material.COAL_ORE);
        ItemMeta coal_meta = coal.getItemMeta();
        coal_meta.setDisplayName(enableCoal + " Каменный уголь");
        coal.setItemMeta(coal_meta);
        menu.addItem(coal);
        menu.setItem(10, coal);
        ArrayList<String> coal_lore = new ArrayList<>();
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + Main.getInstance().getConfig().getString("Mining.coal.delay") + " сек."));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + Main.getInstance().getConfig().getString("Mining.coal.moneyDrop")));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + Main.getInstance().getConfig().getString("Mining.coal.expDrop")));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + Main.getInstance().getConfig().getString("Mining.coal.replaceBlock")));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Дроп: " + enableCoalDrop));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Команда: " + enableCoalCMD));
        coal_lore.add("");
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        coal_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));

        coal_meta.setLore(coal_lore);
        coal.setItemMeta(coal_meta);


        ItemStack iron = new ItemStack(Material.IRON_ORE);
        ItemMeta iron_meta = iron.getItemMeta();
        iron_meta.setDisplayName(enableIron + " Железная руда");
        iron.setItemMeta(iron_meta);
        menu.addItem(iron);
        menu.setItem(11, iron);
        ArrayList<String> iron_lore = new ArrayList<>();
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + Main.getInstance().getConfig().getString("Mining.iron.delay") + " сек."));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + Main.getInstance().getConfig().getString("Mining.iron.moneyDrop")));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + Main.getInstance().getConfig().getString("Mining.iron.expDrop")));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + Main.getInstance().getConfig().getString("Mining.iron.replaceBlock")));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Дроп: " + enableIronDrop));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Команда: " + enableIronCMD));
        iron_lore.add("");
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        iron_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));

        iron_meta.setLore(iron_lore);
        iron.setItemMeta(iron_meta);


        ItemStack gold = new ItemStack(Material.GOLD_ORE);
        ItemMeta gold_meta = gold.getItemMeta();
        gold_meta.setDisplayName(enableGold + " Золотая руда");
        gold.setItemMeta(gold_meta);
        menu.addItem(gold);
        menu.setItem(12, gold);
        ArrayList<String> gold_lore = new ArrayList<>();
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + Main.getInstance().getConfig().getString("Mining.gold.delay") + " сек."));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + Main.getInstance().getConfig().getString("Mining.gold.moneyDrop")));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + Main.getInstance().getConfig().getString("Mining.gold.expDrop")));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + Main.getInstance().getConfig().getString("Mining.gold.replaceBlock")));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Дроп: " + enableGoldDrop));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Команда: " + enableGoldCMD));
        gold_lore.add("");
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        gold_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));

        gold_meta.setLore(gold_lore);
        gold.setItemMeta(gold_meta);


        ItemStack diamond = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta diamond_meta = gold.getItemMeta();
        diamond_meta.setDisplayName(enableDiamond + " Алмазная руда");
        diamond.setItemMeta(diamond_meta);
        menu.addItem(diamond);
        menu.setItem(13, diamond);
        ArrayList<String> diamond_lore = new ArrayList<>();
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + Main.getInstance().getConfig().getString("Mining.diamond.delay") + " сек."));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + Main.getInstance().getConfig().getString("Mining.diamond.moneyDrop")));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + Main.getInstance().getConfig().getString("Mining.diamond.expDrop")));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + Main.getInstance().getConfig().getString("Mining.diamond.replaceBlock")));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Дроп: " + enableDiamondDrop));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Команда: " + enableDiamondCMD));
        diamond_lore.add("");
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        diamond_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));

        diamond_meta.setLore(diamond_lore);
        diamond.setItemMeta(diamond_meta);


        ItemStack emerald = new ItemStack(Material.EMERALD_ORE);
        ItemMeta emerald_meta = emerald.getItemMeta();
        emerald_meta.setDisplayName(enableEmerald + " Изумрудная руда");
        emerald.setItemMeta(emerald_meta);
        menu.addItem(emerald);
        menu.setItem(14, emerald);
        ArrayList<String> emerald_lore = new ArrayList<>();
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Задержка: &f" + Main.getInstance().getConfig().getString("Mining.emerald.delay") + " сек."));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Деньги: &e+" + Main.getInstance().getConfig().getString("Mining.emerald.moneyDrop")));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Опыт: &3+" + Main.getInstance().getConfig().getString("Mining.emerald.expDrop")));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Замена на: &6" + Main.getInstance().getConfig().getString("Mining.emerald.replaceBlock")));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Дроп: " + enableEmeraldDrop));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&8▸ &7Команда: " + enableEmeraldCMD));
        emerald_lore.add("");
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        emerald_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));

        emerald_meta.setLore(emerald_lore);
        emerald.setItemMeta(emerald_meta);


        ItemStack reload = new ItemStack(Material.ANVIL);
        ItemMeta reload_meta = reload.getItemMeta();
        reload_meta.setDisplayName(ChatColor.GREEN + "Перезагрузить плагин");
        reload.setItemMeta(reload_meta);
        menu.addItem(reload);
        menu.setItem(16, reload);
        ArrayList<String> reload_lore = new ArrayList<>();
        reload_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ Нажмите, чтобы перезагрузить!"));
        reload_meta.setLore(reload_lore);
        reload.setItemMeta(reload_meta);


        ItemStack vault = new ItemStack(Material.GOLD_INGOT);
        ItemMeta vault_meta = vault.getItemMeta();
        vault_meta.setDisplayName(enableVault + " Поддержка Vault");
        vault.setItemMeta(vault_meta);
        menu.addItem(vault);
        menu.setItem(17, vault);
        ArrayList<String> vault_lore = new ArrayList<>();
        vault_lore.add(ChatColor.translateAlternateColorCodes('&', "&cРекомендую поставить Vault,"));
        vault_lore.add(ChatColor.translateAlternateColorCodes('&', "&cчтобы работала эта функция!"));
        vault_lore.add("");
        vault_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        vault_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));
        vault_meta.setLore(vault_lore);
        vault.setItemMeta(vault_meta);


        ItemStack music = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta music_meta = music.getItemMeta();
        music_meta.setDisplayName(enableMusic + " Звук сломанной руды");
        music.setItemMeta(music_meta);
        menu.addItem(music);
        menu.setItem(18, music);
        ArrayList<String> music_lore = new ArrayList<>();
        music_lore.add(ChatColor.translateAlternateColorCodes('&', "&7▸ &7Тип музыки: &f(" + Main.getInstance().getConfig().getString("Settings.soundPickup") + "&f)"));
        music_lore.add("");
        music_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        music_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы включить!"));
        music_meta.setLore(music_lore);
        music.setItemMeta(music_meta);


        ItemStack title = new ItemStack(Material.ITEM_FRAME);
        ItemMeta title_meta = title.getItemMeta();
        title_meta.setDisplayName(enableTitle + " Титлы (TitleOnPickup)");
        title.setItemMeta(title_meta);
        menu.addItem(title);
        menu.setItem(19, title);
        ArrayList<String> title_lore = new ArrayList<>();
        title_lore.add(ChatColor.translateAlternateColorCodes('&', "&7▸ &7Главный: &f(" + Main.getInstance().getConfig().getString("TitleOnPickup.title") + "&f)"));
        title_lore.add(ChatColor.translateAlternateColorCodes('&', "&7▸ &7Нижний: &f(" + Main.getInstance().getConfig().getString("TitleOnPickup.subtitle") + "&f)"));
        title_lore.add("");
        title_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        title_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));
        title_meta.setLore(title_lore);
        title.setItemMeta(title_meta);


        ItemStack actionbar = new ItemStack(Material.PAINTING);
        ItemMeta actionbar_meta = actionbar.getItemMeta();
        actionbar_meta.setDisplayName(enableActionbar + " Нижний бар (Actionbar)");
        actionbar.setItemMeta(actionbar_meta);
        menu.addItem(actionbar);
        menu.setItem(20, actionbar);
        ArrayList<String> actionbar_lore = new ArrayList<>();
        actionbar_lore.add(ChatColor.translateAlternateColorCodes('&', "&7▸ Сообщение:"));
        actionbar_lore.add(ChatColor.translateAlternateColorCodes('&', "&7- &f(" + Main.getInstance().getConfig().getString("Actionbar.message") + "&f)"));
        actionbar_lore.add("");
        actionbar_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        actionbar_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));
        actionbar_meta.setLore(actionbar_lore);
        actionbar.setItemMeta(actionbar_meta);


        ItemStack chat = new ItemStack(Material.PAPER);
        ItemMeta chat_meta = chat.getItemMeta();
        chat_meta.setDisplayName(enableChat + " Cообщение в чат (MessageToChat)");
        chat.setItemMeta(chat_meta);
        menu.addItem(chat);
        menu.setItem(21, chat);
        ArrayList<String> chat_lore = new ArrayList<>();
        chat_lore.add(ChatColor.translateAlternateColorCodes('&', "&7▸ Сообщение:"));
        chat_lore.add(ChatColor.translateAlternateColorCodes('&', "&7- &f(" + Main.getInstance().getConfig().getString("MessageToChat.message") + "&f)"));
        chat_lore.add("");
        chat_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ЛКМ, чтобы включить!"));
        chat_lore.add(ChatColor.translateAlternateColorCodes('&', "&e▸ ПКМ, чтобы отключить!"));
        chat_meta.setLore(chat_lore);
        chat.setItemMeta(chat_meta);


        ItemStack[] menu_item = {air, air, air, air, air, air, air, air, air, air, coal, iron, gold, diamond, emerald, air, reload, air, air, air, air, air, air, air, air, air, air, air, vault, music, air, air, title, actionbar, chat};
        menu.setContents(menu_item);
        player.openInventory(menu);
    }


    public void setEnabledCoal(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Mining.coal.enable", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledIron(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Mining.iron.enable", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledGold(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Mining.gold.enable", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledDiamond(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Mining.diamond.enable", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledEmerald(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Mining.emerald.enable", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledVault(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Settings.enableVault", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledMusic(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Settings.enableSoundPickup", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledTitle(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("TitleOnPickup.enableTitles", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledActionbar(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Actionbar.enableActionbar", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledChat(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("MessageToChat.enableMessageToChat", status);
        Main.getInstance().saveConfig();
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() == InventoryType.CHEST && event.getInventory().getTitle().equals(" ")) {
            event.setCancelled(true);

            if (event.getCurrentItem().getType().equals(Material.COAL_ORE)) {
                Player player = (Player) event.getWhoClicked();
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledCoal(true);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledCoal(false);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.IRON_ORE)) {
                Player player = (Player) event.getWhoClicked();
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledIron(true);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledIron(false);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.GOLD_ORE)) {
                Player player = (Player) event.getWhoClicked();
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledGold(true);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledGold(false);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.DIAMOND_ORE)) {
                Player player = (Player) event.getWhoClicked();
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledDiamond(true);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledDiamond(false);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.EMERALD_ORE)) {
                Player player = (Player) event.getWhoClicked();
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledEmerald(true);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledEmerald(false);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            }


            else if (event.getCurrentItem().getType().equals(Material.AIR)) {
                Player player = (Player) event.getWhoClicked();
                player.updateInventory();
            }

            else if (event.getCurrentItem().getType().equals(Material.ANVIL)) {
                Player player = (Player) event.getWhoClicked();
                Main.getInstance().reloadConfig();
                Main.getInstance().saveConfig();
                player.updateInventory();
                player.closeInventory();
                Menu.openGUI(player);
            } else if (event.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
                Player player = (Player) event.getWhoClicked();
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledVault(true);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledVault(false);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.NOTE_BLOCK)) {
                Player player = (Player) event.getWhoClicked();
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledMusic(true);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledMusic(false);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.ITEM_FRAME)) {
                Player player = (Player) event.getWhoClicked();
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledTitle(true);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledTitle(false);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.PAINTING)) {
                Player player = (Player) event.getWhoClicked();
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledActionbar(true);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledActionbar(false);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.PAPER)) {
                Player player = (Player) event.getWhoClicked();
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledChat(true);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledChat(false);
                    Main.getInstance().reloadConfig();
                    player.updateInventory();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            }
        }
    }
}