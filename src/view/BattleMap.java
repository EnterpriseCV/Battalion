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
import main.Main;
import model.TheWorld;
import model.role.monster.Monster;
import model.role.player.Player;

import java.util.Observable;

public class BattleMap extends Observable  {
    AnchorPane ap;
    boolean inBattle;
    public BattleMap(){
        super();
        ap = new AnchorPane();
        inBattle = false;
        Canvas c = new Canvas(700,700);
        AnchorPane.setLeftAnchor(c,10.0);
        AnchorPane.setTopAnchor(c,10.0);

        c.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                BattleMap.super.setChanged();
                BattleMap.super.notifyObservers(event);
                if(inBattle){
                    return;
                }
                int tx = TheWorld.getTheWorld().getPlayer().getX();
                int ty = TheWorld.getTheWorld().getPlayer().getY();

                if(event.getCode()== KeyCode.UP){
                    ty-=1;
                }
                if(event.getCode()== KeyCode.DOWN){
                    ty+=1;
                }
                if(event.getCode()== KeyCode.LEFT){
                    tx-=1;
                }
                if(event.getCode()== KeyCode.RIGHT){
                    tx+=1;
                }

                for(int i = 0; i< Map.monsterList.size(); i++){
                    Monster monster = Map.monsterList.get(i);
                    if(monster.getX()==tx&&monster.getY()==ty){
                        doBattle(TheWorld.getTheWorld().getPlayer(),monster);
                    }
                }

                if(tx>=0&&tx<Map.map_size&&ty>=0&&ty<Map.map_size&&Map.map[ty][tx]==0){
                    TheWorld.getTheWorld().getPlayer().setX(tx);
                    TheWorld.getTheWorld().getPlayer().setY(ty);
                }

                repaint(c);
            }
        });
        c.setFocusTraversable(true);
        c.requestFocus();
        ap.getChildren().addAll(c);

        Label hpLabel  = new Label("生命值");
        AnchorPane.setLeftAnchor(hpLabel,900.0);
        AnchorPane.setTopAnchor(hpLabel,10.0);
        ap.getChildren().add(hpLabel);

        Text hp = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getHitPoint()));
        AnchorPane.setLeftAnchor(hp,940.0);
        AnchorPane.setTopAnchor(hp,10.0);
        ap.getChildren().add(hp);

        Label mpLabel  = new Label("魔力值");
        AnchorPane.setLeftAnchor(mpLabel,900.0);
        AnchorPane.setTopAnchor(mpLabel,30.0);
        ap.getChildren().add(mpLabel);

        Text mp = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getMagicPoint()));
        AnchorPane.setLeftAnchor(mp,940.0);
        AnchorPane.setTopAnchor(mp,30.0);
        ap.getChildren().add(mp);


        Label attackLabel  = new Label("攻击");
        AnchorPane.setLeftAnchor(attackLabel,900.0);
        AnchorPane.setTopAnchor(attackLabel,50.0);
        ap.getChildren().add(attackLabel);

        Text attack = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getDamage()));
        AnchorPane.setLeftAnchor(attack,940.0);
        AnchorPane.setTopAnchor(attack,50.0);
        ap.getChildren().add(attack);

        Label defenseLabel  = new Label("防御");
        AnchorPane.setLeftAnchor(defenseLabel,900.0);
        AnchorPane.setTopAnchor(defenseLabel,70.0);
        ap.getChildren().add(defenseLabel);

        Text defense = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getDefense()));
        AnchorPane.setLeftAnchor(defense,940.0);
        AnchorPane.setTopAnchor(defense,70.0);
        ap.getChildren().add(defense);

        Label goldLabel  = new Label("金币");
        AnchorPane.setLeftAnchor(goldLabel,900.0);
        AnchorPane.setTopAnchor(goldLabel,90.0);
        ap.getChildren().add(goldLabel);

        Text gold = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getGold()));
        AnchorPane.setLeftAnchor(gold,940.0);
        AnchorPane.setTopAnchor(gold,90.0);
        ap.getChildren().add(gold);

        repaint(c);
    }
    public Pane getPane(){
        return ap;
    }

    private boolean doBattle(Player player, Monster monster){
        boolean winning = false;
        inBattle = true;
        GridPane gp = new GridPane();
        gp.setBackground(Background.EMPTY);
        gp.setPadding(new Insets(5));
        ((GridPane) gp).setHgap(5);
        ((GridPane) gp).setVgap(5);
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
        column2.setHgrow(Priority.ALWAYS);
        gp.getColumnConstraints().addAll(column1, column2);
        Button winButton = new Button("win");
        GridPane.setHalignment(winButton, HPos.RIGHT);
        gp.add(winButton, 0, 2);
        winButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                inBattle=false;
                Map.monsterList.remove(monster);
                ap.getChildren().remove(gp);
            }
        });
        AnchorPane.setTopAnchor(gp,250.0);
        AnchorPane.setLeftAnchor(gp,50.0);
        ap.getChildren().add(gp);
        return winning;
    }

    public void repaint(Canvas c){
        c.getGraphicsContext2D().clearRect(0,0,c.getWidth(),c.getHeight());
        for(int i=0;i<Map.map.length;i++){
            for(int j=0;j<Map.map[i].length;j++){
                Image image = null;
                if(Map.map[i][j]==0){
                    image = (Image) Images.map.get("floor");
                }
                if(Map.map[i][j]==1){
                    image = (Image)Images.map.get("wall");
                }
                c.getGraphicsContext2D().drawImage(image,j*Map.cell_width,i*Map.cell_height,Map.cell_width,Map.cell_height);
            }
        }

        c.getGraphicsContext2D().drawImage((Image)Images.map.get("player"),TheWorld.getTheWorld().getPlayer().getX()*Map.cell_width,TheWorld.getTheWorld().getPlayer().getY()*Map.cell_height,Map.cell_width,Map.cell_height);
        for(Monster monster:Map.monsterList){
            c.getGraphicsContext2D().drawImage((Image)Images.map.get("monster"),monster.getX()*Map.cell_width,monster.getY()*Map.cell_height,Map.cell_width,Map.cell_height);
        }
    }
}
