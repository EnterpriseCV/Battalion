package model.skill;

import configuration.Config;
import model.role.player.Player;
import vo.ResultVO;

/**
 * created by Kimone
 * date 2019/3/24
 */
public class Thump extends Skill {
    public Thump(Player player) {
        this.name = Config.thump_name;
        this.level = Config.thump_level;
        this.roleLevel = Config.thump_roleLevel;
        this.consumeMagicPoint = Config.thump_magicPoint;
        this.damageRate = Config.thump_damageRate;
        this.coolingTime = Config.thump_coolingTime;
        this.remainTime = Config.thump_remainTime;
        this.upgradeGold = Config.thump_upgradeGold;
        this.player = player;
    }

    @Override
    public ResultVO upgrade() {
        ResultVO vo = new ResultVO();
        if(player.getGold() >= upgradeGold) {
            player.setGold(player.getGold()-upgradeGold);
            level++;
            damageRate+=level*0.1;
            coolingTime+=1;
            consumeMagicPoint+=1*level;
            upgradeGold++;
        }else {
            vo.setState(false);
            vo.setMessage("您的金币不足，无法升级"+name+"技能");
            return vo;
        }
        return vo;
    }
    @Override
    public String toString() {
        return "Thump{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", roleLevel=" + roleLevel +
                ", consumeMagicPoint=" + consumeMagicPoint +
                ", damageRate=" + damageRate +
                ", coolingTime=" + coolingTime +
                ", remainTime=" + remainTime +
                ", upgradeGold=" + upgradeGold +
                '}';
    }
}
