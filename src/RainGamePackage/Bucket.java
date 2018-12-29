package RainGamePackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
public class Bucket extends rainGameObject {
	int speed;
	
	Bucket(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
		// TODO Auto-generated constructor stub
	}
void update() {
	
	super.update();	
	
}
void draw(Graphics g) {
	g.drawImage(RainGamePanel.woodenbucket, x, y, 100, 110, null);
    
}
	
	}



