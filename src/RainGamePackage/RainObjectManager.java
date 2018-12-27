package RainGamePackage;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


		public class RainObjectManager {
			Bucket object;
			long enemyTimer;
			int enemySpawnTime;
			ArrayList<Rain> raindrops = new ArrayList<Rain>();
			ArrayList<Rocks> pebbles = new ArrayList<Rocks>();
			int score;

			

			RainObjectManager(Bucket object) {
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

				for (int i = 0; i < raindrops.size(); i++) {
					raindrops.get(i).update();
				}
				for (int i = 0; i < pebbles.size(); i++) {
					pebbles.get(i).update();
				}
			}

			void draw(Graphics g) {
				object.draw(g);
				for (int i = 0; i < raindrops.size(); i++) {
					raindrops.get(i).draw(g);
				}
				for (int i = 0; i < pebbles.size(); i++) {
					pebbles.get(i).draw(g);
				}
			}

			void rainGameObject() {
			}

			void addRain(Rain r) {
				raindrops.add(r);

			}

			void addRocks(Rocks p) {
				pebbles.add(p);
			}
			

			public void manageEnemies() {
				if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
					addRocks(new Rocks(new Random().nextInt(RainCatcher.WIDTH), 0, 50, 50));
					addRain(new Rain(new Random().nextInt(RainCatcher.WIDTH), 0, 50, 50));
					enemyTimer = System.currentTimeMillis();
				}

			}

			void purgeObjects() {
				for (int i = 0; i < pebbles.size(); i++) {
					if (pebbles.get(i).isAlive == false) {
						pebbles.remove(i);
						score++; 
					}
				}

				for (int i = 0; i < raindrops.size(); i++) {
					if (raindrops.get(i).isAlive == false) {
						raindrops.remove(i);

					}
				}
			
				
			}

			void checkCollision() {

				for (Bucket bucket) {
					for (Rain r : raindrops) {
						if (r.collisionBox.intersects(bucket.collisionBox)) {
							r.isAlive = false;
							
						}

					}
				}
				for(Rocks p : pebbles) {
						if(p.collisionBox.intersects(bucket.collisionBox)) {
							p.isAlive=false;
							object.isAlive=false;
						}
					}
				}
			


	}

