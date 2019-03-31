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
        Monster monster = null;
        if (name.equals("monster01")) {
            monster = new Monster("怪物1", 500, 15, 30, 20, 100);
        }
        if (name.equals("monster02")) {
            monster = new Monster("怪物2", 800, 1, 20, 5, 10);
        }
        return monster;
    }
}
