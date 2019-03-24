package main;

import configuration.Map;
import controller.BattleMap;
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
import model.role.monster.Monster;


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
        Scene sc = new Scene(new BattleMap().getPane(),1280,720);
        stage.setScene(sc);


    }
}
