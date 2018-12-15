
package RainGamePackage;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import intro_to_array_lists.GamePanel;


public class RainCatcher {
	JFrame rainFrame; 	
RainGamePanel rainPanel;
static final int WIDTH=500;
static final int HEIGHT=800;


	RainCatcher(){
		rainFrame = new JFrame();
		rainPanel = new RainGamePanel();
	}
	public static void main(String[] args) {
		RainCatcher catcher=new RainCatcher();
		catcher.setup();
	}

	
	public void setup() {
		rainFrame.add(rainPanel);
		rainFrame.pack();
		rainFrame.setVisible(true);
		rainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rainFrame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		rainFrame.pack();
		rainFrame.setVisible(true);
		rainPanel.start();
		rainFrame.addKeyListener(rainPanel);
		
		
}
	
	
	}

