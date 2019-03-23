package model.equipment.builder;

import model.equipment.components.buttstock.Buttstock;
import model.equipment.components.buttstock.TacticalStock;
import model.equipment.components.sight.Mirror;
import model.equipment.components.sight.Sight;
import model.role.player.Player;

/**
 * created by Kimone
 * date 2019/3/23
 */
public class GunWithSightAndStock extends GunBuilder {
    public GunWithSightAndStock(Player player) {
        super(player);
    }

    @Override
    public void buildSight() {
        Sight m = new Mirror();
        gun.setSight(m);
        gun.setDamage(gun.getDamage()+m.getDamage());
    }

    @Override
    public void buildButtstock() {
        Buttstock buttstock = new TacticalStock();
        gun.setStock(buttstock);
        gun.setDamage(gun.getDamage()+buttstock.getDamage());
    }
}
