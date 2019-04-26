package www.bittech;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

// 辅助工具类---完成图片加载功能
public class GameUtil {

    // 构造器访问私有
    private GameUtil(){
    }
    // 返回指定路径文件的图片
    public static Image getImage(String path) {
        BufferedImage bi = null;
        URL u = GameUtil.class.getClassLoader().getResource(path);
        try {
            bi = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}
