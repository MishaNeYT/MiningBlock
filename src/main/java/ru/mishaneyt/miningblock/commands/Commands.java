package ru.mishaneyt.miningblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.mishaneyt.miningblock.Main;
import ru.mishaneyt.miningblock.config.ConfigManager;
import ru.mishaneyt.miningblock.utils.Utils;

public class Commands implements CommandExecutor {
    private final Main main;

    public Commands(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.color(ConfigManager.getMessages().getString("Messages.Command.Player")));
            return true;
        }
        if (!(sender.hasPermission(ConfigManager.getConfig().getString("Settings.Permission")))) {
            sender.sendMessage(Utils.color(ConfigManager.getMessages().getString("Messages.Command.Permission")));
            return true;
        }

        Player p = (Player) sender;

        if (args.length == 0) {
            Utils.help(p);
            return true;
        }

        else if (args.length == 1) {
            if ("help".equalsIgnoreCase(args[0])) {
                Utils.help(p);
                return true;
            }

            else if ("editore".equalsIgnoreCase(args[0])) {
                Utils.editOre(p);
                return true;
            }

            else if ("reload".equalsIgnoreCase(args[0])) {
                ConfigManager configManager = new ConfigManager(this.main);

                configManager.reloadPlugin(p);
                return true;

            } else sender.sendMessage(Utils.color(ConfigManager.getMessages().getString("Messages.Command.Error")));
        } else sender.sendMessage(Utils.color(ConfigManager.getMessages().getString("Messages.Command.Error")));
        return false;
    }
}