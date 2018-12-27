package RainGamePackage;

import java.awt.Graphics;

import RainGamePackage.rainGameObject;
import RainGamePackage.RainGamePanel;

public class Rocks extends rainGameObject{
	
	Rocks(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
		y++;
		super.update();
	}
	void draw(Graphics g) {
		g.drawImage(RainGamePanel.rock, x, y, width, height, null);
	}
	

}
