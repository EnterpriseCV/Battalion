package configuration;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.TheWorld;

public class Map {
    public static final double cell_width = 30;
    public static final double cell_height = 30;
    public static final double[] map_size = {20,20};
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

        c.getGraphicsContext2D().fillRect(TheWorld.locX*cell_width,TheWorld.locY*cell_height,cell_width,cell_height);
    }
}
