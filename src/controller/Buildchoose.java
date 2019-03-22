package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Buildchoose {
    @FXML
    private Button warriorButton;

    @FXML
    private Button mageButton;

    @FXML
    void chooseBuild(ActionEvent event) {
        System.out.println(((Button)event.getSource()).getText());
    }
}
