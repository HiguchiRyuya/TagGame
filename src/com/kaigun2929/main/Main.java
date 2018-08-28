package com.kaigun2929.main;


import com.kaigun2929.main.data.DataHandler;
import com.kaigun2929.main.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class Main extends JavaPlugin {

    private static Main instance;
    private Set<Game> games = new HashSet<>();
    private int gameLimit = 0;

    @Override
    public void onEnable(){
        instance = this;

        getConfig().options().copyDefaults(true);
        getConfig().options().copyHeader(true);
        saveDefaultConfig();

        if(getConfig().getBoolean("single-server-mode")){
            gameLimit = 1;
        }else{
            gameLimit = -1;
        }

        if(DataHandler.getInstance().GetGameInfo().getConfigurationSection("games") != null) {
            for (String gameName : DataHandler.getInstance().GetGameInfo().getConfigurationSection("games").getKeys(false)) {
                Game game = new Game(gameName);
                this.registerGame(game);
            }
        }else{
            // ゲームデータがないとき
            getLogger().warning("ゲームデータがありません。ゲームデータを作成してください");
        }


    }

    @Override
    public void onDisable(){
        instance = null;
    }

    public static Main getInstance(){return instance;}

    public boolean registerGame(Game game){
        if (games.size() == gameLimit && gameLimit != -1){
            return false;
        }

        games.add(game);

        return true;
    }
}
