package www.bittech;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JFrame;

/**
 * 飞机游戏的主窗口
 *
 */
public class MyGameFrame  extends  Frame {

    Image   planeImg  = GameUtil.getImage("images/plane.png");
    Image   bg  = GameUtil.getImage("images/bg.jpg");

    Plane plane = new Plane(planeImg,250,250);
    Shell[] shells = new Shell[30];	//炮弹数组
    Explode bao;	//爆炸对象
    Date startTime = new Date();	//起始时间
    Date endTime;	//结束时间
    int period;		//游戏持续的时间

    @Override
    public void paint(Graphics g) {		//自动被调用。  g相当于一只画笔
        Color c=g.getColor();

        g.drawImage(bg, 0, 0, null);

        plane.drawSelf(g);	//画飞机

        //画50个炮弹
        for (int i = 0; i < shells.length; i++) {
            shells[i].draw(g);

            //飞机和炮弹的碰撞检测
            boolean peng=shells[i].getRect().intersects(plane.getRect());
            if(peng){
                plane.live=false;	//如果相撞了，飞机就死了

                //爆炸
                if(bao==null){
                    bao = new Explode(plane.x,plane.y);	//在飞机碰撞坐标爆炸
                    endTime=new Date();	//飞机爆炸时为结束时间
                    period=(int)((endTime.getTime()-startTime.getTime())/1000);	//游戏持续时间计算
                }

                bao.draw(g);	//画出爆炸
            }
            //计时功能,如果飞机死了，显示时间提示
            if(!plane.live){
                g.setColor(Color.PINK);   	//提示时间的字体颜色设为红色
                Font f = new Font("宋体",Font.BOLD,30);	//设置字体
                g.setFont(f);
                g.drawString("时间："+period+"秒", (int)150,350);
            }
        }

        g.setColor(c);	//初始化画笔的颜色
    }


    //帮助我们反复的重画窗口！
    class  PaintThread  extends  Thread  {
        @Override
        public void run() {
            while(true){
                repaint();		//重画

                try {
                    Thread.sleep(40);   	//1s=1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //定义键盘监听的内部类
    class KeyMonitor extends KeyAdapter{

        //按下一个键
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        //抬起一个键
        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }
    }


    /**
     * 初始化窗口
     */
    public  void  launchFrame() throws InterruptedException {
        System.out.println("欢迎进入飞机躲炸弹游戏");
        System.out.println("游戏将在三秒后开始");
        Thread.sleep(3000);
        this.setTitle("made by Kong Wang");
        this.setVisible(true);
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        this.setLocation(300, 150);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().start();	//启动重画窗口的线程
        addKeyListener(new KeyMonitor());	//给窗口增加键盘的监听

        //初始化50个炮弹
        for (int i = 0; i < shells.length; i++) {
            shells[i]=new Shell();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyGameFrame  f = new MyGameFrame();
        f.launchFrame();
    }


    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

}