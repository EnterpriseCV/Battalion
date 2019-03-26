package model.skill;

import model.role.monster.Monster;
import model.role.player.Player;
import vo.ResultVO;

import java.util.Timer;
import java.util.TimerTask;

/**
 * created by Kimone
 * date 2019/3/23
 */
public abstract class Skill {
     String name;
     int level;
     int roleLevel;
     int consumeMagicPoint;
     double damageRate;
     int coolingTime;
     int remainTime;
     int upgradeGold;
     Player player;

    /**
     * 添加技能前检查用户等级
     * @return
     */
    public ResultVO checkBeforeAdd(){
        ResultVO vo = new ResultVO();
        if(player.getLevel() < roleLevel) {
            vo.setState(false);
            vo.setMessage("您的等级不够，不可以选择"+name+"技能");
            return vo;
        }
        return vo;
    }

    /**
     * 不满足使用技能的条件 state=false
     * 满足则 state=true
     * @return
     */
    public ResultVO checkBeforeUse(){
        ResultVO vo = new ResultVO();
        //check player's magic point
        if(player.getMagicPoint() < consumeMagicPoint) {
            vo.setState(false);
            vo.setMessage("您的魔力值不足以使用"+name+"技能");
            return vo;
        }

        if (remainTime > 0) {
            vo.setState(false);
            vo.setMessage(name+"技能冷却中");
            return vo;
        }
        return vo;
    }

    /**
     * 使用技能
     * @param monster
     * @return
     */
    public ResultVO useSkill(Monster monster) {
        ResultVO vo = player.attackMonster(monster,damageRate);
        player.setMagicPoint(player.getMagicPoint()-this.getConsumeMagicPoint());
        this.setRemainTime(this.getCoolingTime());

        Timer timer = new Timer();
        Task task = new Task(timer,this);

        timer.schedule(task,0, 1000);
        return vo;
    }

    /**
     * 升级技能
     * @return
     */
    public abstract ResultVO upgrade() ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(int roleLevel) {
        this.roleLevel = roleLevel;
    }

    public int getConsumeMagicPoint() {
        return consumeMagicPoint;
    }

    public void setConsumeMagicPoint(int consumeMagicPoint) {
        this.consumeMagicPoint = consumeMagicPoint;
    }

    public double getDamageRate() {
        return damageRate;
    }

    public void setDamageRate(double damageRate) {
        this.damageRate = damageRate;
    }

    public int getCoolingTime() {
        return coolingTime;
    }

    public void setCoolingTime(int coolingTime) {
        this.coolingTime = coolingTime;
    }

    public int getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(int remainTime) {
        this.remainTime = remainTime;
    }

    public int getUpgradeGold() {
        return upgradeGold;
    }

    public void setUpgradeGold(int upgradeGold) {
        this.upgradeGold = upgradeGold;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
