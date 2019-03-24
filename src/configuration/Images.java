package configuration;

import javafx.scene.image.Image;

import java.util.HashMap;

public class Images {
    public static java.util.Map map = new HashMap<String,Images>();
    static{
        String imageString = "graphics/tilesets/MTwall1.png";
        map.put("wall",new Image(imageString));

        imageString = "graphics/tilesets/MTpass1.png";
        map.put("floor",new Image(imageString));

        imageString = "graphics/items/011-Braver01.png";
        map.put("player",new Image(imageString));
    }

}
