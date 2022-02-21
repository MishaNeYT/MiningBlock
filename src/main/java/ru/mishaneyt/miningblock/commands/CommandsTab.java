package ru.mishaneyt.miningblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandsTab implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> list = Arrays.asList("help", "menu", "reload");
        if (args.length == 0) {
            return list;
        }
        return list.stream().filter(line -> line.startsWith(args[0])).collect(Collectors.toList());
    }
}