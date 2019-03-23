package model.skill;

import java.util.Map;

/**
 * created by Kimone
 * date 2019/3/23
 */
public abstract class Skill {
    private String name;
    private int level;
    private int roleLevel;
    private int consumeMagicPoint;
    private double damageRate;
    private int coolingTime;

    public abstract Map<Boolean, String> checkBeforeUse();
}
