package model.role.player;

import configuration.Config;

/**
 * created by Kimone
 * date 2019/3/20
 */
public class Warrior extends Player {

    private Warrior(String name, int hitPoint, int defense, int damage, int magicPoint, int experience, int level, int gold) {
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

    private static Warrior warrior = new Warrior(Config.warrior_name,Config.warrior_hitPoint, Config.warrior_defense,
            Config.warrior_damage,Config.warrior_magicPoint, Config.warrior_exp,Config.warrior_level,Config.warrior_gold);

    public static Warrior getWarrior(){
        return warrior;
    }

    @Override
    public void updateDamage() {
    }

    @Override
    public void updateDefense() {
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name=" + getName() +
                ", hitPoint=" + getHitPoint() +
                ", defense=" + getDefense() +
                ", damage=" + getDamage() +
                ", magicPoint=" + magicPoint +
                ", experience=" + experience +
                ", level=" + level +
                ", gold=" + gold +
                ", equipments=" + equipments +
                ", skills=" + skills +
                '}';
    }
}
