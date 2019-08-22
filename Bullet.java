package com.neuedu.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import com.neuedu.action.ActionAble;
import com.neuedu.client.GameClient;
import com.neuedu.constant.Constant;
import com.neuedu.util.GetImageUtil;
import com.neuedu.util.SinglePlay;

/**
* @ClassName: Bullet
* @Description: TODO(�ӵ���)
* @author Wpp
* @date 2019��8��19�� ����1:59:14
*
*/
public class Bullet extends GameObj implements ActionAble{
	
	//���β������ֵĶ���
	SinglePlay singlePlay = new SinglePlay();
	
	// �����ٶ�����
	private Integer speed;
	
	
	//�õ��ͻ���	
	private GameClient gc;
	
	// �ӵ�����
	public boolean isGood;
	
	
	public Bullet() {
		
	}
	public Bullet(int x,int y,String imgName,GameClient gc,boolean isGood)
	{
		this.x = x;
		this.y = y;
		this.img = GetImageUtil.getImg(imgName);
		this.speed = 10;
		this.gc = gc;
		this.isGood = isGood;
	}
	@Override
	public void move() {
		if(isGood)
		{
			x += speed;
		}else
		{
			x -= speed;
		}
				
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		move();
		outOfBounds();
	}
	
	// �ӵ�Խ������
	public void outOfBounds()
	{
		if(x>Constant.GAME_WIDTH||x<0)
		{
			gc.bullets.remove(this);
		}
	}
	
	//������ɵ���
	Random random = new Random();
	
	// �ӵ���һ������
	public boolean hitMonster(Mouse mouse)
	{
		Boom boom = new Boom(mouse.x,mouse.y,gc); 
		if(this.getRec().intersects(mouse.getRec())&&this.isGood!=mouse.isGood)
		{
			if(mouse.isGood)
			{
				singlePlay.play("com/neuedu/sound/pa.mp3");
				mouse.blood -= 10;
				if(mouse.blood == 0)
				{
					// ��������
					gc.mouses.remove(mouse);	
				}	
				// �Ƴ��ӵ�
			    gc.bullets.remove(this);
			}else
			{
				singlePlay.play("com/neuedu/sound/�Ե���.mp3");
				if(mouse instanceof Boss)
				{
					mouse.blood -= 100;
					if(mouse.blood<=0)
					{
						gc.bosss.remove(mouse);
						// �Ƴ��ӵ�
					    gc.bullets.remove(this);
					    
					}		
				}
				else
				{
					// �Ƴ����е���
					gc.enemys.remove(mouse);
					// �Ƴ��ӵ�
				    gc.bullets.remove(this);	
				    // �������һ�����߳���
				    if(random.nextInt(500)>200)
				    {
				    	if(mouse instanceof EnemyMouse)
				    	{
				    	    EnemyMouse enemyMouse = (EnemyMouse)mouse;
				    	    Prop prop = new Prop(mouse.x, mouse.y, "prop/1.png");
						    gc.props.add(prop);
				    	}
				    }
				}
			}
			// ��ӱ�ը
			gc.booms.add(boom);
			return true;
		}
		return false;
	}
	// �ӵ���������
	public boolean hitMonsters(ArrayList<Mouse> monsters)
	{
		if(monsters==null)
		{
			return false;
		}
		for(int i=0;i<monsters.size();i++)
		{
			if(hitMonster(monsters.get(i)))
			{
				return true;
			}
		}
		return false;

	}
	
	//��ȡ���ӵ��ľ���
	public Rectangle getRec()
	{
		return new Rectangle(x, y, this.img.getWidth(null), this.img.getHeight(null));
	}
	
}
