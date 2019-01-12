package RainGamePackage;


import java.awt.Graphics;
import java.util.Random;

import RainGamePackage.rainGameObject;
import RainGamePackage.RainGamePanel;

public class Rain extends rainGameObject{
	int speed1;
	
	
	Rain(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		Random random=new Random();
		speed1=random.nextInt(10)+1;	
		
	}
	void update() {
		y+=speed1;
		super.update();
	}
	void draw(Graphics g) {
		g.drawImage(RainGamePanel.raindrop, x, y, width, height, null);
		
	}
	

}
