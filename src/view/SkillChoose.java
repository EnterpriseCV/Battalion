package view;

import controller.SkillController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import main.Main;
import model.TheWorld;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
        SkillController sc = new SkillController();
        ArrayList<String> skills = new ArrayList<String>();
        if(thump.isSelected()){
            skills.add("Thump");
        }if(fire.isSelected()){
            skills.add("Fire");
        }
        sc.addSkill(TheWorld.getTheWorld().getPlayer(),skills.toArray(new String[]{}));
        Main.getInstance().gotoBattleMap();
    }
}
