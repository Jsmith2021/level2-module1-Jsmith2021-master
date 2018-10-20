package intro_to_array_lists;
import java.awt.Graphics;

public class ObjectManager {
	RocketShip object;
	
	ObjectManager(RocketShip object){
		object=new RocketShip(250, 700, 50, 50);
		
	}
	void update() {
		object.update();
	}
	void draw(Graphics g) {
		object.draw(g);
	}
		void GameObject() {
	}
		
	
    
}
