package RainGamePackage;

import java.awt.Color;
import java.awt.Graphics;

import RainGamePackage.rainGameObject;
import RainGamePackage.RainGamePanel;

public class Rain extends rainGameObject{
	
	Rain(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
		y++;
		super.update();
	}
	void draw(Graphics g) {
		//g.drawImage(RainGamePanel.raindrop, x, y, width, height, null);
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 50, 50);
		System.out.println(x+""+y+""+width+""+height);
	}
	

}
