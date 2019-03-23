package model.equipment.builder;

import model.equipment.Gun;
import model.role.player.Player;

/**
 * created by Kimone
 * date 2019/3/23
 */
public abstract class GunBuilder {
    private Player player;
    Gun gun;

    public GunBuilder(Player player) {
        this.player = player;
        gun = new Gun(player);
    }



    public abstract void buildSight();

    public abstract void buildButtstock();

    public Gun getGun(){
        return gun;
    }

}
