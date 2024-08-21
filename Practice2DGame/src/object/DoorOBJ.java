package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class DoorOBJ extends SuperOBJ{

    public DoorOBJ(){
        name = "Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }

    public DoorOBJ(String name){
        this.name = name;

        if(name == "Gold_Door"){
            try {
                image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/golden_door.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        collision = true;
    }
}
