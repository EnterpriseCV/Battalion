package controller;

import configuration.GameMap;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import model.PlayerState;
import model.TheWorld;
import model.role.monster.Monster;
import view.BattleMap;

import java.util.Observable;
import java.util.Observer;

public class BattleMapController implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        if(arg instanceof KeyEvent){
            KeyEvent ke = (KeyEvent)arg;
            if(!TheWorld.getTheWorld().getPlayer().getState().equals(PlayerState.MOVING)){
                return;
            }
            int tx = TheWorld.getTheWorld().getPlayer().getX();
            int ty = TheWorld.getTheWorld().getPlayer().getY();

            switch (ke.getCode()){
                case UP:ty-=1;break;
                case DOWN:ty+=1;break;
                case LEFT:tx-=1;break;
                case RIGHT:tx+=1;break;
            }
            if(tx<0||tx>= GameMap.map_size||ty<0||ty>=GameMap.map_size||GameMap.map[ty][tx]!=0){
                return;
            }
            for(Monster monster:GameMap.monsterList){
                if(tx==monster.getX()&&ty==monster.getY()){
                    TheWorld.getTheWorld().getPlayer().setState(PlayerState.FIGHTING);
                    TheWorld.getTheWorld().setCurrentEnemy((monster));
                    break;
                }
            }
            if(TheWorld.getTheWorld().getPlayer().getState().equals(PlayerState.MOVING)) {
                TheWorld.getTheWorld().getPlayer().setX(tx);
                TheWorld.getTheWorld().getPlayer().setY(ty);
            }

        }


        if(arg instanceof ActionEvent){
            ActionEvent ae = (ActionEvent)arg;
            if(ae.getSource() instanceof Button){
                Button bt = (Button)ae.getSource();
                if(bt.getText().equals("升级")){
                    new SkillController().upgradeSkill(TheWorld.getTheWorld().getPlayer(),bt.getId());
                }
            }
        }

        if(o instanceof BattleMap){
            ((BattleMap) o).refresh();
        }

    }
}
