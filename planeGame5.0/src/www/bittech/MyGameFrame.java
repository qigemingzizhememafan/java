package www.bittech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 初始化游戏窗口
public class MyGameFrame extends JFrame {
    Image planeImg = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");
    Plane plane = new Plane(planeImg,250,250);

    // 在窗口内画东西
    public void paint(Graphics g){  //该方法会自动被调用，g相当于一支画笔
        g.drawImage(bg,0,0,null);
        plane.drawSelf(g);
    }

    // 初始化界面
    public void launchFrame(){
        //设置标题
        this.setTitle("hit plane game by lzl");
        //窗口默认不可见，将其改为可见
        this.setVisible(true);
        // 设置窗口大小
        this.setSize(500,500);
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
    }



    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
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
            System.out.println("按下"+e.getKeyCode());
        }

        @Override
        // 覆写键盘松开方法
        public void keyReleased(KeyEvent e) {
            System.out.println(("松开"+e.getKeyCode()));
        }
    }
}