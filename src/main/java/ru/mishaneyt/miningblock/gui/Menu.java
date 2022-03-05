package ru.mishaneyt.miningblock.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Menu {
    public static boolean enabled = false;

    public static void openGUI(Player player) {
        Inventory menu = Bukkit.createInventory(null, 54, " ");

        menu.setItem(10, MenuItems.coal());
        menu.setItem(11, MenuItems.iron());
        menu.setItem(12, MenuItems.gold());
        menu.setItem(13, MenuItems.diamond());
        menu.setItem(14, MenuItems.emerald());
        menu.setItem(19, MenuItems.lapis());
        menu.setItem(20, MenuItems.redstone());
        menu.setItem(21, MenuItems.quartz());
        menu.setItem(16, MenuItems.reload());
        menu.setItem(37, MenuItems.vault());
        menu.setItem(38, MenuItems.music());
        menu.setItem(39, MenuItems.edit());
        menu.setItem(41, MenuItems.title());
        menu.setItem(42, MenuItems.actionbar());
        menu.setItem(43, MenuItems.chat());

        player.openInventory(menu);
    }
}