package ru.mishaneyt.miningblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.config.ConfigUtils;
import ru.mishaneyt.miningblock.gui.MiningGUI;
import ru.mishaneyt.miningblock.utils.UtilsManager;

public class Commands implements CommandExecutor {

    public Commands(Main main) {
        main.getCommand("miningblock").setExecutor(this);
        main.getCommand("miningblock").setTabCompleter(new CommandsTab());
    }

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

            if ("help".equalsIgnoreCase(args[0])) {
                UtilsManager.onHelp(p); return true;

            } else if ("menu".equalsIgnoreCase(args[0])) {
                MiningGUI.open(p); return true;

            } else if ("editore".equalsIgnoreCase(args[0])) {
                UtilsManager.onEditOre(p); return true;

            } else if ("reload".equalsIgnoreCase(args[0])) {
                ConfigUtils.onCheckConfig(Main.getInstance());
                ConfigUtils.reloadConfigs(p); return true;

            } else sender.sendMessage(ConfigManager.ERROR);
        } else sender.sendMessage(ConfigManager.ERROR);
        return false;
    }
}