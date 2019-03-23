package model.equipment.components.sight;

import configuration.Config;

/**
 * created by Kimone
 * date 2019/3/23
 */
public class Mirror extends Sight {
    @Override
    public int getDamage() {
        return Config.mirror_damage;
    }
}
