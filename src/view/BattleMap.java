package view;

import configuration.Images;
import configuration.GameMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import model.PlayerState;
import model.TheWorld;
import model.role.monster.Monster;
import model.skill.Skill;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class BattleMap extends Observable  {
    AnchorPane ap;
    Canvas canvas;
    Text hp,mp,attack,defense,gold,level,exp;
    Text enemyhp,enemyAttack,enemyDefense;
    Map<String,Text> skillDescriptionMap;
    Map<String,Button> useSkillButtonMap;
    Text message;
    public BattleMap(){
        super();
        ap = new AnchorPane();
        canvas = new Canvas(700,700);
        AnchorPane.setLeftAnchor(canvas,10.0);
        AnchorPane.setTopAnchor(canvas,10.0);

        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                BattleMap.super.setChanged();
                BattleMap.super.notifyObservers(event);
            }
        });
        canvas.setFocusTraversable(true);
        canvas.requestFocus();
        ap.getChildren().addAll(canvas);

        playPanelInit();
        battlePanelInit();
        enemyPanelInit();
        messagePanelInit();

        refresh();
    }

    private void playPanelInit(){
        double leftdis = 700.0;

        Label hpLabel  = new Label("生命值");
        AnchorPane.setLeftAnchor(hpLabel,leftdis);
        AnchorPane.setTopAnchor(hpLabel,10.0);
        ap.getChildren().add(hpLabel);

        hp = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getHitPoint()));
        AnchorPane.setLeftAnchor(hp,leftdis+40);
        AnchorPane.setTopAnchor(hp,10.0);
        ap.getChildren().add(hp);

        Label mpLabel  = new Label("魔力值");
        AnchorPane.setLeftAnchor(mpLabel,leftdis);
        AnchorPane.setTopAnchor(mpLabel,30.0);
        ap.getChildren().add(mpLabel);

        mp = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getMagicPoint()));
        AnchorPane.setLeftAnchor(mp,leftdis+40);
        AnchorPane.setTopAnchor(mp,30.0);
        ap.getChildren().add(mp);


        Label attackLabel  = new Label("攻击");
        AnchorPane.setLeftAnchor(attackLabel,leftdis);
        AnchorPane.setTopAnchor(attackLabel,50.0);
        ap.getChildren().add(attackLabel);

        attack = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getDamage()));
        AnchorPane.setLeftAnchor(attack,leftdis+40);
        AnchorPane.setTopAnchor(attack,50.0);
        ap.getChildren().add(attack);

        Label defenseLabel  = new Label("防御");
        AnchorPane.setLeftAnchor(defenseLabel,leftdis);
        AnchorPane.setTopAnchor(defenseLabel,70.0);
        ap.getChildren().add(defenseLabel);

        defense = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getDefense()));
        AnchorPane.setLeftAnchor(defense,leftdis+40);
        AnchorPane.setTopAnchor(defense,70.0);
        ap.getChildren().add(defense);

        Label goldLabel  = new Label("金币");
        AnchorPane.setLeftAnchor(goldLabel,leftdis);
        AnchorPane.setTopAnchor(goldLabel,90.0);
        ap.getChildren().add(goldLabel);

        gold = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getGold()));
        AnchorPane.setLeftAnchor(gold,leftdis+40);
        AnchorPane.setTopAnchor(gold,90.0);
        ap.getChildren().add(gold);

        Label levelLabel  = new Label("等级");
        AnchorPane.setLeftAnchor(levelLabel,leftdis);
        AnchorPane.setTopAnchor(levelLabel,110.0);
        ap.getChildren().add(levelLabel);

        level = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getLevel()));
        AnchorPane.setLeftAnchor(level,leftdis+40);
        AnchorPane.setTopAnchor(level,110.0);
        ap.getChildren().add(level);

        Label expLabel  = new Label("经验");
        AnchorPane.setLeftAnchor(expLabel,leftdis);
        AnchorPane.setTopAnchor(expLabel,130.0);
        ap.getChildren().add(expLabel);

        exp = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getExperience()));
        AnchorPane.setLeftAnchor(exp,leftdis+40);
        AnchorPane.setTopAnchor(exp,130.0);
        ap.getChildren().add(exp);


        skillDescriptionMap = new HashMap<String,Text>();
        java.util.Map<String, Skill> skills = TheWorld.getTheWorld().getPlayer().getSkills();
        double curpos = 150;
        for(String skillName:skills.keySet()){
            Skill skill = skills.get(skillName);
            Text skillText = new Text();
            skillDescriptionMap.put(skillName,skillText);
            skillText.setText(skill.getName()+":lv."+skill.getLevel());
            AnchorPane.setLeftAnchor(skillText,leftdis);
            AnchorPane.setTopAnchor(skillText,curpos);
            ap.getChildren().add(skillText);

            Button button = new Button("升级");
            button.setId(skillName);
            button.setFocusTraversable(false);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    BattleMap.super.setChanged();
                    BattleMap.super.notifyObservers(event);
                }
            });
            AnchorPane.setLeftAnchor(button,leftdis+80);
            AnchorPane.setTopAnchor(button,curpos);

            curpos+=20;
            ap.getChildren().add(button);
        }
    }

    private void battlePanelInit(){
        useSkillButtonMap = new HashMap<String,Button>();
        Map<String,Skill> skills = TheWorld.getTheWorld().getPlayer().getSkills();
        double curpos = 60;
        double leftdis = 900;
        {
            Button button = new Button("攻击");
            button.setId("attack");
            button.setFocusTraversable(false);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    BattleMap.super.setChanged();
                    BattleMap.super.notifyObservers(event);
                }
            });
            useSkillButtonMap.put("攻击",button);
            AnchorPane.setLeftAnchor(button,leftdis);
            AnchorPane.setTopAnchor(button,curpos);
            curpos+=20;
            ap.getChildren().add(button);
        }
        for(String skillName:skills.keySet()){
            Skill skill = skills.get(skillName);

            Button button = new Button("使用"+skill.getName());
            button.setId("use"+skillName);
            button.setFocusTraversable(false);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    BattleMap.super.setChanged();
                    BattleMap.super.notifyObservers(event);
                }
            });
            useSkillButtonMap.put(skillName,button);

            AnchorPane.setLeftAnchor(button,leftdis);
            AnchorPane.setTopAnchor(button,curpos);

            curpos+=20;
            ap.getChildren().add(button);
        }
    }
    private void enemyPanelInit(){
        double leftdis = 1100.0;
        enemyhp = new Text("生命值:"+String.valueOf(TheWorld.getTheWorld().getCurrentEnemy().getHitPoint()));
        AnchorPane.setLeftAnchor(enemyhp,leftdis);
        AnchorPane.setTopAnchor(enemyhp,10.0);
        ap.getChildren().add(enemyhp);

        enemyAttack = new Text("攻击:"+String.valueOf(TheWorld.getTheWorld().getCurrentEnemy().getDamage()));
        AnchorPane.setLeftAnchor(enemyAttack,leftdis);
        AnchorPane.setTopAnchor(enemyAttack,30.0);
        ap.getChildren().add(enemyAttack);

        enemyDefense = new Text("防御:"+String.valueOf(TheWorld.getTheWorld().getCurrentEnemy().getDefense()));
        AnchorPane.setLeftAnchor(enemyDefense,leftdis);
        AnchorPane.setTopAnchor(enemyDefense,50.0);
        ap.getChildren().add(enemyDefense);
    }
    private void messagePanelInit(){
        double leftdis = 900.0;
        message = new Text();
        AnchorPane.setLeftAnchor(message,leftdis);
        AnchorPane.setTopAnchor(message,250.0);
        ap.getChildren().add(message);
    }
    public Pane getPane(){
        return ap;
    }

    public void refresh(){
        drawMap();
        drawPlayerState();
        drawPlayerSkill();
        drawBattlePanel();
        drawEnemyPanel();
        drawMessagePanel();
    }

    private void drawMessagePanel(){
        message.setText(TheWorld.getTheWorld().getMessage());
    }

    private void drawEnemyPanel(){
        enemyhp.setText("生命值:"+String.valueOf(TheWorld.getTheWorld().getCurrentEnemy().getHitPoint()));
        enemyAttack.setText("攻击:"+String.valueOf(TheWorld.getTheWorld().getCurrentEnemy().getDamage()));
        enemyDefense.setText("防御:"+String.valueOf(TheWorld.getTheWorld().getCurrentEnemy().getDefense()));

        enemyhp.setVisible(TheWorld.getTheWorld().getPlayer().getState().equals(PlayerState.FIGHTING));
        enemyAttack.setVisible(TheWorld.getTheWorld().getPlayer().getState().equals(PlayerState.FIGHTING));
        enemyDefense.setVisible(TheWorld.getTheWorld().getPlayer().getState().equals(PlayerState.FIGHTING));
    }

    private void drawBattlePanel(){
        for(String skillName:useSkillButtonMap.keySet()){
            useSkillButtonMap.get(skillName).setVisible(TheWorld.getTheWorld().getPlayer().getState().equals(PlayerState.FIGHTING));
            if(TheWorld.getTheWorld().getPlayer().getSkills().containsKey(skillName)) {
                useSkillButtonMap.get(skillName).setDisable(TheWorld.getTheWorld().getPlayer().getSkills().get(skillName).getRemainTime() != 0);
            }
        }
    }

    private void drawPlayerState(){
        hp.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getHitPoint()));
        mp.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getMagicPoint()));
        attack.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getDamage()));
        defense.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getDefense()));
        gold.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getGold()));
        level.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getLevel()));
        exp.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getExperience()));
    }

    private void drawPlayerSkill(){
        for(String skillName:skillDescriptionMap.keySet()){
            skillDescriptionMap.get(skillName).setText(TheWorld.getTheWorld().getPlayer().getSkills().get(skillName).getName()+":lv."+TheWorld.getTheWorld().getPlayer().getSkills().get(skillName).getLevel());
        }
    }

    private void drawMap(){
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        for(int i = 0; i< GameMap.map.length; i++){
            for(int j = 0; j< GameMap.map[i].length; j++){
                Image image = null;
                if(GameMap.map[i][j]==0){
                    image = (Image) Images.map.get("floor");
                }
                if(GameMap.map[i][j]==1){
                    image = (Image)Images.map.get("wall");
                }
                canvas.getGraphicsContext2D().drawImage(image,j* GameMap.cell_width,i* GameMap.cell_height, GameMap.cell_width, GameMap.cell_height);
            }
        }

        canvas.getGraphicsContext2D().drawImage((Image)Images.map.get("player"),TheWorld.getTheWorld().getPlayer().getX()* GameMap.cell_width,TheWorld.getTheWorld().getPlayer().getY()* GameMap.cell_height, GameMap.cell_width, GameMap.cell_height);
        for(Monster monster: GameMap.monsterList){
            canvas.getGraphicsContext2D().drawImage((Image)Images.map.get("monster"),monster.getX()* GameMap.cell_width,monster.getY()* GameMap.cell_height, GameMap.cell_width, GameMap.cell_height);
        }
    }


}
