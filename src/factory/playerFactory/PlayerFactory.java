package factory.playerFactory;

import factory.AbstractFactory;
import model.role.monster.Monster;
import model.role.player.Master;
import model.role.player.Player;
import model.role.player.Warrior;

/**
 * created by Kimone
 * date 2019/3/20
 */
public class PlayerFactory extends AbstractFactory {
    @Override
    public Player getPlayer(String name) {
        if (name == null) {
            return null;
        }
        if (name.equals("warrior")){
            return Warrior.getWarrior();
        }else if(name.equals("master")){
            return Master.getMaster();
        }
        return null;
    }

    @Override
    public Monster getMonster(String name) {
        return null;
    }
}
