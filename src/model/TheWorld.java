package model;

import model.role.Role;
import model.role.player.Player;

public class TheWorld {
    private static TheWorld theWorld = new TheWorld();

    private Player player;
    private String message;
    private int messageCount = 0;

    public String getMessage() {
        if(messageCount>20){
            messageCount=0;
            message = "";
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        messageCount+=1;
    }

    public Role getCurrentEnemy() {
        return currentEnemy;
    }

    public void setCurrentEnemy(Role currentEnemy) {
        this.currentEnemy = currentEnemy;
    }

    private Role currentEnemy;

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
