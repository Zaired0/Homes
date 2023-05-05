package homes.homes.commands;

import homes.homes.Class.PlayerHome;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetHome implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Location loc = PlayerHome.getPlayerHome(commandSender.getName());

        if(loc == null){
            commandSender.sendMessage("You don't have a home");

            return false;
        }

        commandSender.sendMessage("Your home is set on: x " + loc.getBlockX() + ", y " + loc.getBlockY() + ", z " + loc.getBlockZ());

        return true;
    }
}
