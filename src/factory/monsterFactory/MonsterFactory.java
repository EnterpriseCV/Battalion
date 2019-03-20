package factory.monsterFactory;

import factory.AbstractFactory;
import model.role.monster.Monster;
import model.role.player.Player;

/**
 * created by Kimone
 * date 2019/3/20
 */
public class MonsterFactory extends AbstractFactory {

    @Override
    public Player getPlayer(String name) {
        return null;
    }

    @Override
    public Monster getMonster(String name) {
        return null;
    }
}
