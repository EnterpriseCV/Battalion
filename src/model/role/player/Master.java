package model.role.player;

import configuration.Config;

/**
 * created by Kimone
 * date 2019/3/20
 */
public class Master extends Player {

    private Master(String name, int hitPoint, int defense, int damage, int magicPoint, int experience, int level, int gold) {
//        super(name, hitPoint, defense, damage, magicPoint, experience, level, gold);
        this.setName(name);
        this.setHitPoint(hitPoint);
        this.setDefense(defense);
        this.setDamage(damage);
        this.setMagicPoint(magicPoint);
        this.setExperience(experience);
        this.setLevel(level);
        this.setGold(gold);
    }

    private static Master master = new Master(Config.master_name,Config.master_hitPoint, Config.master_defense,
            Config.master_damage,Config.master_magicPoint, Config.master_exp,Config.master_level,Config.master_gold);

    public static Master getMaster(){
        return master;
    }

    @Override
    public void updateDamage() {

    }

    @Override
    public void updateDefense() {

    }

    @Override
    public String toString() {
        return "Master{" +
                "name=" + getName() +
                ", hitPoint=" + getHitPoint() +
                ", defense=" + getDefense() +
                ", damage=" + getDamage() +
                ", magicPoint=" + magicPoint +
                ", experience=" + experience +
                ", level=" + level +
                ", gold=" + gold +
                ", equipments=" + equipments +
                '}';
    }
}
