/*
 *
 * Author: Eliott Deriaz alias Zaired
 * Date: 06.05.2023
 * Description: /gethome command file
 *
 * */
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

        // controls that this is a player
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Only players can run this command.");
            return false;
        }

        //get player's home location
        Location loc = PlayerHome.getPlayerHome(commandSender.getName());

        //controls that loc isn't null
        if(loc == null){
            commandSender.sendMessage("You don't have a home.");

            return false;
        }

        //send home location of the sender
        commandSender.sendMessage("Your home is set on: x " + loc.getBlockX() + ", y " + loc.getBlockY() + ", z " + loc.getBlockZ());

        return true;
    }
}
