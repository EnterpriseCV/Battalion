package model.role.player;

import model.equipment.EquipmentDecorator;
import model.role.Role;
import model.role.monster.Monster;
import model.skill.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Player extends Role {

    int magicPoint;
    int experience;
    int level;
    int gold;
    List<EquipmentDecorator> equipments = new ArrayList<>();
    Map<String,Skill> skills = new HashMap<>();

    public abstract void updateDamage();

    public abstract void updateDefense();

    /**
     * 返回造成的伤害值
     * @param monster
     * @return
     */
    public int attackMonster(Monster monster) {
        int dmg = this.getDamage()-monster.getDefense();
        if (dmg>0) {
            int tmp_hp = monster.getHitPoint()-dmg;
            monster.setHitPoint(tmp_hp>0?tmp_hp:0);
            if(tmp_hp<=0) {
                this.setGold(this.getGold()+monster.getGoldloot());
                this.setExperience(this.getExperience()+monster.getExploot());
            }
        }
        return dmg>0?dmg:0;
    }

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

    public Map<String, Skill> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Skill> skills) {
        this.skills = skills;
    }
}
