package com.bittech;

import java.awt.*;

// 炮弹类
public class Shell extends GameObject{
    double degree; // 炮弹角度
    public Shell(){
        x = 200;
        y = 200;
        width = 10;
        height = 10;
        speed = 0.4; // 炮弹开始在(200,200)处，宽度为10，高度为10，炮弹速度为4
        degree = Math.random()*Math.PI*2; // Math.random为0~1之间的随机数，
                                          // 乘2pi，即角度在0~2pi弧度之间
    }
    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.YELLOW); // 设置炮弹颜色为黄色
        g.fillOval((int)x,(int)y,width,height); //填充炮弹为实心圆

        // 炮弹沿着任意角度去飞
        x += speed*Math.cos(degree);  //初中数学三角函数
        y += speed*Math.sin(degree);  //参考手机相册中的飞行路径图

        //炮弹碰到边界应沿着与法线之间的夹角弹回来
        if(x < 0 || x > Constant.GAME_WIDTH - width) { //小于窗口宽度减去球本身的宽度
            degree = Math.PI - degree;
        }
        if(y < 30 || y > Constant.GAME_HEIGHT - height){ // 考虑窗口的边界占的距离
            degree = -degree;
        }
        g.setColor(c);  //将颜色恢复
    }
}
