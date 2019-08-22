package com.neuedu.entity;

import java.awt.Graphics;
import java.awt.Image;

import com.neuedu.action.ActionAble;
import com.neuedu.client.GameClient;
import com.neuedu.util.GetImageUtil;

/**
* @ClassName: Boom
* @Description: TODO(爆炸类)
* @author Wpp
* @date 2019年8月20日 上午10:16:12
*
*/
public class Boom extends GameObj implements ActionAble {
	
	private boolean isLive;
	private GameClient gc;
	
	
	
	
	
	


	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	// 动态初始化爆炸图
	private static Image[] boomImgs = new Image[5];
	static 
	{
		for(int i=0;i<5;i++) 
		{
			boomImgs[i] = GetImageUtil.getImg("Boom/"+(i+1)+".png");
	    }
	}
		

	public Boom() {
		// TODO Auto-generated constructor stub
	}
	public Boom(int x,int y,GameClient gc)
	{
		this.x=x;
		this.y=y;
		this.isLive = true;
		this.gc=gc;
	}
	@Override
	public void move() {
		
	}

	int count= 0;
	@Override
	public void draw(Graphics g) {
		if(isLive)
		{
		    if(count > 4)
		    {
				gc.booms.remove(this);
				this.setLive(false);
			    return;	
		    }
		    g.drawImage(boomImgs[count++], x+10, y-80, null);
	    }
	}

}
