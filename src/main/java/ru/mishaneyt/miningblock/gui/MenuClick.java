package ru.mishaneyt.miningblock.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.mishaneyt.miningblock.utils.FileUtil;
import ru.mishaneyt.miningblock.utils.Utils;

public class MenuClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        ItemMeta item_meta = e.getCurrentItem().getItemMeta();

        if (e.getInventory().getName().equalsIgnoreCase(" ")) {
            if (item == null) return;
            if (item_meta == null) return;
            if (item.getType() == null) return;
            if (item_meta.getDisplayName() == null) return;

            if (item.getType().equals(Material.COAL_ORE)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledCoal(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledCoal(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.IRON_ORE)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledIron(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledIron(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.GOLD_ORE)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledGold(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledGold(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.DIAMOND_ORE)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledDiamond(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledDiamond(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.EMERALD_ORE)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledEmerald(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledEmerald(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.LAPIS_ORE)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledLapis(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledLapis(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.REDSTONE_ORE)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledRedstone(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledRedstone(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.QUARTZ_ORE)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledQuartz(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledQuartz(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.ANVIL)) {
                FileUtil.reloadConfigs();
                player.closeInventory();
                player.sendMessage(Utils.colorString("Messages.Reload"));
            } else if (item.getType().equals(Material.GOLD_INGOT)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledVault(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledVault(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.NOTE_BLOCK)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledMusic(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledMusic(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.TNT)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledEditOre(true);
                    player.sendTitle("", "§fРедактирования руд - §aвключено", 20, 60, 40);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledEditOre(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.ITEM_FRAME)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledTitle(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledTitle(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.PAINTING)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledActionbar(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledActionbar(false);
                    Menu.openGUI(player);
                }
            } else if (item.getType().equals(Material.PAPER)) {
                if (e.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledChat(true);
                    Menu.openGUI(player);
                } else if (e.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledChat(false);
                    Menu.openGUI(player);
                }
            }
            e.setCancelled(true);
        }
    }
}