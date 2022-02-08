package ru.mishaneyt.miningblock.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.utils.FileUtil;
import ru.mishaneyt.miningblock.utils.Utils;

public class MenuClick implements Listener {

    @EventHandler
    public boolean onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() == InventoryType.CHEST && event.getInventory().getTitle().equals(" ")) {
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() == null)
                return false;
            if (event.getCurrentItem().getItemMeta() == null)
                return false;

            if (event.getCurrentItem().getType().equals(Material.COAL_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledCoal(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledCoal(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.IRON_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledIron(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledIron(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.GOLD_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledGold(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledGold(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.DIAMOND_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledDiamond(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledDiamond(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.EMERALD_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledEmerald(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledEmerald(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.LAPIS_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledLapis(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledLapis(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.REDSTONE_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledRedstone(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledRedstone(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.QUARTZ_ORE)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledQuartz(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledQuartz(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.ANVIL)) {
                event.setCancelled(true);
                Main.getInstance().reloadConfig();
                Main.getInstance().saveConfig();
                FileUtil.reloadMining();
                FileUtil.saveMining();
                player.closeInventory();
                player.sendMessage(Utils.color(Utils.getString("Messages.Reload")));
            } else if (event.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledVault(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledVault(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.NOTE_BLOCK)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledMusic(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledMusic(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.TNT)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledEditOre(true);
                    player.sendTitle("", "§fРедактирования руд - §aвключено", 20, 60, 40);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledEditOre(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.ITEM_FRAME)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledTitle(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledTitle(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.PAINTING)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledActionbar(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledActionbar(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            } else if (event.getCurrentItem().getType().equals(Material.PAPER)) {
                event.setCancelled(true);
                if (event.getClick() == ClickType.LEFT) {
                    MenuEnabled.setEnabledChat(true);
                    player.closeInventory();
                    Menu.openGUI(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    MenuEnabled.setEnabledChat(false);
                    player.closeInventory();
                    Menu.openGUI(player);
                }
            }
        }
        return false;
    }
}