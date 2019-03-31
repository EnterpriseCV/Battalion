package controller;

import configuration.GameMap;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import model.PlayerState;
import model.TheWorld;
import model.role.monster.Monster;
import model.skill.Skill;
import view.BattleMap;
import vo.ResultVO;

import java.util.Observable;
import java.util.Observer;

public class BattleMapController implements Observer {
    SkillController sc = new SkillController();
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
                    TheWorld.getTheWorld().setMessage("");
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
                    sc.upgradeSkill(TheWorld.getTheWorld().getPlayer(),bt.getId());
                }
                if(bt.getId().equals("attack")||bt.getText().substring(0,2).equals("使用")) {
                    ResultVO vo = null;
                    if (bt.getText().substring(0, 2).equals("使用")) {
                        String skillName = bt.getId().substring(3);
                        vo = sc.useSkill(TheWorld.getTheWorld().getPlayer(), (Monster) TheWorld.getTheWorld().getCurrentEnemy(), skillName);
                    }else if(bt.getId().equals("attack")){
                        vo = TheWorld.getTheWorld().getPlayer().attackMonster((Monster) TheWorld.getTheWorld().getCurrentEnemy(),1.0);
                    }
                    TheWorld.getTheWorld().setMessage(TheWorld.getTheWorld().getMessage()+"\n"+vo.getMessage());

                    if(TheWorld.getTheWorld().getCurrentEnemy().getHitPoint()>0){
                        vo = ((Monster)(TheWorld.getTheWorld().getCurrentEnemy())).attackPlayer(TheWorld.getTheWorld().getPlayer());
                        TheWorld.getTheWorld().setMessage(TheWorld.getTheWorld().getMessage()+"\n"+vo.getMessage());
                        if(TheWorld.getTheWorld().getPlayer().getHitPoint()<=0){
                            TheWorld.getTheWorld().getPlayer().setState(PlayerState.DEAD);
                            TheWorld.getTheWorld().setMessage("菜");
                        }
                    }
                    if(TheWorld.getTheWorld().getCurrentEnemy().getHitPoint()<=0){
                        GameMap.monsterList.remove(TheWorld.getTheWorld().getCurrentEnemy());
                        TheWorld.getTheWorld().setCurrentEnemy(TheWorld.getTheWorld().getPlayer());
                        TheWorld.getTheWorld().getPlayer().setState(PlayerState.MOVING);
                    }

                }
            }
        }

        if(o instanceof BattleMap){
            ((BattleMap) o).refresh();
        }

    }
}
