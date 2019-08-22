package com.neuedu.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import com.neuedu.action.ActionAble;
import com.neuedu.client.GameClient;
import com.neuedu.constant.Constant;
import com.neuedu.util.GetImageUtil;

public class Boss extends Mouse implements ActionAble {
	
	private boolean up = true;
	
	
	
	private int speed = 4;
	public Boss() {
		// TODO Auto-generated constructor stub
	}
	public Boss(int x,int y,GameClient gc,boolean isGood)
	{
		this.x = x;
		this.y = y;
		this.gc = gc;
		this.isGood = isGood;
		this.blood = 100000;
	}

	// 动态初始化定义一个图片数组
	private static Image[] imgs = new Image[5];
	static
	{
		for(int i =0;i<imgs.length;i++)
		{
			imgs[i] = GetImageUtil.getImg("boss/0"+(i+1)+".png");
		}
	}
	
	int count = 0;
	@Override
	public void draw(Graphics g) {
		if(count > 4)
		{
			count = 0;
		}
		g.drawImage(imgs[count++], x, y, null);
		move();
		g.drawString("当前血量："+blood, x, y);
	}
	
	@Override
	public void move() {
		x -= speed;
		
		if(x < 800)
		{
			x = 800;
			if(up)
			{
				y -= speed;
			}
			if(!up)
			{
				y += speed;
			}
			if(y>Constant.GAME_HEIGHT-imgs[0].getHeight(null))
			{
				up = true;
			}
			if(y<30)
			{
				up = false;
			}
		}
		
		
		x -= speed;
		
		if(random.nextInt(500)>450)
		{
			fire();
		}
		
	}
	// 生成随机数
	Random random = new Random();
	
	// 获取boss所在的矩形
	public Rectangle getRec()
	{
		return new Rectangle(x, y,imgs[0].getWidth(null), imgs[0].getHeight(null));
	}
	
	
	@Override
	public void fire() {
		play.play("com/neuedu/sound/发射.mp3");
		Bullet b = new Bullet(x+imgs[0].getWidth(null)/2, y+imgs[0].getHeight(null)/2-30, "bullet/zidan9.png", gc,false);
		gc.bullets.add(b);
		
	}
	
	
}
