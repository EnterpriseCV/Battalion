package model.equipment;

import configuration.Config;
import model.role.player.Player;

/**
 * created by Kimone
 * date 2019/3/22
 */
public class Cloth extends EquipmentDecorator {
    Player player;

    public Cloth(Player player){
//        super(player.getName(), player.getHitPoint(), player.getDefense(), player.getDamage(), player.getMagicPoint(),
//                player.getExperience(), player.getLevel(), player.getGold());
        this.player = player;
    }

    @Override
    public void updateDefense() {
        player.setDefense(player.getDefense()+ Config.cloth_defense);
    }

    @Override
    public void updateDamage() {
        player.setDamage(player.getDamage()+Config.cloth_damage);
    }
}
