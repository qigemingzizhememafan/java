package com.bittech;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
    boolean left,up,right,down;
    boolean live = true;
    public void drawSelf(Graphics g){
        if(live){
            int speed = 2;
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
        }else{

        }
    }

    public Plane(Image image, double x, double y) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = 3;
        this.width = 10;  //本图的飞机素材较大，故不用image.getWidth(null)，而是自己设定为
        this.height = 10; //与炸弹同等大小的10
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
