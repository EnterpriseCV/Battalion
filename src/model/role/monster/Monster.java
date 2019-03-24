package model.role.monster;

import model.role.Role;
import model.role.player.Player;
import vo.ResultVO;

public class Monster extends Role {
    private int exploot;
    private int goldloot;

    public Monster(String name, int hitPoint, int defense, int damage, int exploot, int goldloot) {
        this.setName(name);
        this.setHitPoint(hitPoint);
        this.setDefense(defense);
        this.setDamage(damage);
        this.exploot = exploot;
        this.goldloot = goldloot;
    }


    public ResultVO attackPlayer(Player player) {
        ResultVO vo = new ResultVO();
        int dmg = this.getDamage() - player.getDefense();
        if (dmg > 0) {
            int tmp_hp = player.getHitPoint() - dmg;
            player.setHitPoint(tmp_hp>0?tmp_hp:0);
            if(tmp_hp<=0) {
                vo.setMessage("Game Over");
            }else {
                vo.setMessage(this.getName()+"对您造成了"+dmg+"点伤害");
            }
        }else {
            vo.setState(false);
            vo.setMessage(this.getName()+"本回合未对您造成伤害");
        }
        return vo;
    }

    public int getExploot() {
        return exploot;
    }

    public void setExploot(int exploot) {
        this.exploot = exploot;
    }

    public int getGoldloot() {
        return goldloot;
    }

    public void setGoldloot(int goldloot) {
        this.goldloot = goldloot;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name=" + getName() +
                ", hitPoint=" + getHitPoint() +
                ", defense=" + getDefense() +
                ", damage=" + getDamage() +
                ", exploot=" + exploot +
                ", goldloot=" + goldloot +
                '}';
    }
}
