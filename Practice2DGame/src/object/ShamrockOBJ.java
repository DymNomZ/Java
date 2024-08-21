package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ShamrockOBJ extends SuperOBJ {
    
    public ShamrockOBJ(){
        name = "Shamrock";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/shamrock.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
