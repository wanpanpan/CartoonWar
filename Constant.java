package com.neuedu.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
* @ClassName: Constant
* @Description: TODO(������)
* @author Wpp
* @date 2019��8��17�� ����4:45:59
*
*/
public class Constant {
	
	//��ζ�ȡ�����ļ�
	public static Properties prop = new Properties();
	static Integer Game_Width = null;
	static Integer Game_Height = null;
	static {
		
		InputStream inStream = Constant.class.getResourceAsStream("/gameConfiguration.properties");
		try {
			prop.load(inStream);
			Game_Width = Integer.parseInt(prop.getProperty("Game_Width"));
			Game_Height = Integer.parseInt(prop.getProperty("Game_Height"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//������
	public static final int GAME_WIDTH = Game_Width;
	//����߶�
	public static final int GAME_HEIGHT = Game_Height;
	
	
	public static void main(String[] args) {
		System.out.println(Constant.Game_Height);
	}

}
