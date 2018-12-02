package intro_to_array_lists;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RainCatcher {
JFrame rainFrame;
JPanel rainPanel;
static final int WIDTH=500;
static final int HEIGHT=800;


RainCatcher(){
rainFrame= new JFrame();
rainPanel=new JPanel();
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
	//rainFrame.start();
	//rainFrame.addKeyListener(rainPanel);
		
}
}
