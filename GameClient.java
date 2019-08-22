package com.neuedu.client;

import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.neuedu.constant.Constant;
import com.neuedu.entity.BackGround;
import com.neuedu.entity.Boom;
import com.neuedu.entity.Boss;
import com.neuedu.entity.Bullet;
import com.neuedu.entity.EnemyMouse;
import com.neuedu.entity.Mouse;
import com.neuedu.entity.Prop;
import com.neuedu.util.SoundPlayer;


/**
* @ClassName: GameClient
* @Description: TODO(��Ϸ�ͻ���)
* @author Pa
* @date 2019��8��17�� ����4:21:10
*
*/
public class GameClient extends Frame {
	
	
	// ����һ��mouse����
	//Mouse mouse = new Mouse(100,200,"plane/10.png",this,true);
	
	// ����һ���ҷ���ɫ�ļ���
	public ArrayList<Mouse> mouses = new ArrayList<Mouse>();
	
	// �������߼���
	public ArrayList<Prop> props =new ArrayList<>();
	
	// ����һ���ӵ�����
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>(); 
	
	// ����һ������ͼ����
	BackGround backImg = new BackGround(0,0,"plane/timg.png");

	// ����һ����ը�ļ���
	public ArrayList<Boom> booms = new ArrayList<>();

	// �����з�����
	public ArrayList<Mouse> enemys = new ArrayList<>();
	
	// ����һ��Boss����
	public ArrayList<Mouse> bosss = new ArrayList<>();
	
	//���ͼƬ��˸������
	@Override
	public void update(Graphics g) {
		Image backImg = createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		Graphics backg = backImg.getGraphics();
		Color color = backg.getColor();
		backg.setColor(color.WHITE);
		backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		backg.setColor(color);
		paint(backg);
		g.drawImage(backImg, 0, 0,null);
		
	}
	Mouse mouse = null;
	// ���ɿͻ��˴��ڵķ���
	public void launchFrame() {
		SoundPlayer soundPlayer = new SoundPlayer("com/neuedu/sound/beijingyinyue.mp3");
		soundPlayer.start();
		// ���ô��ڴ�С
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		// ���ñ���
		this.setTitle("�ڹ����ս");
		// �����Ƿ��ܹ���ʾ
		this.setVisible(true);
		// ��ֹ���
		this.setResizable(false);
		//���ھ���
		this.setLocationRelativeTo(null);
		//�رմ���  ��ӹرռ�����
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		mouse = new Mouse(100,200,"plane/10.png",this,true);
		// ���ҷ���������Լ�
		mouses.add(mouse);
		
		// ���������
		//this.addMouseListener(new MouseAdapter() {
		//	@Override
		//	public void mouseClicked(MouseEvent e) {
		//		System.out.println("�����һ�����");
		//	}
		//});
		// ��Ӽ��̼���
		this.addKeyListener(new KeyAdapter() {
			// ���̰��µ����
			@Override
			public void keyPressed(KeyEvent e) {
				mouse.keyPressed(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				mouse.keyReleased(e);
			}
		});
	
		// �����߳�
		new paintThread().start();
		
		
		
		// ���з���������ӵ���
		EnemyMouse enemy1 = new EnemyMouse(900,50,1,this,false);
		EnemyMouse enemy2 = new EnemyMouse(900,200,1,this,false);
		EnemyMouse enemy3 = new EnemyMouse(800,50,1,this,false);
		EnemyMouse enemy4 = new EnemyMouse(700,300,1,this,false);
		EnemyMouse enemy5 = new EnemyMouse(700,600,1,this,false);
		EnemyMouse enemy6 = new EnemyMouse(800,500,1,this,false);
		EnemyMouse enemy7 = new EnemyMouse(900,450,1,this,false);
		EnemyMouse enemy8 = new EnemyMouse(500,300,1,this,false);
		enemys.add(enemy1);
		enemys.add(enemy2);
		enemys.add(enemy3);
		enemys.add(enemy4);
		enemys.add(enemy5);
		enemys.add(enemy6);
		enemys.add(enemy7);
		enemys.add(enemy8);
		//���boss
		bosss.add(new Boss(1200, 300, this,false));
		
		// ����paint����
		new paintThread().start();

	}
	
	//��дpaint����
	@Override
	public void paint(Graphics g) {
		backImg.draw(g);
		g.drawLine(1200, 0, 1200, 0);
		for(int i=0;i<mouses.size();i++)
		{
			Mouse mouse2 = mouses.get(i);
			mouse2.draw(g);
			mouse2.containItems(props);
			
		}
	    // ��ǿѭ������ÿ���ӵ�
		// ��ǿforѭ���������κβ���
		for(int i=0;i<bullets.size();i++)
		{
			Bullet bullet = bullets.get(i);
			bullet.draw(g);
			bullet.hitMonsters(enemys);
			bullet.hitMonsters(mouses);
			bullet.hitMonsters(bosss);
		}
		g.drawString("��ǰ�ӵ���������"+bullets.size(), 10, 40);
        g.drawString("��ǰ�л���������"+enemys.size(),10, 70);
        g.drawString("��ǰ��ը��������"+booms.size(),10, 100);
        g.drawString("��ǰ�ҷ���������"+mouses.size(),10, 130);
        g.drawString("��ǰ���ߵ�������"+props.size(),10, 160);
		// ѭ�����з�
		for(int i=0;i<enemys.size();i++)
		{
			enemys.get(i).draw(g);
		}
		// ѭ��������
		for(int i=0;i<booms.size();i++)
		{
			if(booms.get(i).isLive()==true)
			{
				booms.get(i).draw(g);
			}
		}
		// ѭ��������
		for(int i=0;i<props.size();i++)
		{
			props.get(i).draw(g);
		}
		if(enemys.size()==0)
		{
			//ѭ��boss����
			for(int i=0;i<bosss.size();i++)
			{
				bosss.get(i).draw(g);
			}
		}
		
	}
	
	//�ڲ���
	class paintThread extends Thread
	{
		@Override
		public void run() {
			while(true) 
			{
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
	

	
	
	
	