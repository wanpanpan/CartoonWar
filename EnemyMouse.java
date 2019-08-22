package com.neuedu.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import com.neuedu.action.ActionAble;
import com.neuedu.client.GameClient;
import com.neuedu.util.GetImageUtil;

public class EnemyMouse extends Mouse implements ActionAble {

	private Integer enemyType;
	
	private Integer speed;
	
	private GameClient gc;
	
	

	
	public static Image[] imgs1 = 
		{
				GetImageUtil.getImg("enemy/D1.png"),
				GetImageUtil.getImg("enemy/D2.png"),
				GetImageUtil.getImg("enemy/P.png"),
				GetImageUtil.getImg("enemy/T1.png"),
				GetImageUtil.getImg("enemy/T2.png")
		};
	
	public EnemyMouse() {
		// TODO Auto-generated constructor stub
	}
	public EnemyMouse(int x,int y,int enemyType,GameClient gc,boolean isGood)
	{
		this.x=x;
		this.y=y;
		this.enemyType = enemyType;
		this.speed = 1;
		this.gc = gc;
		this.isGood = isGood;
		this.blood = 900;
	}
	@Override
	public void move() {
		x -= speed;
		
	}
	
	int count = 0;
	@Override
	public void draw(Graphics g) {
		if(count >4)
		{
			count = 0;
		}
		g.drawImage(imgs1[count++], x, y, null);
		move();
		
		if(random.nextInt(500)>490)
		{
			fire();
		}
		
	}
	
	//随机数
	Random random = new Random();
	
	
	//敌军发射子弹
	public void fire()
	{
		Bullet bullet = new Bullet(x+imgs1[0].getWidth(null)-100, y+imgs1[0].getHeight(null)/2-10, "bullet/zidan1.png", gc,false);
		gc.bullets.add(bullet);
	}
	
	
	
	//获取到子弹的矩形
	public Rectangle getRec()
	{
		return new Rectangle(x, y, this.imgs1[0].getWidth(null), this.imgs1[0].getHeight(null));
	}
}
