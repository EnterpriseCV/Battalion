package controller;

import model.role.monster.Monster;
import model.role.player.Player;
import model.skill.Skill;
import vo.ResultVO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * created by Kimone
 * date 2019/3/24
 */
public class SkillController {
    /**
     *添加技能
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


    /**
     * 使用技能
     * @param player
     * @param monster
     * @param skillName
     * @return
     */
    public ResultVO useSkill(Player player, Monster monster,String skillName) {
        ResultVO vo ;
        Skill skill = player.getSkills().get(skillName);
        vo = skill.checkBeforeUse();
        if(!vo.isState()){
            return vo;
        }else {
            vo = skill.useSkill(monster);
            return vo;
        }
//        return vo;
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

    public void removeAllSkill(Player player) {
        Map<String, Skill> skillMap = player.getSkills();
        skillMap.clear();
    }
}
