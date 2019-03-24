package main;

import configuration.Map;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
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
        AnchorPane.setTopAnchor(c,40.0);

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








        Scene sc = new Scene(ap,1280,720);
        stage.setScene(sc);


    }
}
