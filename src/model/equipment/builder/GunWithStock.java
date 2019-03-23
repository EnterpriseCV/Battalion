package model.equipment.builder;

import model.equipment.components.buttstock.Buttstock;
import model.equipment.components.buttstock.TacticalStock;
import model.role.player.Player;

/**
 * created by Kimone
 * date 2019/3/23
 */
public class GunWithStock extends GunBuilder {
    public GunWithStock(Player player) {
        super(player);
    }

    @Override
    public void buildSight() {

    }

    @Override
    public void buildButtstock() {
        Buttstock buttstock = new TacticalStock();
        gun.setStock(buttstock);
        gun.setDamage(gun.getDamage()+buttstock.getDamage());
    }
}
