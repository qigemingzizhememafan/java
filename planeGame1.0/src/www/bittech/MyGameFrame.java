package www.bittech;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 初始化游戏窗口
public class MyGameFrame extends JFrame {
    // 初始化界面
    public void launchFrame(){
        this.setTitle("hit plane game by lzl"); //设置标题
        this.setVisible(true);   //窗口默认不可见，将其改为可见
        this.setSize(500,500); // 设置窗口大小
        this.addWindowStateListener(new WindowAdapter() { //真正关闭游戏窗口
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); //结束虚拟机运行，0表示正常结束
            }
        });
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
