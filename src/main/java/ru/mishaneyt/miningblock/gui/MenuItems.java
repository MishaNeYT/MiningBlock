package ru.mishaneyt.miningblock.gui;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.mishaneyt.miningblock.utils.FileUtil;
import ru.mishaneyt.miningblock.utils.Utils;

import java.util.List;

public class MenuItems {

    public static ItemStack coal() {
        ItemStack coal = new ItemStack(Material.COAL_ORE);
        ItemMeta coal_meta = coal.getItemMeta();

        coal_meta.setDisplayName(MenuPlaceholder.enableCoal() + " Каменный уголь");
        List<String> coal_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("COAL.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("COAL.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("COAL.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("COAL.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuPlaceholder.enableParticleCoal(),
                "",
                "§8▸ §7Дроп: " + MenuPlaceholder.enableCoalDrop(),
                "§8▸ §7Авто-подбор: " + MenuPlaceholder.enableCoalAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuPlaceholder.enableCoalCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        coal_meta.setLore(coal_lore);
        coal.setItemMeta(coal_meta);

        return coal;
    }

    public static ItemStack iron() {
        ItemStack iron = new ItemStack(Material.IRON_ORE);
        ItemMeta iron_meta = iron.getItemMeta();

        iron_meta.setDisplayName(MenuPlaceholder.enableIron() + " Железная руда");
        List<String> iron_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("IRON.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("IRON.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("IRON.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("IRON.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuPlaceholder.enableParticleIron(),
                "",
                "§8▸ §7Дроп: " + MenuPlaceholder.enableIronDrop(),
                "§8▸ §7Авто-подбор: " + MenuPlaceholder.enableIronAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuPlaceholder.enableIronCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        iron_meta.setLore(iron_lore);
        iron.setItemMeta(iron_meta);

        return iron;
    }

    public static ItemStack gold() {
        ItemStack gold = new ItemStack(Material.GOLD_ORE);
        ItemMeta gold_meta = gold.getItemMeta();

        gold_meta.setDisplayName(MenuPlaceholder.enableGold() + " Золотая руда");
        List<String> gold_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("GOLD.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("GOLD.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("GOLD.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("GOLD.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuPlaceholder.enableParticleGold(),
                "",
                "§8▸ §7Дроп: " + MenuPlaceholder.enableGoldDrop(),
                "§8▸ §7Авто-подбор: " + MenuPlaceholder.enableGoldAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuPlaceholder.enableGoldCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        gold_meta.setLore(gold_lore);
        gold.setItemMeta(gold_meta);

        return gold;
    }

    public static ItemStack diamond() {
        ItemStack diamond = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta diamond_meta = diamond.getItemMeta();

        diamond_meta.setDisplayName(MenuPlaceholder.enableDiamond() + " Алмазная руда");
        List<String> diamond_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("DIAMOND.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("DIAMOND.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("DIAMOND.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("DIAMOND.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuPlaceholder.enableParticleDiamond(),
                "",
                "§8▸ §7Дроп: " + MenuPlaceholder.enableDiamondDrop(),
                "§8▸ §7Авто-подбор: " + MenuPlaceholder.enableDiamondAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuPlaceholder.enableDiamondCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        diamond_meta.setLore(diamond_lore);
        diamond.setItemMeta(diamond_meta);

        return diamond;
    }

    public static ItemStack emerald() {
        ItemStack emerald = new ItemStack(Material.EMERALD_ORE);
        ItemMeta emerald_meta = emerald.getItemMeta();

        emerald_meta.setDisplayName(MenuPlaceholder.enableEmerald() + " Изумрудная руда");
        List<String> emerald_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("EMERALD.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("EMERALD.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("EMERALD.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("EMERALD.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuPlaceholder.enableParticleEmerald(),
                "",
                "§8▸ §7Дроп: " + MenuPlaceholder.enableEmeraldDrop(),
                "§8▸ §7Авто-подбор: " + MenuPlaceholder.enableEmeraldAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuPlaceholder.enableEmeraldCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        emerald_meta.setLore(emerald_lore);
        emerald.setItemMeta(emerald_meta);

        return emerald;
    }

    public static ItemStack lapis() {
        ItemStack lapis = new ItemStack(Material.LAPIS_ORE);
        ItemMeta lapis_meta = lapis.getItemMeta();

        lapis_meta.setDisplayName(MenuPlaceholder.enableLapis() + " Лазуритовая руда");
        List<String> lapis_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("LAPIS.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("LAPIS.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("LAPIS.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("LAPIS.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuPlaceholder.enableParticleLapis(),
                "",
                "§8▸ §7Дроп: " + MenuPlaceholder.enableLapisDrop(),
                "§8▸ §7Авто-подбор: " + MenuPlaceholder.enableLapisAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuPlaceholder.enableLapisCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        lapis_meta.setLore(lapis_lore);
        lapis.setItemMeta(lapis_meta);

        return lapis;
    }

    public static ItemStack redstone() {
        ItemStack redstone = new ItemStack(Material.REDSTONE_ORE);
        ItemMeta redstone_meta = redstone.getItemMeta();

        redstone_meta.setDisplayName(MenuPlaceholder.enableRedstone() + " Красная руда");
        List<String> redstone_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("REDSTONE.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("REDSTONE.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("REDSTONE.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("REDSTONE.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuPlaceholder.enableParticleRedstone(),
                "",
                "§8▸ §7Дроп: " + MenuPlaceholder.enableRedstoneDrop(),
                "§8▸ §7Авто-подбор: " + MenuPlaceholder.enableRedstoneAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuPlaceholder.enableRedstoneCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        redstone_meta.setLore(redstone_lore);
        redstone.setItemMeta(redstone_meta);

        return redstone;
    }

    public static ItemStack quartz() {
        ItemStack quartz = new ItemStack(Material.QUARTZ_ORE);
        ItemMeta quartz_meta = quartz.getItemMeta();

        quartz_meta.setDisplayName(MenuPlaceholder.enableQuartz() + " Кварцевая руда");
        List<String> quartz_lore = List.of(
                "§8▸ §7Задержка: §f" + FileUtil.getMiningConfig().getInt("QUARTZ.Delay") + " сек.",
                "§8▸ §7Деньги: §e+" + FileUtil.getMiningConfig().getInt("QUARTZ.MoneyDrop"),
                "§8▸ §7Опыт: §3+" + FileUtil.getMiningConfig().getInt("QUARTZ.ExpDrop"),
                "",
                "§8▸ §7Замена на: §6" + FileUtil.getMiningConfig().getString("QUARTZ.ReplaceBlock"),
                "§8▸ §7Частица: " + MenuPlaceholder.enableParticleQuartz(),
                "",
                "§8▸ §7Дроп: " + MenuPlaceholder.enableQuartzDrop(),
                "§8▸ §7Авто-подбор: " + MenuPlaceholder.enableQuartzAutoPickup(),
                "",
                "§8▸ §7Команда: " + MenuPlaceholder.enableQuartzCMD(),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        quartz_meta.setLore(quartz_lore);
        quartz.setItemMeta(quartz_meta);

        return quartz;
    }

    public static ItemStack reload() {
        ItemStack reload = new ItemStack(Material.ANVIL);
        ItemMeta reload_meta = reload.getItemMeta();

        reload_meta.setDisplayName("§aПерезагрузить плагин");
        List<String> reload_lore = List.of(
                "§e▸ Нажмите, чтобы перезагрузить!"
        );
        reload_meta.setLore(reload_lore);
        reload.setItemMeta(reload_meta);

        return reload;
    }

    public static ItemStack vault() {
        ItemStack vault = new ItemStack(Material.GOLD_INGOT);
        ItemMeta vault_meta = vault.getItemMeta();

        vault_meta.setDisplayName(MenuPlaceholder.enableVault() + " Поддержка Vault");
        List<String> vault_lore = List.of(
                "§cРекомендую поставить Vault,",
                "§cчтобы работала эта функция!",
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        vault_meta.setLore(vault_lore);
        vault.setItemMeta(vault_meta);

        return vault;
    }

    public static ItemStack music() {
        ItemStack music = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta music_meta = music.getItemMeta();

        music_meta.setDisplayName(MenuPlaceholder.enableMusic() + " Звук сломанной руды");
        List<String> music_lore = List.of(
                "§8▸ §7Тип звука: §f(" + Utils.getString("Sound.SoundPickup") + "§f)",
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        music_meta.setLore(music_lore);
        music.setItemMeta(music_meta);

        return music;
    }

    public static ItemStack edit() {
        ItemStack edit = new ItemStack(Material.TNT);
        ItemMeta edit_meta = edit.getItemMeta();

        edit_meta.setDisplayName(MenuPlaceholder.enableEditOre() + " Редактирования руд");
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

        return edit;
    }

    public static ItemStack title() {
        ItemStack title = new ItemStack(Material.ITEM_FRAME);
        ItemMeta title_meta = title.getItemMeta();

        title_meta.setDisplayName(MenuPlaceholder.enableTitle() + " Титлы (TitleOnPickup)");
        List<String> title_lore = List.of(
                Utils.color("&8▸ &7Главный: &f(" + Utils.getString("TitleOnPickup.Title") + "&f)"),
                Utils.color("&8▸ &7Нижний: &f(" + Utils.getString("TitleOnPickup.Subtitle") + "&f)"),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        title_meta.setLore(title_lore);
        title.setItemMeta(title_meta);

        return title;
    }

    public static ItemStack actionbar() {
        ItemStack actionbar = new ItemStack(Material.PAINTING);
        ItemMeta actionbar_meta = actionbar.getItemMeta();

        actionbar_meta.setDisplayName(MenuPlaceholder.enableActionbar() + " Нижний бар (Actionbar)");
        List<String> actionbar_lore = List.of(
                "§8▸ §7Сообщение:",
                Utils.color("&8- &f(" + Utils.getString("Actionbar.Message") + "&f)"),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        actionbar_meta.setLore(actionbar_lore);
        actionbar.setItemMeta(actionbar_meta);

        return actionbar;
    }

    public static ItemStack chat() {
        ItemStack chat = new ItemStack(Material.PAPER);
        ItemMeta chat_meta = chat.getItemMeta();

        chat_meta.setDisplayName(MenuPlaceholder.enableChat() + " Cообщение в чат (MessageToChat)");
        List<String> chat_lore = List.of(
                "§8▸ §7Сообщение:",
                Utils.color("&8- &f(" + Utils.getStringList("MessageToChat.Message") + "&f)"),
                "",
                "§e▸ ЛКМ, чтобы включить!",
                "§e▸ ПКМ, чтобы отключить!"
        );
        chat_meta.setLore(chat_lore);
        chat.setItemMeta(chat_meta);

        return chat;
    }
}