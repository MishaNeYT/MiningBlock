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
        coal_meta.setLore(coal_lore);
        coal.setItemMeta(coal_meta);
        menu.setItem(10, coal);


        iron_meta.setDisplayName(MenuSettings.enableIron() + " Железная руда");
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
        iron_meta.setLore(iron_lore);
        iron.setItemMeta(iron_meta);
        menu.setItem(11, iron);


        gold_meta.setDisplayName(MenuSettings.enableGold() + " Золотая руда");
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
        gold_meta.setLore(gold_lore);
        gold.setItemMeta(gold_meta);
        menu.setItem(12, gold);


        diamond_meta.setDisplayName(MenuSettings.enableDiamond() + " Алмазная руда");
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
        diamond_meta.setLore(diamond_lore);
        diamond.setItemMeta(diamond_meta);
        menu.setItem(13, diamond);


        emerald_meta.setDisplayName(MenuSettings.enableEmerald() + " Изумрудная руда");
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
        emerald_meta.setLore(emerald_lore);
        emerald.setItemMeta(emerald_meta);
        menu.setItem(14, emerald);


        lapis_meta.setDisplayName(MenuSettings.enableLapis() + " Лазуритовая руда");
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
        lapis_meta.setLore(lapis_lore);
        lapis.setItemMeta(lapis_meta);
        menu.setItem(19, lapis);


        redstone_meta.setDisplayName(MenuSettings.enableRedstone() + " Красная руда");
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
        redstone_meta.setLore(redstone_lore);
        redstone.setItemMeta(redstone_meta);
        menu.setItem(20, redstone);


        quartz_meta.setDisplayName(MenuSettings.enableQuartz() + " Кварцевая руда");
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
        quartz_meta.setLore(quartz_lore);
        quartz.setItemMeta(quartz_meta);
        menu.setItem(21, quartz);


        reload_meta.setDisplayName("§aПерезагрузить плагин");
        List<String> reload_lore = List.of(
                "§e▸ Нажмите, чтобы перезагрузить!"
        );
        reload_meta.setLore(reload_lore);
        reload.setItemMeta(reload_meta);
        menu.setItem(16, reload);


        vault_meta.setDisplayName(MenuSettings.enableVault() + " Поддержка Vault");
        List<String> vault_lore = List.of(
                "§cРекомендую поставить Vault,",
                "§cчтобы работала эта функция!",
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        vault_meta.setLore(vault_lore);
        vault.setItemMeta(vault_meta);
        menu.setItem(37, vault);


        music_meta.setDisplayName(MenuSettings.enableMusic() + " Звук сломанной руды");
        List<String> music_lore = List.of(
                "§8▸ §7Тип звука: §f(" + Utils.getString("Sound.SoundPickup") + "§f)",
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        music_meta.setLore(music_lore);
        music.setItemMeta(music_meta);
        menu.setItem(38, music);


        edit_meta.setDisplayName(MenuSettings.enableEditOre() + " Редактирования руд");
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
        edit_meta.setLore(edit_lore);
        edit.setItemMeta(edit_meta);
        menu.setItem(39, edit);


        title_meta.setDisplayName(MenuSettings.enableTitle() + " Титлы (TitleOnPickup)");
        List<String> title_lore = List.of(
                Utils.color("&8▸ &7Главный: &f(" + Utils.getString("TitleOnPickup.Title") + "&f)"),
                Utils.color("&8▸ &7Нижний: &f(" + Utils.getString("TitleOnPickup.Subtitle") + "&f)"),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        title_meta.setLore(title_lore);
        title.setItemMeta(title_meta);
        menu.setItem(41, title);


        actionbar_meta.setDisplayName(MenuSettings.enableActionbar() + " Нижний бар (Actionbar)");
        List<String> actionbar_lore = List.of(
                "§8▸ §7Сообщение:",
                Utils.color("&8- &f(" + Utils.getString("Actionbar.Message") + "&f)"),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        actionbar_meta.setLore(actionbar_lore);
        actionbar.setItemMeta(actionbar_meta);
        menu.setItem(42, actionbar);


        chat_meta.setDisplayName(MenuSettings.enableChat() + " Cообщение в чат (MessageToChat)");
        List<String> chat_lore = List.of(
                "§8▸ §7Сообщение:",
                Utils.color("&8- &f(" + Utils.getStringList("MessageToChat.Message") + "&f)"),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        chat_meta.setLore(chat_lore);
        chat.setItemMeta(chat_meta);
        menu.setItem(43, chat);


        player.openInventory(menu);
    }
}