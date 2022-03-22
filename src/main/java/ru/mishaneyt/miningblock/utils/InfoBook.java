package ru.mishaneyt.miningblock.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class InfoBook {

    public static void getBook(Player p) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) book.getItemMeta();

        bookMeta.setTitle("MiningBlock - для чайникам");
        bookMeta.setAuthor("GhostSetuper");

        List<String> pages = new ArrayList<>();
        pages.add("§6MiningBlock 2.0.0\n§0Скоро :D");

        bookMeta.setPages(pages);
        book.setItemMeta(bookMeta);

        p.getInventory().addItem(book);
    }
}