package intro_to_array_lists;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip object;
	long enemyTimer;
	int enemySpawnTime;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> alien = new ArrayList<Alien>();

	ObjectManager(RocketShip object) {
		this.object = object;
enemyTimer=0;
enemySpawnTime=2000;
	}

	void update() {
		object.update();
		
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < alien.size(); i++) {
			alien.get(i).update();
		}
	}

	void draw(Graphics g) {
		object.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < alien.size(); i++) {
			alien.get(i).draw(g);
		}
	}

	void GameObject() {
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);

	}
	void addAlien(Alien a) {
		alien.add(a);
	}
	public void manageEnemies() {
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
    }

	}
	void purgeObjects() {
	//part 11 step 10	
	}
	void checkCollision() {
		for(Alien a : alien){

	        if(object.collisionBox.intersects(a.collisionBox)){

	                object.isAlive = false;

	        }

//part 12 step 8
	}
		

	}
}
