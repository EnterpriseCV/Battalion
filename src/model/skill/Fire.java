package model.skill;

import configuration.Config;
import model.role.player.Player;
import vo.ResultVO;

/**
 * created by Kimone
 * date 2019/3/24
 */
public class Fire extends Skill {
    public Fire(Player player) {
        this.name = Config.fire_name;
        this.level = Config.fire_level;
        this.roleLevel = Config.fire_roleLevel;
        this.consumeMagicPoint = Config.fire_magicPoint;
        this.damageRate = Config.fire_damageRate;
        this.coolingTime = Config.fire_coolingTime;
        this.remainTime = Config.fire_remainTime;
        this.upgradeGold = Config.fire_upgradeGold;
        this.player = player;
    }

    @Override
    public String toString() {
        return "Fire{" +
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
