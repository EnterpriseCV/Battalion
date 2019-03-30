package view;

import controller.EquipmentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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


    @FXML
    private CheckBox sight;

    @FXML
    private CheckBox stock;


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
            if(sight.isSelected()){
                weapon = "GunWithSight";
            }
            if(stock.isSelected()){
                weapon = "GunWithStock";
            }
            if(sight.isSelected()&&stock.isSelected()){
                weapon = "GunWithSightAndStock";
            }
        }

        if(armor.equals("布甲")){
            armor="cloth";
        }
        if(armor.equals("铁甲")){
            armor="armour";
        }
        new EquipmentController().equip(TheWorld.getTheWorld().getPlayer(),weapon,armor);
        Main.getInstance().navigateTo("skillchoose");
    }

    @FXML
    void weaponchanged(ActionEvent event) {
        String weapon = (((RadioButton)weaponsGroup.getSelectedToggle()).getText());
        if(weapon.equals("枪")){
            sight.setVisible(true);
            stock.setVisible(true);
        }else{
            sight.setVisible(false);
            stock.setVisible(false);
        }
        System.out.println(sight.isSelected());
    }

}
