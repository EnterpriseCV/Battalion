package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import main.Main;

public class SkillChoose {
    @FXML
    private CheckBox thump;

    @FXML
    private CheckBox fire;

    @FXML
    void naviBack(ActionEvent event) {
        Main.getInstance().navigateTo("equipmentchoose");
    }

    @FXML
    void confirm(ActionEvent event) {
        Main.getInstance().gotoBattleMap();
    }
}
