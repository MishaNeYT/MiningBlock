package ru.mishaneyt.miningblock.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.mishaneyt.miningblock.utils.FileUtil;
import ru.mishaneyt.miningblock.utils.Utils;

import java.util.List;

public class Menu {
    public static boolean enabled = false;

    public static void openGUI(Player player) {
        Inventory menu = Bukkit.createInventory(null, 54, " ");

        ItemStack air = new ItemStack(Material.AIR);
        menu.addItem(air);

        ItemStack coal = new ItemStack(Material.COAL_ORE);
        ItemMeta coal_meta = coal.getItemMeta();

        ItemStack iron = new ItemStack(Material.IRON_ORE);
        ItemMeta iron_meta = iron.getItemMeta();

        ItemStack gold = new ItemStack(Material.GOLD_ORE);
        ItemMeta gold_meta = gold.getItemMeta();

        ItemStack diamond = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta diamond_meta = gold.getItemMeta();

        ItemStack emerald = new ItemStack(Material.EMERALD_ORE);
        ItemMeta emerald_meta = emerald.getItemMeta();

        ItemStack lapis = new ItemStack(Material.LAPIS_ORE);
        ItemMeta lapis_meta = lapis.getItemMeta();

        ItemStack redstone = new ItemStack(Material.REDSTONE_ORE);
        ItemMeta redstone_meta = lapis.getItemMeta();

        ItemStack quartz = new ItemStack(Material.QUARTZ_ORE);
        ItemMeta quartz_meta = lapis.getItemMeta();

        ItemStack reload = new ItemStack(Material.ANVIL);
        ItemMeta reload_meta = reload.getItemMeta();

        ItemStack vault = new ItemStack(Material.GOLD_INGOT);
        ItemMeta vault_meta = vault.getItemMeta();

        ItemStack music = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta music_meta = music.getItemMeta();

        ItemStack edit = new ItemStack(Material.TNT);
        ItemMeta edit_meta = edit.getItemMeta();

        ItemStack title = new ItemStack(Material.ITEM_FRAME);
        ItemMeta title_meta = title.getItemMeta();

        ItemStack actionbar = new ItemStack(Material.PAINTING);
        ItemMeta actionbar_meta = actionbar.getItemMeta();

        ItemStack chat = new ItemStack(Material.PAPER);
        ItemMeta chat_meta = chat.getItemMeta();


        coal_meta.setDisplayName(MenuSettings.enableCoal() + " Каменный уголь");
        menu.addItem(coal);
        List<String> coal_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("COAL.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("COAL.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("COAL.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("COAL.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuSettings.enableParticleCoal(),
                "",
                "§8▸ §7Дроп: " + MenuSettings.enableCoalDrop(),
                "§8▸ §7Авто-подбор: " + MenuSettings.enableCoalAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuSettings.enableCoalCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        coal.setItemMeta(coal_meta);
        coal_meta.setLore(coal_lore);
        coal.setItemMeta(coal_meta);


        iron_meta.setDisplayName(MenuSettings.enableIron() + " Железная руда");
        menu.addItem(iron);
        List<String> iron_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("IRON.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("IRON.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("IRON.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("IRON.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuSettings.enableParticleIron(),
                "",
                "§8▸ §7Дроп: " + MenuSettings.enableIronDrop(),
                "§8▸ §7Авто-подбор: " + MenuSettings.enableIronAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuSettings.enableIronCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        iron.setItemMeta(iron_meta);
        iron_meta.setLore(iron_lore);
        iron.setItemMeta(iron_meta);


        gold_meta.setDisplayName(MenuSettings.enableGold() + " Золотая руда");
        menu.addItem(gold);
        List<String> gold_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("GOLD.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("GOLD.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("GOLD.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("GOLD.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuSettings.enableParticleGold(),
                "",
                "§8▸ §7Дроп: " + MenuSettings.enableGoldDrop(),
                "§8▸ §7Авто-подбор: " + MenuSettings.enableGoldAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuSettings.enableGoldCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        gold.setItemMeta(gold_meta);
        gold_meta.setLore(gold_lore);
        gold.setItemMeta(gold_meta);


        diamond_meta.setDisplayName(MenuSettings.enableDiamond() + " Алмазная руда");
        menu.addItem(diamond);
        List<String> diamond_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("DIAMOND.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("DIAMOND.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("DIAMOND.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("DIAMOND.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuSettings.enableParticleDiamond(),
                "",
                "§8▸ §7Дроп: " + MenuSettings.enableDiamondDrop(),
                "§8▸ §7Авто-подбор: " + MenuSettings.enableDiamondAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuSettings.enableDiamondCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        diamond.setItemMeta(diamond_meta);
        diamond_meta.setLore(diamond_lore);
        diamond.setItemMeta(diamond_meta);


        emerald_meta.setDisplayName(MenuSettings.enableEmerald() + " Изумрудная руда");
        menu.addItem(emerald);
        List<String> emerald_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("EMERALD.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("EMERALD.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("EMERALD.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("EMERALD.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuSettings.enableParticleEmerald(),
                "",
                "§8▸ §7Дроп: " + MenuSettings.enableEmeraldDrop(),
                "§8▸ §7Авто-подбор: " + MenuSettings.enableEmeraldAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuSettings.enableEmeraldCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        emerald.setItemMeta(emerald_meta);
        emerald_meta.setLore(emerald_lore);
        emerald.setItemMeta(emerald_meta);


        lapis_meta.setDisplayName(MenuSettings.enableLapis() + " Лазуритовая руда");
        menu.addItem(lapis);
        List<String> lapis_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("LAPIS.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("LAPIS.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("LAPIS.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("LAPIS.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuSettings.enableParticleLapis(),
                "",
                "§8▸ §7Дроп: " + MenuSettings.enableLapisDrop(),
                "§8▸ §7Авто-подбор: " + MenuSettings.enableLapisAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuSettings.enableLapisCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        lapis.setItemMeta(lapis_meta);
        lapis_meta.setLore(lapis_lore);
        lapis.setItemMeta(lapis_meta);


        redstone_meta.setDisplayName(MenuSettings.enableRedstone() + " Красная руда");
        menu.addItem(redstone);
        List<String> redstone_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("REDSTONE.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("REDSTONE.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("REDSTONE.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("REDSTONE.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuSettings.enableParticleRedstone(),
                "",
                "§8▸ §7Дроп: " + MenuSettings.enableRedstoneDrop(),
                "§8▸ §7Авто-подбор: " + MenuSettings.enableRedstoneAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuSettings.enableRedstoneCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        redstone.setItemMeta(redstone_meta);
        redstone_meta.setLore(redstone_lore);
        redstone.setItemMeta(redstone_meta);


        quartz_meta.setDisplayName(MenuSettings.enableQuartz() + " Кварцевая руда");
        menu.addItem(quartz);
        List<String> quartz_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("QUARTZ.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("QUARTZ.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("QUARTZ.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("QUARTZ.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuSettings.enableParticleQuartz(),
                "",
                "§8▸ §7Дроп: " + MenuSettings.enableQuartzDrop(),
                "§8▸ §7Авто-подбор: " + MenuSettings.enableQuartzAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuSettings.enableQuartzCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        quartz.setItemMeta(quartz_meta);
        quartz_meta.setLore(quartz_lore);
        quartz.setItemMeta(quartz_meta);


        reload_meta.setDisplayName("§aПерезагрузить плагин");
        menu.addItem(reload);
        List<String> reload_lore = List.of(
                "§e▸ Нажмите, чтобы перезагрузить!"
        );
        reload.setItemMeta(reload_meta);
        reload_meta.setLore(reload_lore);
        reload.setItemMeta(reload_meta);


        vault_meta.setDisplayName(MenuSettings.enableVault() + " Поддержка Vault");
        menu.addItem(vault);
        List<String> vault_lore = List.of(
                "§cРекомендую поставить Vault,",
                "§cчтобы работала эта функция!",
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        vault.setItemMeta(vault_meta);
        vault_meta.setLore(vault_lore);
        vault.setItemMeta(vault_meta);


        music_meta.setDisplayName(MenuSettings.enableMusic() + " Звук сломанной руды");
        menu.addItem(music);
        List<String> music_lore = List.of(
                "§8▸ §7Тип музыки: §f(" + Utils.getString("Sound.SoundPickup") + "§f)",
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        music.setItemMeta(music_meta);
        music_meta.setLore(music_lore);
        music.setItemMeta(music_meta);


        edit_meta.setDisplayName(MenuSettings.enableEditOre() + " Редактирования руд");
        menu.addItem(edit);
        List<String> edit_lore = List.of(
                "§7С помощью этой опции, админы",
                "§7смогут редактировать расположения",
                "§7руд в шахте.",
                "",
                "§7Права: §c" + Utils.getString("Settings.Permission"),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        edit.setItemMeta(edit_meta);
        edit_meta.setLore(edit_lore);
        edit.setItemMeta(edit_meta);


        title_meta.setDisplayName(MenuSettings.enableTitle() + " Титлы (TitleOnPickup)");
        menu.addItem(title);
        List<String> title_lore = List.of(
                Utils.color("&8▸ &7Главный: &f(" + Utils.getString("TitleOnPickup.Title") + "&f)"),
                Utils.color("&8▸ &7Нижний: &f(" + Utils.getString("TitleOnPickup.Subtitle") + "&f)"),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        title.setItemMeta(title_meta);
        title_meta.setLore(title_lore);
        title.setItemMeta(title_meta);


        actionbar_meta.setDisplayName(MenuSettings.enableActionbar() + " Нижний бар (Actionbar)");
        menu.addItem(actionbar);
        List<String> actionbar_lore = List.of(
                "§8▸ §7Сообщение:",
                Utils.color("&8- &f(" + Utils.getString("Actionbar.Message") + "&f)"),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        actionbar.setItemMeta(actionbar_meta);
        actionbar_meta.setLore(actionbar_lore);
        actionbar.setItemMeta(actionbar_meta);


        chat_meta.setDisplayName(MenuSettings.enableChat() + " Cообщение в чат (MessageToChat)");
        menu.addItem(chat);
        List<String> chat_lore = List.of(
                "§8▸ §7Сообщение:",
                Utils.color("&8- &f(" + Utils.getStringList("MessageToChat.Message") + "&f)"),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        chat.setItemMeta(chat_meta);
        chat_meta.setLore(chat_lore);
        chat.setItemMeta(chat_meta);


        ItemStack[] menu_item = {air, air, air, air, air, air, air, air, air, air, coal, iron, gold, diamond, emerald,
                air, reload, air, air, lapis, redstone, quartz, air, air, air, air, air, air, air, air, air, air, air, air, air,
                air, air, vault, music, edit, air, title, actionbar, chat};
        menu.setContents(menu_item);
        player.openInventory(menu);
    }
}