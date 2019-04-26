package com.bittech;

import java.awt.*;

public class GameObject {
    Image image;
    double x,y;
    double speed;
    int width,height;

    public GameObject(Image image, double x, double y, int speed, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image image, double x, double y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }



    public GameObject() {
    }

    public void drawSelf(Graphics g){
        g.drawImage(image,(int)x,(int)y,null);
    }

    // 获取图像所在的矩形,便于后续处理物体的碰撞检测，用矩形是否相交判断是否发生碰撞
    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
