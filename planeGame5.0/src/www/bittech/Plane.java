package www.bittech;

import java.awt.*;

public class Plane extends GameObject {
    public void drawSelf(Graphics g){
        g.drawImage(image,(int)x,(int)y,null);
        x++;
    }

    public Plane(Image image, double x, double y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }
}
