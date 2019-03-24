package configuration;

/**
 * created by Kimone
 * date 2019/3/20
 */
public class Config {
    //战士属性
    public static final String warrior_name = "战士";
    public static final int warrior_hitPoint = 1000;
    public static final int warrior_defense = 10;
    public static final int warrior_damage = 10;
    public static final int warrior_magicPoint = 100;
    public static final int warrior_exp = 0;
    public static final int warrior_level = 1;
    public static final int warrior_gold = 0;


    //法师属性
    public static final String master_name = "法师";
    public static final int master_hitPoint = 1000;
    public static final int master_defense = 200;
    public static final int master_damage = 10;
    public static final int master_magicPoint = 10;
    public static final int master_exp = 0;
    public static final int master_level = 1;
    public static final int master_gold = 0;


    //法杖属性
    public static final int wand_defense = 5;
    public static final int wand_damage = 10;

    //铁甲属性
    public static final int armour_defense = 10;
    public static final int armour_damage = 0;

    //布甲属性
    public static final int cloth_defense = 5;
    public static final int cloth_damage = 0;

    //枪
    public static final int gun_damage = 10;
    public static final int gun_bulletNum = 10;
    public static final int mirror_damage = 2;
    public static final int tactical_damage = 1;

    //重击技能
    public static final String thump_name = "重击";
    public static final int thump_level = 1;
    public static final int thump_roleLevel = 1;
    public static final int thump_magicPoint = 10;
    public static final double thump_damageRate = 1.2;
    public static final int thump_coolingTime = 3;
    public static final int thump_remainTime = 0;
    public static final int thump_upgradeGold = 2;

    //大火球技能
    public static final String fire_name = "大火球";
    public static final int fire_level = 1;
    public static final int fire_roleLevel = 3;
    public static final int fire_magicPoint = 20;
    public static final double fire_damageRate = 1.5;
    public static final int fire_coolingTime = 5;
    public static final int fire_remainTime = 0;
    public static final int fire_upgradeGold = 5;
}
