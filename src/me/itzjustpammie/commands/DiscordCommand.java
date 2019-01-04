package me.itzjustpammie.commands;

import me.itzjustpammie.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;


        if(!(sender instanceof Player)) {
            sender.sendMessage(Utils.Console);

        } else {
            sender.sendMessage(Utils.Discord);
        }
        return false;
    }
}
