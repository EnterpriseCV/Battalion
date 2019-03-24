package model;

import model.role.player.Player;

public class TheWorld {
    private static TheWorld theWorld = new TheWorld();

    private Player player;

    public static int locX = 0;
    public static int locY = 0;

    private TheWorld(){

    }

    public static TheWorld getTheWorld(){
        return theWorld;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
