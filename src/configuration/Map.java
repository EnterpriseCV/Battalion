package configuration;

import controller.RoleController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.TheWorld;
import model.role.monster.Monster;

import java.util.LinkedList;
import java.util.List;

public class Map {
    public static final double cell_width = 30;
    public static final double cell_height = 30;
    public static final int map_size = 20;
    public static final int[][] map= {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    public static List<Monster> monsterList = new LinkedList<Monster>();
    static{
        RoleController rc = new RoleController();
        Monster monster=rc.createMonster("monster01");
        monster.setX(10);
        monster.setY(0);
        monsterList.add(monster);
    }
}
