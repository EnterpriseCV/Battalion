package controller;


import factory.AbstractFactory;
import factory.monsterFactory.MonsterFactory;
import factory.playerFactory.PlayerFactory;
import model.role.monster.Monster;
import model.role.player.Player;

/**
 * created by Kimone
 * date 2019/3/23
 */
public class RoleController {
    public Player createPlayer(String playerName){
        AbstractFactory factory = new PlayerFactory();
        return factory.getPlayer(playerName);
    }

//    public Monster createMonster(String ){
//        AbstractFactory factory = new MonsterFactory();
//        return factory.getMonster()
//    }
}
