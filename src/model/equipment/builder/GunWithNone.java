package model.equipment.builder;

import model.role.player.Player;

/**
 * created by Kimone
 * date 2019/3/23
 */
public class GunWithNone extends GunBuilder {
    public GunWithNone(Player player) {
        super(player);
    }

    @Override
    public void buildSight() {

    }

    @Override
    public void buildButtstock() {

    }
}
