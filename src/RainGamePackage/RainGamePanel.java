package RainGamePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import intro_to_array_lists.LeagueInvaders;
import intro_to_array_lists.ObjectManager;
import intro_to_array_lists.Projectile;
import intro_to_array_lists.RocketShip;

public class RainGamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE=1;
	final int INSTRUCTIONS_STATE = -1;
	final int END_STATE = 2;
	int currentState= MENU_STATE;
	Font menuFont;
	Font startFont;
	Font instructionsFont;
	Font endFont;
	Font endFont2;
	Font restart;
	Timer rainTimer;
	Font instructions;
	Font instructions1;
	Font instructionsTitle;
	Font scoreFont;
	  public static BufferedImage rain;
	  public static BufferedImage rainpics;
	  public static BufferedImage sunny;
	  public static BufferedImage raindrop;
	  public static BufferedImage woodenbucket;
	  public static BufferedImage rock;
	  rainGameObject object;
	  Bucket bucket;
	  RainObjectManager manager;
	
RainGamePanel(){
	rainTimer=new Timer(1000/60,this);
	menuFont=new Font("Arial", Font.BOLD, 48);
	startFont=new Font("Arial", Font.PLAIN, 24);
	instructionsFont=new Font("Arial", Font.PLAIN, 24);
	instructions=new Font("Arial", Font.PLAIN, 24);
	instructions1=new Font("Arial", Font.PLAIN, 24);
	endFont=new Font("Arial", Font.PLAIN, 48);
	endFont2=new Font("Arial", Font.PLAIN, 24);
	restart=new Font("Arial", Font.PLAIN, 24);
	instructionsTitle=new Font("Arial", Font.BOLD, 36);
	scoreFont=new Font("Arial", Font.BOLD, 36);
	object=new rainGameObject(10, 10, 100, 100);
	bucket=new Bucket(250, 675, 125, 125);
	manager=new RainObjectManager(bucket);
	 try {
         rain = ImageIO.read(this.getClass().getResourceAsStream("rainclouds.png"));
         rainpics = ImageIO.read(this.getClass().getResourceAsStream("Rain-Clouds.jpg"));
         sunny = ImageIO.read(this.getClass().getResourceAsStream("sunnyday.jpg"));
         raindrop = ImageIO.read(this.getClass().getResourceAsStream("raindropimage.png"));
         woodenbucket = ImageIO.read(this.getClass().getResourceAsStream("woodenbucket.png"));
         rock = ImageIO.read(this.getClass().getResourceAsStream("rockpic.png")); 

 } catch (IOException e) {

         // TODO Auto-generated catch block

         e.printStackTrace();
 }
	 
}

void updateMenuState() {
	
}
void updateInstructionsState() {
	
}
void updateGameState() {	
	bucket.update();
	manager.update();
	manager.manageEnemies();
	manager.checkCollision();
	manager.purgeObjects();
	manager.getScore();
	
	if(bucket.isAlive==false) {
		currentState=END_STATE;
	}
}
			
void updateEndState() {
	manager.getScore();
}

void drawGameState(Graphics g) {
	g.drawImage(rainpics, 0,0, RainCatcher.WIDTH, RainCatcher.HEIGHT, null);
	g.setFont(scoreFont);
	g.setColor(Color.BLACK);
	g.drawString("Score: "+manager.score, 325, 40);
		manager.draw(g);
}

void drawEndState(Graphics g) {
	g.drawImage(sunny, 0,0, RainCatcher.WIDTH, RainCatcher.HEIGHT, null);
	g.setFont(endFont);
	g.setColor(Color.WHITE);
	g.drawString("Game Over!", 120, 150);
	g.setFont(endFont2);
	g.setColor(Color.WHITE);
	g.drawString("You only caught " +manager.score+ " inches of water", 85, 300);
	g.setFont(restart);
	g.setColor(Color.WHITE);
	g.drawString("Press ENTER to try again", 110, 500);
	
}

void drawMenuState(Graphics g) {
g.drawImage(rain, 0,0, RainCatcher.WIDTH, RainCatcher.HEIGHT, null);
g.setFont(menuFont);
g.setColor(Color.GRAY);
g.drawString("Rain Catcher", 85, 150);
g.setFont(startFont);
g.setColor(Color.GRAY);
g.drawString("Press ENTER to Begin", 110, 300);
g.setFont(instructionsFont);
g.setColor(Color.GRAY);
g.drawString("Press SPACE for Instructions",83 ,450);
}

void drawInstructionsState(Graphics g) {
g.drawImage(rainpics, 0,0, RainCatcher.WIDTH, RainCatcher.HEIGHT, null);
g.setFont(instructionsTitle);
g.setColor(Color.WHITE);
g.drawString("Rain Catcher Instructions", 25, 150);
g.setFont(instructions);
g.drawString("Try to catch as much rain", 110, 250);
g.drawString("as you can by moving the bucket", 80, 325);
g.drawString("without catching any rocks.", 100, 400);
g.setFont(instructions1);
g.drawString("Try to beat your previous score!", 90, 525);
g.drawString("Good luck and have fun!", 130, 625);
}

@Override
public void paintComponent(Graphics g){
	
	 if(currentState == MENU_STATE){
		 drawMenuState(g); 
}
	 
	 else if(currentState== INSTRUCTIONS_STATE) {
		 drawInstructionsState(g);
	 }
	 else if(currentState == GAME_STATE){
		 drawGameState(g);
}
	 else if(currentState == END_STATE){
		 drawEndState(g);

}
	object.draw(g);
	
}

public void start() {
	rainTimer.start();
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(currentState == MENU_STATE){
        updateMenuState();
}
	else if(currentState == INSTRUCTIONS_STATE) {
		updateInstructionsState();
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
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		currentState++;
	}
		
		if (currentState > END_STATE){
			bucket=new Bucket(250, 700, 100, 100);
	    	manager= new RainObjectManager(bucket);
        currentState = MENU_STATE;
		}	

if(e.getKeyCode()==KeyEvent.VK_SPACE) {
	
	if(currentState==MENU_STATE) {
		currentState = INSTRUCTIONS_STATE;
	}
	else if(currentState==INSTRUCTIONS_STATE){
		currentState = MENU_STATE;
	}
}


if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
bucket.x+=8;
}
if(e.getKeyCode()==KeyEvent.VK_LEFT) {
bucket.x-=8;
}
}

        

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


}

