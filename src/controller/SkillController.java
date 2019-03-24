package controller;

import model.role.monster.Monster;
import model.role.player.Player;
import model.skill.Skill;
import vo.ResultVO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * created by Kimone
 * date 2019/3/24
 */
public class SkillController {
    /**
     *
     * @param player
     * @param skills Thump/Fire
     */
    public ResultVO addSkill(Player player, String[] skills){
        ResultVO vo = null;
        for (String s:skills) {
            String classname = "model.skill."+s;
            Skill skill;
            Class clazz = null;
            try {
                clazz = Class.forName(classname);
                Constructor constructor = clazz.getConstructor(Player.class);
                skill = (Skill) constructor.newInstance(player);
                vo = skill.checkBeforeAdd();
                if(vo.isState()) {
                    player.getSkills().put(s,skill);
                }else {
                    return vo;
                }
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
        return vo;
    }


    public ResultVO useSkill(Player player, Monster monster,String skillName) {
        ResultVO vo = null;
        Skill skill = player.getSkills().get(skillName);
        vo = skill.checkBeforeUse();
        if(!vo.isState()){
            return vo;
        }else {
            //TODO
        }
        return vo;
    }

    /**
     * 升级技能
     * @param skillName
     * @return
     */
    public ResultVO upgradeSkill(Player player, String skillName) {
        Skill skill = player.getSkills().get(skillName);
        return skill.upgrade();
    }
}
