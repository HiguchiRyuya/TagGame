package com.kaigun2929.main.game;

import com.kaigun2929.main.data.DataHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Set;

public class Game {

    private int maxPlayers;
    private int minPlayers;
    private World world;
    private Set<Location> spawnPoints;
    private boolean IsTeamGame;

    private Set<Player> survivors;
    private Set<Player> killer;
    private Set<Player> spectators;
    private Set<GameTeam> teams;

    public Game(String gameName){

        FileConfiguration fc = DataHandler.getInstance().GetGameInfo();

        this.maxPlayers = fc.getInt("games." + gameName + ".maxPlayers");
        this.minPlayers = fc.getInt("games." + gameName + ".minPlayers");
        this.world = Bukkit.createWorld(new WorldCreator(fc.getString("games." + gameName + ".worldName")));

    }

}
