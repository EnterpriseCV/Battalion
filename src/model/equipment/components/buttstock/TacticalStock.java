package model.equipment.components.buttstock;

/**
 * created by Kimone
 * date 2019/3/23
 */

import configuration.Config;

/**
 * 战术枪托
 */
public class TacticalStock extends Buttstock {
    @Override
    public int getDamage() {
        return Config.tactical_damage;
    }
}
