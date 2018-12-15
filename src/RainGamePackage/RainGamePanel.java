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

public class RainGamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE=1;
	final int INSTRUCTIONS_STATE = 2;
	final int END_STATE = 3;
	int currentState= MENU_STATE;
	Font menuFont;
	Font startFont;
	Font instructionsFont;
	Font endFont;
	Font endFont2;
	Font restart;
	int score;
	Timer rainTimer;
	Font instructions;
	Font instructions1;
	  public static BufferedImage rain;
	  public static BufferedImage rainpics;
	  public static BufferedImage sunny;
	
RainGamePanel(){
	rainTimer=new Timer(1000/60,this);
	menuFont=new Font("Arial", Font.BOLD, 48);
	startFont=new Font("Arial", Font.PLAIN, 24);
	instructionsFont=new Font("Arial", Font.PLAIN, 24);
	endFont=new Font("Arial", Font.BOLD, 48);
	endFont2=new Font("Arial", Font.PLAIN, 24);
	restart=new Font("Arial", Font.PLAIN, 24);
	 try {
         rain = ImageIO.read(this.getClass().getResourceAsStream("rainpic.jpg"));
         rainpics = ImageIO.read(this.getClass().getResourceAsStream("rain.jpg"));
         sunny = ImageIO.read(this.getClass().getResourceAsStream("sunnyday.jpg"));

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
	
	
	}

			

void updateEndState() {
	
}

void drawGameState(Graphics g) {
	g.drawImage(rain, 0,0, RainCatcher.WIDTH, RainCatcher.HEIGHT, null);
	
	
}
void drawEndState(Graphics g) {
	g.drawImage(sunny, 0,0, RainCatcher.WIDTH, RainCatcher.HEIGHT, null);
	g.setFont(endFont);
	g.setColor(Color.WHITE);
	g.drawString("Game Over!", 30, 100);
	g.setFont(endFont2);
	g.setColor(Color.WHITE);
	g.drawString("You only caught" +score+ "inches of water", 30, 100);
	g.setFont(restart);
	g.setColor(Color.WHITE);
	g.drawString("Press ENTER to try again", 30, 300);
	
}
void drawMenuState(Graphics g) {
g.drawImage(rain, 0,0, RainCatcher.WIDTH, RainCatcher.HEIGHT, null);
g.setFont(menuFont);
g.setColor(Color.WHITE);
g.drawString("Water Catcher", 30, 100);
g.setFont(startFont);
g.setColor(Color.WHITE);
g.drawString("Press ENTER to Begin", 50, 150);
g.setFont(instructionsFont);
g.setColor(Color.WHITE);
g.drawString("Press SPACE for Instructions",50 ,200);
}
void drawInstructionsState(Graphics g) {
g.drawImage(rainpics, 0,0, RainCatcher.WIDTH, RainCatcher.HEIGHT, null);
g.setFont(instructionsFont);
g.setColor(Color.WHITE);
g.drawString("Rain Catcher Instructions", 30, 100);
g.setFont(instructions);
g.drawString("Try to catch as much rain as you can by moving the bucket", 20, 150);
g.setFont(instructions1);
g.drawString("Try to beat your previous score! Good luck and have fun!", 20, 200);
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
		
		else if (currentState > END_STATE){
        currentState = MENU_STATE;
		}
	
        else if(currentState==END_STATE) {
        System.out.println("hey");
        }
		}
        

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


}

