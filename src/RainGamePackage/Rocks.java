package RainGamePackage;

import java.awt.Graphics;
import java.util.Random;

import RainGamePackage.rainGameObject;
import RainGamePackage.RainGamePanel;

public class Rocks extends rainGameObject{
	int speed2;
	Rocks(int x, int y, int width, int height) {
		
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		Random random=new Random();
		speed2=random.nextInt(13)+1;
	}
	void update() {
		y+=speed2;
		super.update();
	}
	void draw(Graphics g) {
		g.drawImage(RainGamePanel.rock, x, y, width, height, null);
	}
	

}
