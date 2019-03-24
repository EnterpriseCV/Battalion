package model.skill;

import model.role.player.Player;
import vo.ResultVO;

/**
 * created by Kimone
 * date 2019/3/23
 */
public class Skill {
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

    public ResultVO useSkill() {
        ResultVO vo = new ResultVO();

        return vo;
    }

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
}
