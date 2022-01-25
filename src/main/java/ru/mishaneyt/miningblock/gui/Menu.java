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

        String enableCoal, enableCoalCMD, enableCoalDrop, enableIron, enableIronCMD, enableIronDrop, enableGold,
                enableGoldCMD, enableGoldDrop, enableDiamond, enableDiamondCMD, enableDiamondDrop, enableEmerald,
                enableEmeraldCMD, enableEmeraldDrop, enableVault, enableMusic, enableTitle, enableActionbar,
                enableChat, enableParticleCoal, enableParticleIron, enableParticleGold, enableParticleDiamond,
                enableParticleEmerald, enableCoalAutoPickup, enableIronAutoPickup, enableGoldAutoPickup,
                enableDiamondAutoPickup, enableEmeraldAutoPickup;

        if (Main.getInstance().getConfig().getBoolean("Mining.COAL.Enable")) {
            enableCoal = "§8[§a✔§8]§7";
        } else {
            enableCoal = "§8[§c✖§8]§7";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.COAL.CommandBreak.enable")) {
            enableCoalCMD = "§a✔";
        } else {
            enableCoalCMD = "§c✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.COAL.Drop.Enable")) {
            enableCoalDrop = "§a✔";
        } else {
            enableCoalDrop = "§c✖";
        }
        if (Main.getInstance().getConfig().getBoolean("Mining.COAL.AutoPickup.Enable")) {
            enableCoalAutoPickup = "§a✔";
        } else {
            enableCoalAutoPickup = "§c✖";
        }



        if (Main.getInstance().getConfig().getBoolean("Mining.IRON.Enable")) {
            enableIron = "§8[§a✔§8]§f";
        } else {
            enableIron = "§8[§c✖§8]§f";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.IRON.CommandBreak.enable")) {
            enableIronCMD = "§a✔";
        } else {
            enableIronCMD = "§c✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.IRON.Drop.Enable")) {
            enableIronDrop = "§a✔";
        } else {
            enableIronDrop = "§c✖";
        }
        if (Main.getInstance().getConfig().getBoolean("Mining.IRON.AutoPickup.Enable")) {
            enableIronAutoPickup = "§a✔";
        } else {
            enableIronAutoPickup = "§c✖";
        }



        if (Main.getInstance().getConfig().getBoolean("Mining.GOLD.Enable")) {
            enableGold = "§8[§a✔§8]§e";
        } else {
            enableGold = "§8[§c✖§8]§e";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.GOLD.CommandBreak.enable")) {
            enableGoldCMD = "§a✔";
        } else {
            enableGoldCMD = "§c✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.GOLD.Drop.Enable")) {
            enableGoldDrop = "§a✔";
        } else {
            enableGoldDrop = "§c✖";
        }
        if (Main.getInstance().getConfig().getBoolean("Mining.GOLD.AutoPickup.Enable")) {
            enableGoldAutoPickup = "§a✔";
        } else {
            enableGoldAutoPickup = "§c✖";
        }



        if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.Enable")) {
            enableDiamond = "§8[§a✔§8]§b";
        } else {
            enableDiamond = "§8[§c✖§8]§b";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.CommandBreak.enable")) {
            enableDiamondCMD = "§a✔";
        } else {
            enableDiamondCMD = "§c✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.Drop.Enable")) {
            enableDiamondDrop = "§a✔";
        } else {
            enableDiamondDrop = "§c✖";
        }
        if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.AutoPickup.Enable")) {
            enableDiamondAutoPickup = "§a✔";
        } else {
            enableDiamondAutoPickup = "§c✖";
        }



        if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.Enable")) {
            enableEmerald = "§8[§a✔§8]§a";
        } else {
            enableEmerald = "§8[§c✖§8]§a";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.CommandBreak.enable")) {
            enableEmeraldCMD = "§a✔";
        } else {
            enableEmeraldCMD = "§c✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.EMERALD.Drop.Enable")) {
            enableEmeraldDrop = "§a✔";
        } else {
            enableEmeraldDrop = "§c✖";
        }
        if (Main.getInstance().getConfig().getBoolean("Mining.EMERALD.AutoPickup.Enable")) {
            enableEmeraldAutoPickup = "§a✔";
        } else {
            enableEmeraldAutoPickup = "§c✖";
        }



        if (Main.getInstance().getConfig().getBoolean("Settings.EnableVault")) {
            enableVault = "§8[§a✔§8]§6";
        } else {
            enableVault = "§8[§c✖§8]§6";
        }

        if (Main.getInstance().getConfig().getBoolean("Settings.EnableSoundPickup")) {
            enableMusic = "§8[§a✔§8]§9";
        } else {
            enableMusic = "§8[§c✖§8]§9";
        }

        if (Main.getInstance().getConfig().getBoolean("TitleOnPickup.EnableTitles")) {
            enableTitle = "§8[§a✔§8]§a";
        } else {
            enableTitle = "§8[§c✖§8]§a";
        }

        if (Main.getInstance().getConfig().getBoolean("Actionbar.EnableActionbar")) {
            enableActionbar = "§8[§a✔§8]§a";
        } else {
            enableActionbar = "§8[§c✖§8]§a";
        }

        if (Main.getInstance().getConfig().getBoolean("MessageToChat.EnableMessageToChat")) {
            enableChat = "§8[§a✔§8]§a";
        } else {
            enableChat = "§8[§c✖§8]§a";
        }


        if (Main.getInstance().getConfig().getBoolean("Mining.COAL.ParticleBreak.enable")) {
            enableParticleCoal = "§a✔";
        } else {
            enableParticleCoal = "§c✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.IRON.ParticleBreak.enable")) {
            enableParticleIron = "§a✔";
        } else {
            enableParticleIron = "§c✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.GOLD.ParticleBreak.enable")) {
            enableParticleGold = "§a✔";
        } else {
            enableParticleGold = "§c✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.DIAMOND.ParticleBreak.enable")) {
            enableParticleDiamond = "§a✔";
        } else {
            enableParticleDiamond = "§c✖";
        }

        if (Main.getInstance().getConfig().getBoolean("Mining.EMERALD.ParticleBreak.enable")) {
            enableParticleEmerald = "§a✔";
        } else {
            enableParticleEmerald = "§c✖";
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
        coal_lore.add("§8▸ §7Задержка: §f" + Main.getInstance().getConfig().getString("Mining.COAL.Delay") + " сек.");
        coal_lore.add("§8▸ §7Деньги: §e+" + Main.getInstance().getConfig().getString("Mining.COAL.MoneyDrop"));
        coal_lore.add("§8▸ §7Опыт: §3+" + Main.getInstance().getConfig().getString("Mining.COAL.ExpDrop"));
        coal_lore.add("");
        coal_lore.add("§8▸ §7Замена на: §6" + Main.getInstance().getConfig().getString("Mining.COAL.ReplaceBlock"));
        coal_lore.add("§8▸ §7Частица: " + enableParticleCoal);
        coal_lore.add("");
        coal_lore.add("§8▸ §7Дроп: " + enableCoalDrop);
        coal_lore.add("§8▸ §7Авто-подбор: " + enableCoalAutoPickup);
        coal_lore.add("");
        coal_lore.add("§8▸ §7Команда: " + enableCoalCMD);
        coal_lore.add("");
        coal_lore.add("§e▸ ЛКМ, чтобы включить!");
        coal_lore.add("§e▸ ПКМ, чтобы отключить!");

        coal_meta.setLore(coal_lore);
        coal.setItemMeta(coal_meta);


        ItemStack iron = new ItemStack(Material.IRON_ORE);
        ItemMeta iron_meta = iron.getItemMeta();
        iron_meta.setDisplayName(enableIron + " Железная руда");
        iron.setItemMeta(iron_meta);
        menu.addItem(iron);
        menu.setItem(11, iron);
        ArrayList<String> iron_lore = new ArrayList<>();
        iron_lore.add("§8▸ §7Задержка: §f" + Main.getInstance().getConfig().getString("Mining.IRON.Delay") + " сек.");
        iron_lore.add("§8▸ §7Деньги: §e+" + Main.getInstance().getConfig().getString("Mining.IRON.MoneyDrop"));
        iron_lore.add("§8▸ §7Опыт: §3+" + Main.getInstance().getConfig().getString("Mining.IRON.ExpDrop"));
        iron_lore.add("");
        iron_lore.add("§8▸ §7Замена на: §6" + Main.getInstance().getConfig().getString("Mining.IRON.ReplaceBlock"));
        iron_lore.add("§8▸ §7Частица: " + enableParticleIron);
        iron_lore.add("");
        iron_lore.add("§8▸ §7Дроп: " + enableIronDrop);
        iron_lore.add("§8▸ §7Авто-подбор: " + enableIronAutoPickup);
        iron_lore.add("");
        iron_lore.add("§8▸ §7Команда: " + enableIronCMD);
        iron_lore.add("");
        iron_lore.add("§e▸ ЛКМ, чтобы включить!");
        iron_lore.add("§e▸ ПКМ, чтобы отключить!");

        iron_meta.setLore(iron_lore);
        iron.setItemMeta(iron_meta);


        ItemStack gold = new ItemStack(Material.GOLD_ORE);
        ItemMeta gold_meta = gold.getItemMeta();
        gold_meta.setDisplayName(enableGold + " Золотая руда");
        gold.setItemMeta(gold_meta);
        menu.addItem(gold);
        menu.setItem(12, gold);
        ArrayList<String> gold_lore = new ArrayList<>();
        gold_lore.add("§8▸ §7Задержка: §f" + Main.getInstance().getConfig().getString("Mining.GOLD.Delay") + " сек.");
        gold_lore.add("§8▸ §7Деньги: §e+" + Main.getInstance().getConfig().getString("Mining.GOLD.MoneyDrop"));
        gold_lore.add("§8▸ §7Опыт: §3+" + Main.getInstance().getConfig().getString("Mining.GOLD.ExpDrop"));
        gold_lore.add("");
        gold_lore.add("§8▸ §7Замена на: §6" + Main.getInstance().getConfig().getString("Mining.GOLD.ReplaceBlock"));
        gold_lore.add("§8▸ §7Частица: " + enableParticleGold);
        gold_lore.add("");
        gold_lore.add("§8▸ §7Дроп: " + enableGoldDrop);
        gold_lore.add("§8▸ §7Авто-подбор: " + enableGoldAutoPickup);
        gold_lore.add("");
        gold_lore.add("§8▸ §7Команда: " + enableGoldCMD);
        gold_lore.add("");
        gold_lore.add("§e▸ ЛКМ, чтобы включить!");
        gold_lore.add("§e▸ ПКМ, чтобы отключить!");

        gold_meta.setLore(gold_lore);
        gold.setItemMeta(gold_meta);


        ItemStack diamond = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta diamond_meta = gold.getItemMeta();
        diamond_meta.setDisplayName(enableDiamond + " Алмазная руда");
        diamond.setItemMeta(diamond_meta);
        menu.addItem(diamond);
        menu.setItem(13, diamond);
        ArrayList<String> diamond_lore = new ArrayList<>();
        diamond_lore.add("§8▸ §7Задержка: §f" + Main.getInstance().getConfig().getString("Mining.DIAMOND.Delay") + " сек.");
        diamond_lore.add("§8▸ §7Деньги: §e+" + Main.getInstance().getConfig().getString("Mining.DIAMOND.MoneyDrop"));
        diamond_lore.add("§8▸ §7Опыт: §3+" + Main.getInstance().getConfig().getString("Mining.DIAMOND.ExpDrop"));
        diamond_lore.add("");
        diamond_lore.add("§8▸ §7Замена на: §6" + Main.getInstance().getConfig().getString("Mining.DIAMOND.ReplaceBlock"));
        diamond_lore.add("§8▸ §7Частица: " + enableParticleDiamond);
        diamond_lore.add("");
        diamond_lore.add("§8▸ §7Дроп: " + enableDiamondDrop);
        diamond_lore.add("§8▸ §7Авто-подбор: " + enableDiamondAutoPickup);
        diamond_lore.add("");
        diamond_lore.add("§8▸ §7Команда: " + enableDiamondCMD);
        diamond_lore.add("");
        diamond_lore.add("§e▸ ЛКМ, чтобы включить!");
        diamond_lore.add("§e▸ ПКМ, чтобы отключить!");

        diamond_meta.setLore(diamond_lore);
        diamond.setItemMeta(diamond_meta);


        ItemStack emerald = new ItemStack(Material.EMERALD_ORE);
        ItemMeta emerald_meta = emerald.getItemMeta();
        emerald_meta.setDisplayName(enableEmerald + " Изумрудная руда");
        emerald.setItemMeta(emerald_meta);
        menu.addItem(emerald);
        menu.setItem(14, emerald);
        ArrayList<String> emerald_lore = new ArrayList<>();
        emerald_lore.add("§8▸ §7Задержка: §f" + Main.getInstance().getConfig().getString("Mining.EMERALD.Delay") + " сек.");
        emerald_lore.add("§8▸ §7Деньги: §e+" + Main.getInstance().getConfig().getString("Mining.EMERALD.MoneyDrop"));
        emerald_lore.add("§8▸ §7Опыт: §3+" + Main.getInstance().getConfig().getString("Mining.EMERALD.ExpDrop"));
        emerald_lore.add("");
        emerald_lore.add("§8▸ §7Замена на: §6" + Main.getInstance().getConfig().getString("Mining.EMERALD.ReplaceBlock"));
        emerald_lore.add("§8▸ §7Частица: " + enableParticleEmerald);
        emerald_lore.add("");
        emerald_lore.add("§8▸ §7Дроп: " + enableEmeraldDrop);
        emerald_lore.add("§8▸ §7Авто-подбор: " + enableEmeraldAutoPickup);
        emerald_lore.add("");
        emerald_lore.add("§8▸ §7Команда: " + enableEmeraldCMD);
        emerald_lore.add("");
        emerald_lore.add("§e▸ ЛКМ, чтобы включить!");
        emerald_lore.add("§e▸ ПКМ, чтобы отключить!");

        emerald_meta.setLore(emerald_lore);
        emerald.setItemMeta(emerald_meta);


        ItemStack reload = new ItemStack(Material.ANVIL);
        ItemMeta reload_meta = reload.getItemMeta();
        reload_meta.setDisplayName("§aПерезагрузить плагин");
        reload.setItemMeta(reload_meta);
        menu.addItem(reload);
        menu.setItem(16, reload);
        ArrayList<String> reload_lore = new ArrayList<>();
        reload_lore.add("§e▸ Нажмите, чтобы перезагрузить!");
        reload_meta.setLore(reload_lore);
        reload.setItemMeta(reload_meta);


        ItemStack vault = new ItemStack(Material.GOLD_INGOT);
        ItemMeta vault_meta = vault.getItemMeta();
        vault_meta.setDisplayName(enableVault + " Поддержка Vault");
        vault.setItemMeta(vault_meta);
        menu.addItem(vault);
        menu.setItem(17, vault);
        ArrayList<String> vault_lore = new ArrayList<>();
        vault_lore.add("§cРекомендую поставить Vault,");
        vault_lore.add("§cчтобы работала эта функция!");
        vault_lore.add("");
        vault_lore.add("§e▸ ЛКМ, чтобы включить!");
        vault_lore.add("§e▸ ПКМ, чтобы отключить!");
        vault_meta.setLore(vault_lore);
        vault.setItemMeta(vault_meta);


        ItemStack music = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta music_meta = music.getItemMeta();
        music_meta.setDisplayName(enableMusic + " Звук сломанной руды");
        music.setItemMeta(music_meta);
        menu.addItem(music);
        menu.setItem(18, music);
        ArrayList<String> music_lore = new ArrayList<>();
        music_lore.add("§8▸ §7Тип музыки: §f(" + Main.getInstance().getConfig().getString("Settings.SoundPickup") + "§f)");
        music_lore.add("");
        music_lore.add("§e▸ ЛКМ, чтобы включить!");
        music_lore.add("§e▸ ПКМ, чтобы включить!");
        music_meta.setLore(music_lore);
        music.setItemMeta(music_meta);


        ItemStack title = new ItemStack(Material.ITEM_FRAME);
        ItemMeta title_meta = title.getItemMeta();
        title_meta.setDisplayName(enableTitle + " Титлы (TitleOnPickup)");
        title.setItemMeta(title_meta);
        menu.addItem(title);
        menu.setItem(19, title);
        ArrayList<String> title_lore = new ArrayList<>();
        title_lore.add(ChatColor.translateAlternateColorCodes('&',"&8▸ &7Главный: &f(" + Main.getInstance().getConfig().getString("TitleOnPickup.Title") + "&f)"));
        title_lore.add(ChatColor.translateAlternateColorCodes('&',"&8▸ &7Нижний: &f(" + Main.getInstance().getConfig().getString("TitleOnPickup.Subtitle") + "&f)"));
        title_lore.add("");
        title_lore.add("§e▸ ЛКМ, чтобы включить!");
        title_lore.add("§e▸ ПКМ, чтобы отключить!");
        title_meta.setLore(title_lore);
        title.setItemMeta(title_meta);


        ItemStack actionbar = new ItemStack(Material.PAINTING);
        ItemMeta actionbar_meta = actionbar.getItemMeta();
        actionbar_meta.setDisplayName(enableActionbar + " Нижний бар (Actionbar)");
        actionbar.setItemMeta(actionbar_meta);
        menu.addItem(actionbar);
        menu.setItem(20, actionbar);
        ArrayList<String> actionbar_lore = new ArrayList<>();
        actionbar_lore.add("§8▸ §7Сообщение:");
        actionbar_lore.add(ChatColor.translateAlternateColorCodes('&',"&8- &f(" + Main.getInstance().getConfig().getString("Actionbar.Message") + "&f)"));
        actionbar_lore.add("");
        actionbar_lore.add("§e▸ ЛКМ, чтобы включить!");
        actionbar_lore.add("§e▸ ПКМ, чтобы отключить!");
        actionbar_meta.setLore(actionbar_lore);
        actionbar.setItemMeta(actionbar_meta);


        ItemStack chat = new ItemStack(Material.PAPER);
        ItemMeta chat_meta = chat.getItemMeta();
        chat_meta.setDisplayName(enableChat + " Cообщение в чат (MessageToChat)");
        chat.setItemMeta(chat_meta);
        menu.addItem(chat);
        menu.setItem(21, chat);
        ArrayList<String> chat_lore = new ArrayList<>();
        chat_lore.add("§8▸ §7Сообщение:");
        chat_lore.add(ChatColor.translateAlternateColorCodes('&', "&8- &f(" + Main.getInstance().getConfig().getString("MessageToChat.Message") + "&f)"));
        chat_lore.add("");
        chat_lore.add("§e▸ ЛКМ, чтобы включить!");
        chat_lore.add("§e▸ ПКМ, чтобы отключить!");
        chat_meta.setLore(chat_lore);
        chat.setItemMeta(chat_meta);


        ItemStack[] menu_item = {air, air, air, air, air, air, air, air, air, air, coal, iron, gold, diamond, emerald, air, reload, air, air, air, air, air, air, air, air, air, air, air, vault, music, air, air, title, actionbar, chat};
        menu.setContents(menu_item);
        player.openInventory(menu);
    }


    public void setEnabledCoal(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Mining.COAL.Enable", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledIron(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Mining.IRON.Enable", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledGold(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Mining.GOLD.Enable", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledDiamond(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Mining.DIAMOND.Enable", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledEmerald(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Mining.EMERALD.Enable", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledVault(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Settings.EnableVault", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledMusic(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Settings.EnableSoundPickup", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledTitle(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("TitleOnPickup.EnableTitles", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledActionbar(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("Actionbar.EnableActionbar", status);
        Main.getInstance().saveConfig();
    }

    public void setEnabledChat(boolean status) {
        this.enabled = status;
        Main.getInstance().getConfig().set("MessageToChat.EnableMessageToChat", status);
        Main.getInstance().saveConfig();
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() == InventoryType.CHEST && event.getInventory().getTitle().equals(" ")) {
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() == null)
                return;
            if (event.getCurrentItem().getItemMeta() == null)
                return;

            if (event.getCurrentItem().getType().equals(Material.COAL_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledCoal(true);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledCoal(false);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.IRON_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledIron(true);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledIron(false);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.GOLD_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledGold(true);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledGold(false);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.DIAMOND_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledDiamond(true);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledDiamond(false);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.EMERALD_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledEmerald(true);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledEmerald(false);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            }

            else if (event.getCurrentItem().getType().equals(Material.ANVIL)) {
                event.setCancelled(true);
                Main.getInstance().reloadConfig();
                Main.getInstance().saveConfig();
                player.closeInventory();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Messages.Reload")));
            } else if (event.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledVault(true);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledVault(false);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.NOTE_BLOCK)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledMusic(true);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledMusic(false);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.ITEM_FRAME)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledTitle(true);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledTitle(false);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.PAINTING)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledActionbar(true);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledActionbar(false);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.PAPER)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    this.setEnabledChat(true);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    this.setEnabledChat(false);
                    Main.getInstance().saveConfig();
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            }
        }
    }
}