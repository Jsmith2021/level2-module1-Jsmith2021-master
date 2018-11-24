package intro_to_array_lists;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
		y++;
		super.update();
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
	

}

