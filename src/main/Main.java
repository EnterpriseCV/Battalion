package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URLDecoder;

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
}
