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


    public static void repaint(Canvas c){
        c.getGraphicsContext2D().clearRect(0,0,c.getWidth(),c.getHeight());
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                Image image = null;
                if(map[i][j]==0){
                    image = (Image)Images.map.get("floor");
                }
                if(map[i][j]==1){
                    image = (Image)Images.map.get("wall");
                }
                c.getGraphicsContext2D().drawImage(image,j*cell_width,i*cell_height,cell_width,cell_height);
            }
        }

        c.getGraphicsContext2D().drawImage((Image)Images.map.get("player"),TheWorld.getTheWorld().getPlayer().getX()*cell_width,TheWorld.getTheWorld().getPlayer().getY()*cell_height,cell_width,cell_height);
        for(Monster monster:monsterList){
            c.getGraphicsContext2D().drawImage((Image)Images.map.get("monster"),monster.getX()*cell_width,monster.getY()*cell_height,cell_width,cell_height);
        }
    }
}
