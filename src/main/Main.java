package main;

import configuration.Map;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.TheWorld;


public class Main extends Application {
    private Stage stage;

    private static Main instance;

    public Main(){
        instance = this;
    }

    public static Main getInstance(){
        return instance;
    }

    public static void main(String args[]){
        launch(args);
    }

    public void navigateTo(String fxml){
        try{
            replaceSceneContent(fxml);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            stage = primaryStage;
            navigateTo("buildchoose");
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(Main.class.getResource("../fxmlfiles/"+fxml+".fxml"));
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 1280, 720);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }

    public void gotoBattleMap(){
        AnchorPane ap = new AnchorPane();


        Canvas c = new Canvas(700,700);
        AnchorPane.setLeftAnchor(c,10.0);
        AnchorPane.setTopAnchor(c,10.0);

        c.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()== KeyCode.UP){
                    TheWorld.locY-=1;
                }
                if(event.getCode()== KeyCode.DOWN){
                    TheWorld.locY+=1;
                }
                if(event.getCode()== KeyCode.LEFT){
                    TheWorld.locX-=1;
                }
                if(event.getCode()== KeyCode.RIGHT){
                    TheWorld.locX+=1;
                }
                Map.repaint(c);
            }
        });
        c.setFocusTraversable(true);
        c.requestFocus();
        ap.getChildren().addAll(c);
        Map.repaint(c);

        Label hpLabel  = new Label("生命值");
        AnchorPane.setLeftAnchor(hpLabel,900.0);
        AnchorPane.setTopAnchor(hpLabel,10.0);
        ap.getChildren().add(hpLabel);

        Text hp = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getHitPoint()));
        AnchorPane.setLeftAnchor(hp,940.0);
        AnchorPane.setTopAnchor(hp,10.0);
        ap.getChildren().add(hp);


        Label attackLabel  = new Label("攻击");
        AnchorPane.setLeftAnchor(attackLabel,900.0);
        AnchorPane.setTopAnchor(attackLabel,30.0);
        ap.getChildren().add(attackLabel);

        Text attack = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getDamage()));
        AnchorPane.setLeftAnchor(attack,940.0);
        AnchorPane.setTopAnchor(attack,30.0);
        ap.getChildren().add(attack);

        Label defenseLabel  = new Label("防御");
        AnchorPane.setLeftAnchor(defenseLabel,900.0);
        AnchorPane.setTopAnchor(defenseLabel,50.0);
        ap.getChildren().add(defenseLabel);

        Text defense = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getDefense()));
        AnchorPane.setLeftAnchor(defense,940.0);
        AnchorPane.setTopAnchor(defense,50.0);
        ap.getChildren().add(defense);

        Label goldLabel  = new Label("金币");
        AnchorPane.setLeftAnchor(goldLabel,900.0);
        AnchorPane.setTopAnchor(goldLabel,70.0);
        ap.getChildren().add(goldLabel);

        Text gold = new Text(String.valueOf(TheWorld.getTheWorld().getPlayer().getGold()));
        AnchorPane.setLeftAnchor(gold,940.0);
        AnchorPane.setTopAnchor(gold,70.0);
        ap.getChildren().add(gold);



        Scene sc = new Scene(ap,1280,720);
        stage.setScene(sc);


    }
}
