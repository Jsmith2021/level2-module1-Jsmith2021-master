package intro_to_array_lists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics; 
//PART 14 STEP 1
public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState= MENU_STATE;
	Font titleFont;
	Font gameFont;
	Font gameInstructions;
	Font gameOver;
	Font restart;
	RocketShip rocket;
	ObjectManager object;
	 public static BufferedImage alienImg;
     public static BufferedImage rocketImg;
     public static BufferedImage bulletImg;
     public static BufferedImage spaceImg;
	
	//GameObject object;
	
	GamePanel(){
		//object = new GameObject(30, 50, 10, 60);
		timer=new Timer(1000/60,this);
		titleFont=new Font("Arial", Font.BOLD, 48);
		gameFont=new Font("Arial", Font.PLAIN, 24);
		gameInstructions=new Font("Arial", Font.PLAIN, 24);
		gameOver=new Font("Arial", Font.BOLD, 48);
		restart=new Font ("Arial", Font.PLAIN, 24);
		rocket=new RocketShip(250, 700, 50, 50);
		object=new ObjectManager(rocket);
		 try {

             alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

             rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

             bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

             spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

     } catch (IOException e) {

             // TODO Auto-generated catch block

             e.printStackTrace();

     }
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		object.update();
		object.manageEnemies();
		object.checkCollision();
		object.purgeObjects();
		if(rocket.isAlive==false) {
			currentState=END_STATE;
		}

				
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);   
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 30, 150);
		g.setFont(gameFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 110, 350);
		g.setFont(gameInstructions);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions",70, 500);
		g.setFont(gameOver);
		
		
		
	}
	void drawGameState(Graphics g) {
		g.drawImage(spaceImg, 0,0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null); 
		//rocket.draw(g);
		object.draw(g);
	
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
		g.setFont(gameOver);
		g.setColor(Color.BLACK);
		g.drawString("Game Over",100, 350);
		g.setFont(restart);
		g.drawString("You killed 0 enemies", 125, 450);
		g.drawString("Press ENTER to restart", 110, 550);
	}
	 @Override

	 public void paintComponent(Graphics g){
		 //g.fillRect(10, 10, 100, 100);
		// object.draw(g);
		 if(currentState == MENU_STATE){
			 drawMenuState(g); 

     }
		 else if(currentState == GAME_STATE){
			 drawGameState(g);
     }
		 else if(currentState == END_STATE){
			 drawEndState(g);

     }


	         }
	public void startGame() {
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//object.update();
		 if(currentState == MENU_STATE){
             updateMenuState();
     }
		 else if(currentState == GAME_STATE){
             updateGameState();
     }
		 else if(currentState == END_STATE){
             updateEndState();

     }


		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("message");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			currentState++;
			
			if (currentState > END_STATE){
            currentState = MENU_STATE;
		
            if(currentState==END_STATE) {
            	rocket=new RocketShip(250, 700, 50, 50) ;
            	object= new ObjectManager(rocket);
            
            
           
		}
		}
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			rocket.y+=2;	
			
			
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			rocket.y-=2;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
	rocket.x+=2;
}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
	rocket.x-=2;
}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			object.addProjectile(new Projectile(rocket.x+20, rocket.y, 10, 10));
			System.out.println("Projectile shot");
		}
    }
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hola");
		
	}	
}
