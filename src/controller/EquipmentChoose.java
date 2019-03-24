package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.Main;

public class EquipmentChoose {

    @FXML
    private Button confirm;

    @FXML
    private Button naviback;

    @FXML
    private TextField playName;

    public EquipmentChoose(){
    }

    @FXML
    void choosebuild(ActionEvent event) {
        Main.getInstance().navigateTo("buildchoose");
    }

    @FXML
    void actionStation(ActionEvent event) {
        Main.getInstance().gotoBattleMap();
    }

}
