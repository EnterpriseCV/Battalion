package factory;

import model.role.monster.Monster;
import model.role.player.Player;

/**
 * created by Kimone
 * date 2019/3/20
 */
public abstract class AbstractFactory {
    public abstract Player getPlayer(String name);
    public abstract Monster getMonster(String name);
}
