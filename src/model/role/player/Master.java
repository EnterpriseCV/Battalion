package model.role.player;

import configuration.Config;

/**
 * created by Kimone
 * date 2019/3/20
 */
public class Master extends Player {

    private Master(String name, int hitPoint, int defense, int damage, int magicPoint, int experience, int level, int gold) {
        super(name, hitPoint, defense, damage, magicPoint, experience, level, gold);
    }

    private static Master master = new Master(Config.master_name,Config.master_hitPoint, Config.master_defense,
            Config.master_damage,Config.master_magicPoint, Config.master_exp,Config.master_level,Config.master_gold);

    public static Master getMaster(){
        return master;
    }
}
