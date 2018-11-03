package intro_to_array_lists;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
    int y;
    int width;
    int height;
    boolean isAlive=true;
    Rectangle collisionBox;
    
    
    
    GameObject(int x, int y, int width, int height){
    	this.x=x;
    	this.y=y;
    	this.width=width;
    	this.height=height;
    	collisionBox=new Rectangle(5,10,100,200);
    }
    void update() {
  
    }
    void draw(Graphics g) {
   
    }
    

}

