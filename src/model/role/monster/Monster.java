package model.role.monster;

import model.role.Role;

public class Monster extends Role {
    private int exploot;
    private int goldloot;

    public Monster(String name, int hitPoint, int defense, int damage, int exploot, int goldloot) {
        this.setName(name);
        this.setHitPoint(hitPoint);
        this.setDefense(defense);
        this.setDamage(damage);
        this.exploot = exploot;
        this.goldloot = goldloot;
    }


    public int getExploot() {
        return exploot;
    }

    public void setExploot(int exploot) {
        this.exploot = exploot;
    }

    public int getGoldloot() {
        return goldloot;
    }

    public void setGoldloot(int goldloot) {
        this.goldloot = goldloot;
    }
}
