package com.kaigun2929.main.game;

import org.bukkit.entity.Player;

public class GamePlayer {
    private Player players = null;
    private GameTeam team = null;

    public Player getPlayers() {
        return players;
    }

    public GameTeam getTeam() {
        return team;
    }

    public boolean isTeamClass(){
        return team != null && players == null;
    }
}
