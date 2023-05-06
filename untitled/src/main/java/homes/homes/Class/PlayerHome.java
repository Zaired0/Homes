/*
 *
 * Author: Eliott Deriaz alias Zaired
 * Date: 06.05.2023
 * Description: player home class to save player's home
 *
 * */
package homes.homes.Class;

import homes.homes.Homes;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.*;

/**
 * serializable class to save players home
 */
public class PlayerHome implements Serializable {
    private String Name;                //name of the player
    private double x;                   //x position of the home location
    private double y;                   //y position of the home location
    private double z;                   //z position of the home location
    private String world;               //world name of the home location

    /**
     *
     * @param name name of the player
     * @param location  location of the player
     */
    public PlayerHome(String name, Location location) {
        this.Name = name;
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.world = location.getWorld().getName();
    }

    /**
     * get home location
     * @return Location of the home
     */
    public Location getHome(){
        World w = Bukkit.getWorld(this.world);
        Location l = new Location(w,this.x,this.y,this.z);
        return l;
    }

    /**
     * create a file in players home directory of the
     * @return true if able to add location false if not
     */
    public boolean setPlayerHome(){

        //create serialized file of the player location
        try{
            FileOutputStream fileOut = new FileOutputStream(Homes.HOMESPATH + Name +".ser");
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

    /**
     * get player home using his name
     * @param playerName name of the player wanting his home
     * @return  location of the player's home
     */
    public static Location getPlayerHome(String playerName){

        PlayerHome pl = null;

        //get serialized file of the player location
        try {
            FileInputStream fileIn = new FileInputStream(Homes.HOMESPATH + playerName +".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            pl = (PlayerHome) in.readObject();
            in.close();
            fileIn.close();
        }
        //if file does not exist
        catch (IOException z) {
            return null;
        }
        //if error getting the object
        catch (ClassNotFoundException e) {
            Bukkit.getLogger().info("error getting "  + playerName + "'s location \"" + e + "\"");
            return null;
        }

        return pl.getHome();
    }
}
