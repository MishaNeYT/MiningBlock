package ru.mishaneyt.miningblock.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MiningGUI {

    public static void open(Player p) {
        Inventory i = Bukkit.createInventory(null, 54, "[MB] Настройки");

        p.openInventory(i);
    }
}