package intro_to_array_lists;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class LeagueInvaders {
	JFrame frame; 	
GamePanel panel1;
static final int WIDTH=500;
static final int HEIGHT=800;


	LeagueInvaders(){
		frame = new JFrame();
		panel1 = new GamePanel();
	}
	public static void main(String[] args) {
		
		LeagueInvaders invader=new LeagueInvaders();
		invader.setup();
	}

	
	public void setup() {
		frame.add(panel1);
        frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setVisible(true);
		panel1.startGame();
		frame.addKeyListener(panel1);
		
		
}
	
	
	}
