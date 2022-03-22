package ru.mishaneyt.miningblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.config.ConfigUtils;
import ru.mishaneyt.miningblock.utils.InfoBook;
import ru.mishaneyt.miningblock.utils.UtilsManager;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ConfigManager.ONLY_PLAYER);
            return false;
        }
        if (!sender.hasPermission(ConfigManager.PERMISSION)) {
            sender.sendMessage(ConfigManager.PERMISSION_MSG);
            return false;
        }

        Player p = (Player) sender;

        if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "help":
                    UtilsManager.onHelp(p);
                    break;
                case "info":
                    InfoBook.getBook(p);
                    break;
                case "menu":
                    p.sendMessage("В разработке...");
                    break;
                case "editore":
                    UtilsManager.onEditOre(p);
                    break;
                case "reload":
                    ConfigUtils.onCheckConfig(Main.getInstance());
                    ConfigUtils.reloadConfigs(p);
                    break;
            }
        } else {
            p.sendMessage(ConfigManager.ERROR);
        }
        return false;
    }
}