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
	int score;

	

	ObjectManager(RocketShip object) {
		this.object = object;
		enemyTimer = 0;
		enemySpawnTime = 2000;
		score=0;
	}
public int getScore() {
	return this.score;
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
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}

	}

	void purgeObjects() {
		for (int i = 0; i < alien.size(); i++) {
			if (alien.get(i).isAlive == false) {
				alien.remove(i);
				score++; 
			}
		}

		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isAlive == false) {
				projectiles.remove(i);

			}
		}
	
		
	}

	void checkCollision() {

		for (Alien a : alien) {
			for (Projectile p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					p.isAlive = false;
					a.isAlive = false;
				}

			}
		}
		for(Alien a : alien) {
				if(a.collisionBox.intersects(object.collisionBox)) {
					a.isAlive=false;
					object.isAlive=false;
				}
			}
		}
	}

