package intro_to_array_lists;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
public class RocketShip extends GameObject {
	int speed;
	
	RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
		// TODO Auto-generated constructor stub
	}
void update() {
	
	super.update();	
	
}
void draw(Graphics g) {
	g.setColor(Color.BLUE);
    g.fillRect(x, y, width, height);
    
}
	
	}

