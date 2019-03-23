package model.equipment;

import configuration.Config;
import model.role.player.Player;

/**
 * created by Kimone
 * date 2019/3/22
 */

/**
 * 铁甲
 */
public class Armour extends EquipmentDecorator {

    Player player;

    public Armour(Player player) {
//        super(player.getName(), player.getHitPoint(), player.getDefense(), player.getDamage(), player.getMagicPoint(),
//                player.getExperience(), player.getLevel(), player.getGold());
        this.player = player;
    }

    @Override
    public void updateDamage() {
       player.setDamage(player.getDamage()+Config.armour_damage);
    }

    @Override
    public void updateDefense() {
        player.setDefense(player.getDefense()+ Config.armour_defense);
    }
}
