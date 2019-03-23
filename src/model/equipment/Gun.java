package model.equipment;

import configuration.Config;
import model.equipment.components.buttstock.Buttstock;
import model.equipment.components.sight.Sight;
import model.role.player.Player;

/**
 * created by Kimone
 * date 2019/3/23
 */
public class Gun extends EquipmentDecorator{
    private int bulletNum;
    private int damage;
    private Sight sight;
    private Buttstock stock;
    Player player;

    public Gun(Player player){
        this.bulletNum = Config.gun_bulletNum;
        this.damage = Config.gun_damage;
        this.player = player;
    }

    public int getBulletNum() {
        return bulletNum;
    }

    public void setBulletNum(int bulletNum) {
        this.bulletNum = bulletNum;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Sight getSight() {
        return sight;
    }

    public void setSight(Sight sight) {
        this.sight = sight;
    }

    public Buttstock getStock() {
        return stock;
    }

    public void setStock(Buttstock stock) {
        this.stock = stock;
    }

    @Override
    public void updateDamage() {
        player.setDamage(player.getDamage()+this.getDamage());
    }

    @Override
    public void updateDefense() {
    }
}
