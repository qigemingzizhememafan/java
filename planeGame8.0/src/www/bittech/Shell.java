package www.bittech;

import java.awt.Color;
import java.awt.Graphics;


import java.awt.Color;
import java.awt.Graphics;

/*
 * 炮弹类
 */
public class Shell extends GameObject {
	double degree;	//弧度

	public Shell(){
		x=200;	//炮弹位置x
		y=200;	//炮弹位置y
		width=10;	//炮弹宽度
		height=10;	//炮弹高度
		speed=3;	//炮弹速度

		degree = Math.random()*Math.PI*2;
	}

	public void draw(Graphics g){
		Color c = g.getColor();		//保存初始画笔颜色
		g.setColor(Color.YELLOW);	//填充颜色

		g.fillOval((int)x, (int)y, width, height);	//填充炮弹

		//炮弹沿着任意角度飞
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);

		//碰到边界反弹
		if(x<0||x>Constant.GAME_WIDTH-width){
			degree=Math.PI-degree;
		}

		if(y<30||y>Constant.GAME_HEIGHT-height){
			degree=-degree;
		}

		g.setColor(c);	//用完画笔变为初始值
	}
}
