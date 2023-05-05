package homes.homes.commands;

import org.bukkit.command.Command;
import homes.homes.Class.PlayerHome;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class SetHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){
        // controls that this is a player
        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        Player p = (Player) sender;

        if(!p.isOnGround()){
            sender.sendMessage("You can only place your home on ground");
            return true;
        }

        PlayerHome ph = new PlayerHome(p.getName(), p.getLocation());

        ph.setPlayerHome();

        p.sendMessage("Your home has been set on " + p.getLocation().toString());

        return true;
    }
}
