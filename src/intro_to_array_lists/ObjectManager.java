package intro_to_array_lists;
import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	RocketShip object;
	
	ArrayList<ObjectManager> projectiles = new ArrayList<ObjectManager>();
	 
	
	ObjectManager(RocketShip object){
		this.object=object;
		
	}
	void update() {
		object.update();
		projectiles.iterator();
	}
	void draw(Graphics g) {
		object.draw(g);
		projectiles.draw(g);
	}
		void GameObject() {
	}
		void addProjectile(){
			projectiles.add(this);
			
		}
		
	
    
}
