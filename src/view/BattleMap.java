package view;

import configuration.Images;
import configuration.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import model.TheWorld;
import model.role.monster.Monster;
import model.role.player.Player;

import java.util.Observable;

public class BattleMap extends Observable  {
    AnchorPane ap;
    Canvas canvas;
    Text hp,mp,attack,defense,gold,level,exp;
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

        Label hpLabel  = new Label("生命值");
        AnchorPane.setLeftAnchor(hpLabel,900.0);
        AnchorPane.setTopAnchor(hpLabel,10.0);
        ap.getChildren().add(hpLabel);

        hp = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getHitPoint()));
        AnchorPane.setLeftAnchor(hp,940.0);
        AnchorPane.setTopAnchor(hp,10.0);
        ap.getChildren().add(hp);

        Label mpLabel  = new Label("魔力值");
        AnchorPane.setLeftAnchor(mpLabel,900.0);
        AnchorPane.setTopAnchor(mpLabel,30.0);
        ap.getChildren().add(mpLabel);

        mp = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getMagicPoint()));
        AnchorPane.setLeftAnchor(mp,940.0);
        AnchorPane.setTopAnchor(mp,30.0);
        ap.getChildren().add(mp);


        Label attackLabel  = new Label("攻击");
        AnchorPane.setLeftAnchor(attackLabel,900.0);
        AnchorPane.setTopAnchor(attackLabel,50.0);
        ap.getChildren().add(attackLabel);

        attack = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getDamage()));
        AnchorPane.setLeftAnchor(attack,940.0);
        AnchorPane.setTopAnchor(attack,50.0);
        ap.getChildren().add(attack);

        Label defenseLabel  = new Label("防御");
        AnchorPane.setLeftAnchor(defenseLabel,900.0);
        AnchorPane.setTopAnchor(defenseLabel,70.0);
        ap.getChildren().add(defenseLabel);

        defense = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getDefense()));
        AnchorPane.setLeftAnchor(defense,940.0);
        AnchorPane.setTopAnchor(defense,70.0);
        ap.getChildren().add(defense);

        Label goldLabel  = new Label("金币");
        AnchorPane.setLeftAnchor(goldLabel,900.0);
        AnchorPane.setTopAnchor(goldLabel,90.0);
        ap.getChildren().add(goldLabel);

        gold = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getGold()));
        AnchorPane.setLeftAnchor(gold,940.0);
        AnchorPane.setTopAnchor(gold,90.0);
        ap.getChildren().add(gold);

        Label levelLabel  = new Label("等级");
        AnchorPane.setLeftAnchor(levelLabel,900.0);
        AnchorPane.setTopAnchor(levelLabel,110.0);
        ap.getChildren().add(levelLabel);

        level = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getLevel()));
        AnchorPane.setLeftAnchor(level,940.0);
        AnchorPane.setTopAnchor(level,110.0);
        ap.getChildren().add(level);

        Label expLabel  = new Label("经验");
        AnchorPane.setLeftAnchor(expLabel,900.0);
        AnchorPane.setTopAnchor(expLabel,130.0);
        ap.getChildren().add(expLabel);

        exp = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getExperience()));
        AnchorPane.setLeftAnchor(exp,940.0);
        AnchorPane.setTopAnchor(exp,130.0);
        ap.getChildren().add(exp);

        refresh();
    }
    public Pane getPane(){
        return ap;
    }

    public void refresh(){
        drawMap();
        drawPlayState();

    }

    private void drawPlayState(){
        hp.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getHitPoint()));
        mp.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getMagicPoint()));
        attack.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getDamage()));
        defense.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getDefense()));
        gold.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getGold()));
        level.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getLevel()));
        exp.setText(String.valueOf(TheWorld.getTheWorld().getPlayer().getExperience()));
    }

    private void drawMap(){
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        for(int i=0;i<Map.map.length;i++){
            for(int j=0;j<Map.map[i].length;j++){
                Image image = null;
                if(Map.map[i][j]==0){
                    image = (Image) Images.map.get("floor");
                }
                if(Map.map[i][j]==1){
                    image = (Image)Images.map.get("wall");
                }
                canvas.getGraphicsContext2D().drawImage(image,j*Map.cell_width,i*Map.cell_height,Map.cell_width,Map.cell_height);
            }
        }

        canvas.getGraphicsContext2D().drawImage((Image)Images.map.get("player"),TheWorld.getTheWorld().getPlayer().getX()*Map.cell_width,TheWorld.getTheWorld().getPlayer().getY()*Map.cell_height,Map.cell_width,Map.cell_height);
        for(Monster monster:Map.monsterList){
            canvas.getGraphicsContext2D().drawImage((Image)Images.map.get("monster"),monster.getX()*Map.cell_width,monster.getY()*Map.cell_height,Map.cell_width,Map.cell_height);
        }
    }


}
