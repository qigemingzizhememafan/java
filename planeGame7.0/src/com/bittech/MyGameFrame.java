package com.bittech;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 初始化游戏窗口
public class MyGameFrame extends Frame {
    Image planeImg = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");


    Plane plane = new Plane(planeImg,250,250); //实例化飞机
    Shell[] shells = new Shell[50]; // 建立50个炮弹的数组
//    Explode  bao;

    // 在窗口内画东西
    public void paint(Graphics g){  //该方法会自动被调用，g相当于一支画笔
        g.drawImage(bg,0,0,null); // 画背景

        plane.drawSelf(g); // 画飞机
        // 画出50个炮弹
        for(int i = 0; i < shells.length; i++) {
            shells[i].draw(g);  // 画炮弹

            //每创建一个炸弹，都要判断炸弹与飞机是否相撞，相撞则飞机死亡
            //取得每一个炸弹的所在矩形，java提供intersets方法可以判断矩形是否相交，此处直接调用即可
            boolean peng = shells[i].getRect().intersects(plane.getRect());
            if(peng){
                plane.live = false;
//                if(bao == null){
//                    bao = new Explode(plane.x,plane.y);
//                }
//                bao.draw(g);
            }

        }
    }

    // 初始化界面
    public void launchFrame(){
        //设置标题
        this.setTitle("hit plane game by lzl");
        //窗口默认不可见，将其改为可见
        this.setVisible(true);
        // 设置窗口大小
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        // 设置窗口位置
        this.setLocation(300,300);
        //真正关闭游戏窗口
        this.addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); //结束虚拟机运行，0表示正常结束
            }
        });
        new PaintThread().start();  //启动重画窗口的线程
        addKeyListener(new KeyMonitor()); // 增加键盘监听

        // 初始化50个炮弹
        for(int i = 0; i < shells.length; i++){
            shells[i] = new Shell();
        }
    }



    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }

    // 解决频闪问题，因为该主类继承Frame导致产生频闪，若继承JFrame则会产生较小的频闪
    // 但要矫正这较小的频闪很麻烦，而解决Frame带来的频闪问题则要容易很多
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//������Ϸ���ڵĿ�Ⱥ͸߶�

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    // 反复重画窗口
    class PaintThread extends Thread{
        @Override
        public void run() {
            while(true){
                //System.out.println("窗口重画一次！");
                repaint(); // 重画
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    // 增加键盘监听内部类
    class KeyMonitor extends KeyAdapter{
        @Override
        // 覆写键盘按下方法
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        // 覆写键盘松开方法
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }
    }


}