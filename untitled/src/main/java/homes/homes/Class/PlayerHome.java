package homes.homes.Class;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.*;

public class PlayerHome implements Serializable {
    private String Name;
    private double x;
    private double y;
    private double z;

    private String world;

    public PlayerHome(String name, Location location) {
        this.Name = name;
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
    }

    public Location getHome(){
        World w = Bukkit.getWorld("overworld");
        Location l = new Location(w,this.x,this.y,this.z);
        return l;
    }

    public boolean setPlayerHome(){
        try{
            FileOutputStream fileOut = new FileOutputStream("./homes/" + Name +".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        }
        catch(IOException e){
            Bukkit.getLogger().info("error saving "  + Name + "'s location \"" + e + "\"");

            return false;
        }

        return true;
    }

    public static Location getPlayerHome(String playerName){
        PlayerHome pl = null;
        Player player = Bukkit.getPlayer(playerName);

        try {
            FileInputStream fileIn = new FileInputStream("./homes/" + playerName +".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            pl = (PlayerHome) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (IOException z) {
            player.sendMessage("Vous n'avez pas encore de home.");
            return null;
        }
        catch (ClassNotFoundException e) {
            Bukkit.getLogger().info("error getting "  + playerName + "'s location \"" + e + "\"");
            return null;
        }

        return pl.getHome();
    }
}
