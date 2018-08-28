package com.kaigun2929.main.data;


import com.kaigun2929.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataHandler {

    private static DataHandler ourInstance = new DataHandler();

    public static DataHandler getInstance(){return ourInstance;}

    private DataHandler(){
        this.gameInfoFile = new File(Main.getInstance().getDataFolder(),"gameInfo.yml");
        if(!this.gameInfoFile.exists()){
            try{
                this.gameInfoFile.createNewFile();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        this.gameInfo = YamlConfiguration.loadConfiguration(this.gameInfoFile);
    }

    private File gameInfoFile;
    private FileConfiguration gameInfo;

    public FileConfiguration GetGameInfo(){
        return gameInfo;
    }
    public void SaveGameInfo(){
        try{
            this.gameInfo.save(this.gameInfoFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
