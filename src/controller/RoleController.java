package controller;


import factory.AbstractFactory;
import factory.monsterFactory.MonsterFactory;
import factory.playerFactory.PlayerFactory;
import model.role.monster.Monster;
import model.role.player.Player;
import vo.ResultVO;

/**
 * created by Kimone
 * date 2019/3/23
 */
public class RoleController {
    /**
     * playerName: master/warrior
     * @param playerName
     * @return
     */
    public Player createPlayer(String playerName){
        AbstractFactory factory = new PlayerFactory();
        return factory.getPlayer(playerName);
    }

    /**
     * name: monster01/monster02
     * @param name
     * @return
     */
    public Monster createMonster(String name){
        AbstractFactory factory = new MonsterFactory();
        return factory.getMonster(name);
    }

    public ResultVO attackMonster(Player player, Monster monster) {
        return player.attackMonster(monster,1);
    }

    public ResultVO attackPlayer(Player player, Monster monster) {
        return monster.attackPlayer(player);
    }

}
