package controller;

import model.equipment.*;
import model.equipment.builder.GunBuilder;
import model.role.player.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


/**
 * created by Kimone
 * date 2019/3/23
 */
public class EquipmentController {
    /**
     *
     * @param player
     * @param weapon wand/GunWithNone/GunWithSight/GunWithSightAndStock/GunWithStock
     * @param armor armour/cloth
     */
    public void equip(Player player,String weapon, String armor){
        Player equipment;
        if(weapon.equals("wand")) {
            equipment = new Wand(player);
            update(player,equipment);
//            equipment.updateDamage();
//            equipment.updateDefense();
        }
        if(weapon.startsWith("Gun")){
            GunBuilder builder;
            String classname = "model.equipment.builder."+weapon;
            try {
                Class clazz = Class.forName(classname);
                Constructor constructor = clazz.getConstructor(Player.class);
                builder = (GunBuilder) constructor.newInstance(player);
                GunDirector director = new GunDirector(builder);
                equipment = director.construct();
                update(player,equipment);
//                equipment.updateDamage();
//                equipment.updateDefense();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if(armor.equals("armour")){
            equipment = new Armour(player);
            update(player,equipment);
//            equipment.updateDamage();
//            equipment.updateDefense();
        }
        if(armor.equals("cloth")){
            equipment = new Cloth(player);
            update(player,equipment);
//            equipment.updateDamage();
//            equipment.updateDefense();
        }
    }

    private void update(Player player, Player equipment){
        equipment.updateDefense();
        equipment.updateDamage();
        List equipments = player.getEquipments();
        equipments.add(equipment);
    }


}
