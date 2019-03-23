package model.role.player;

import model.equipment.EquipmentDecorator;
import model.role.Role;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Role {

    int magicPoint;
    int experience;
    int level;
    int gold;
    List<EquipmentDecorator> equipments = new ArrayList<>();

    public abstract void updateDamage();

    public abstract void updateDefense();

    public int getMagicPoint() {
        return magicPoint;
    }

    public void setMagicPoint(int magicPoint) {
        this.magicPoint = magicPoint;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public List<EquipmentDecorator> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<EquipmentDecorator> equipments) {
        this.equipments = equipments;
    }
}
