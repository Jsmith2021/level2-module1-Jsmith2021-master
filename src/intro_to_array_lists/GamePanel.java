package intro_to_array_lists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics; 

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState= MENU_STATE;
	//GameObject object;
	
	GamePanel(){
		//object = new GameObject(30, 50, 10, 60);
		timer=new Timer(1000/60,this);
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);    
	}
	void drawGameState(Graphics g) {
		g.fillRect(0,0, 500, 800);
		g.setColor(Color.RED);
	}
	void drawEndState(Graphics g) {
		g.fillRect(0,0, 500, 800);
		g.setColor(Color.BLACK);	
	}
	 @Override

	 public void paintComponent(Graphics g){
		 //g.fillRect(10, 10, 100, 100);
		// object.draw(g);
		 if(currentState == MENU_STATE){
             setup(g);

     }
		 else if(currentState == GAME_STATE){
             setup(g);
     }
		 else if(currentState == END_STATE){
             setup(g);

     }
// part 6, step 7

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
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hola");
	}
	
	
}
