package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import main.Main;
import model.TheWorld;

public class EquipmentChoose {

    @FXML
    private Button confirm;

    @FXML
    private Button naviback;

    @FXML
    private ToggleGroup weaponsGroup;

    @FXML
    private ToggleGroup armorGroup;


    public EquipmentChoose(){

    }

    @FXML
    void choosebuild(ActionEvent event) {
        Main.getInstance().navigateTo("buildchoose");
    }

    @FXML
    void actionStation(ActionEvent event) {
        System.out.println(((RadioButton)weaponsGroup.getSelectedToggle()).getText());
        String weapon = (((RadioButton)weaponsGroup.getSelectedToggle()).getText());
        String armor = (((RadioButton)armorGroup.getSelectedToggle()).getText());
        if(weapon.equals("法杖")){
            weapon="wand";
        }
        if(weapon.equals("枪")){
            weapon="GunWithNone";
        }

        if(armor.equals("布甲")){
            armor="cloth";
        }
        if(armor.equals("铁甲")){
            armor="armour";
        }
        new EquipmentController().equip(TheWorld.getTheWorld().getPlayer(),weapon,armor);
        Main.getInstance().gotoBattleMap();
    }

}
