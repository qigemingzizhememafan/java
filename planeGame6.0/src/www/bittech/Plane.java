package www.bittech;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
    boolean left,up,right,down;
    public void drawSelf(Graphics g){
        int speed = 3;
        g.drawImage(image,(int)x,(int)y,null);
        if(left){    // 坐标不同于数学坐标，坐标原地为左上角
            x -= speed;
        }
        if(right){
            x += speed;
        }
        if(up){
            y -= speed;
        }
        if(down){
            y += speed;
        }
    }

    public Plane(Image image, double x, double y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    // 按下某个键，增加相应的方向
    public void addDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }

    // 松开某个键，取消相应的方向
    public void minusDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }
}
