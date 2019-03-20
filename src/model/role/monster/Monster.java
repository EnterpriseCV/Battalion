package model.role.monster;

import model.role.Role;

public abstract class Monster extends Role {
    private int exploot;
    private int goldloot;

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
