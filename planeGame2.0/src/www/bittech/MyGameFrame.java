package www.bittech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 初始化游戏窗口
public class MyGameFrame extends JFrame {
    Image plane = GameUtil.getImage("images/plane.png");

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
    }

    // 在窗口内画东西
    public void paint(Graphics g){  //该方法会自动被调用，g相当于一支画笔

        Color c = g.getColor(); //取得当前颜色
        g.setColor(Color.BLUE); // 修改颜色

        Font f = g.getFont(); // 取得当前字体

        g.drawLine(100,100,300,300); // 画直线，x1为起点坐标，x2为终点坐标
        g.drawRect(100,100,300,300);// 画矩形，起点坐标，长，宽
        g.drawOval(100,100,300,300);// 画椭圆，在其外切矩形内画圆
        g.fillRect(100,100,40,40); //填充矩形
        g.setColor(Color.PINK);
        g.setFont(new Font("宋体",Font.BOLD,50)); // 宋体加粗50号字
        g.drawString("王港是猪",200,200);   // 画字符串

        g.setColor(c); // 将颜色改回为原有颜色
        g.setFont(f);  //  改回原有字体

        g.drawImage(plane,200,200,null); // 最后一个参数为观察者，一般写为空
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}