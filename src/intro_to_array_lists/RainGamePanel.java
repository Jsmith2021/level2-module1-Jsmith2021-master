package intro_to_array_lists;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class RainGamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int INSTRUCTIONS_STATE=1;
	final int GAME_STATE = 2;
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
	
RainGamePanel(){
	rainTimer=new Timer(1000/60,this);
	menuFont=new Font("Arial", Font.BOLD, 48);
	startFont=new Font("Arial", Font.PLAIN, 24);
	instructionsFont=new Font("Arial", Font.PLAIN, 24);
	endFont=new Font("Arial", Font.BOLD, 48);
	endFont2=new Font("Arial", Font.PLAIN, 24);
	restart=new Font("Arial", Font.PLAIN, 24);
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
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	
}
void drawEndState(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	g.setFont(endFont);
	g.setColor(Color.WHITE);
	g.drawString("Game Over!", 30, 100);
	g.setFont(endFont2);
	g.setColor(Color.WHITE);
	g.drawString("You only caught" +score+ "inches", 30, 100);
	g.setFont(restart);
	g.setColor(Color.WHITE);
	g.drawString("Press ENTER to try again", 30, 300);
	
}
void drawMenuState(Graphics g) {
g.setColor(Color.CYAN);	
g.fillRect(0, 0, WIDTH, HEIGHT);
g.setFont(menuFont);
g.setColor(Color.BLACK);
g.drawString("Water Catcher", 30, 100);
g.setFont(startFont);
g.setColor(Color.BLACK);
g.drawString("Press ENTER to Begin", 50, 150);
g.setFont(instructionsFont);
g.setColor(Color.BLACK);
g.drawString("Press SPACE for Instructions",50 ,200);
}
void drawInstructionsState(Graphics g) {
	
}
@Override
public void paintComponent(Graphics g){
	
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

public void start() {
	rainTimer.start();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
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
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


}

