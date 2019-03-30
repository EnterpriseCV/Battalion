package model.role.player;

import model.PlayerState;
import model.equipment.EquipmentDecorator;
import model.role.Role;
import model.role.monster.Monster;
import model.skill.Skill;
import vo.ResultVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Player extends Role {

    int magicPoint;
    int experience;
    int level;
    int gold;
    PlayerState state;

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    List<EquipmentDecorator> equipments = new ArrayList<>();
    Map<String,Skill> skills = new HashMap<>();

    private int[] exp_level = new int[]{0,10,30,60,100,150,210,280,360,450};
    public abstract void updateDamage();

    public abstract void updateDefense();

    /**
     * 未造成伤害 state=false
     * 造成伤害 state=true
     * @param monster
     * @return
     */
    public ResultVO attackMonster(Monster monster,double dmgRate) {
        ResultVO vo = new ResultVO();
        int dmg = (int)Math.ceil(this.getDamage()*dmgRate) - monster.getDefense();
        if (dmg>0) {
            int tmp_hp = monster.getHitPoint()-dmg;
            monster.setHitPoint(tmp_hp>0?tmp_hp:0);

            if(tmp_hp<=0) {
                vo.setMessage("成功KO"+monster.getName());
                this.setGold(this.getGold()+monster.getGoldloot());
                this.setExperience(this.getExperience()+monster.getExploot());
                //判断是否要升级
                if (this.getExperience()>=exp_level[this.getLevel()]) {
                    this.setLevel(this.getLevel()+1);
                    vo.setMessage(vo.getMessage()+", 恭喜升至"+this.getLevel()+"级！");
                }
            }else {
                vo.setMessage("您对"+monster.getName()+"造成了"+dmg+"点伤害");
            }

        }else {
            vo.setState(false);
            vo.setMessage("本回合未对"+monster.getName()+"造成伤害");
        }
        return vo;
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
