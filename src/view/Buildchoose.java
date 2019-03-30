package view;

import controller.RoleController;
import factory.AbstractFactory;
import factory.playerFactory.PlayerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.Main;
import model.TheWorld;

public class Buildchoose {
    @FXML
    private Button warriorButton;

    @FXML
    private Button mageButton;

    @FXML
    void chooseBuild(ActionEvent event) {
        String buildName = ((Button)event.getSource()).getText();
        if(buildName.equals("战士")){
            buildName = "warrior";
        }else if(buildName.equals("法师")){
            buildName = "master";
        }
        TheWorld.getTheWorld().setPlayer(new RoleController().createPlayer(buildName));
        TheWorld.getTheWorld().setCurrentEnemy(TheWorld.getTheWorld().getPlayer());
        Main.getInstance().navigateTo("equipmentchoose");
    }
}
