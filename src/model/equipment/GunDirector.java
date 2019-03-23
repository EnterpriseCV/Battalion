package model.equipment;

import model.equipment.builder.GunBuilder;

/**
 * created by Kimone
 * date 2019/3/23
 */
public class GunDirector {
    private GunBuilder builder;

    public GunDirector(GunBuilder builder) {
        this.builder = builder;
    }

    public Gun construct() {
        builder.buildSight();
        builder.buildButtstock();
        return builder.getGun();
    }
}
