package intro_to_array_lists;

import java.awt.Graphics;

public class GameObject {
	int x;
    int y;
    int width;
    int height;
    
    GameObject(int x, int y, int width, int height){
    	
    }
    void update() {
  x++;
  y++;
    }
    void draw(Graphics a) {
    	a.fillRect(x, y, 100, 100);
    }

}

