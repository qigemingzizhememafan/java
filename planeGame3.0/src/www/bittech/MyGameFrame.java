package www.bittech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 初始化游戏窗口
public class MyGameFrame extends JFrame {
    Image plane = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");
    int x = 250,y = 250;

    // 在窗口内画东西
    public void paint(Graphics g){  //该方法会自动被调用，g相当于一支画笔
        g.drawImage(bg,0,0,null);
        g.drawImage(plane,x,y,null); // 最后一个参数为观察者，一般写为空
        x++;
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
        new PaintThread().start();
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
                System.out.println("窗口重画一次！");
                repaint(); // 重画
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}