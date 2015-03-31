package frame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import util.PropertyManager;


public class GameFrame extends Frame{

	public int frame_x = Integer.parseInt(PropertyManager.getProperty("initframe_x"));
	public int frame_y = Integer.parseInt(PropertyManager.getProperty("initframe_y"));
	public static final int FRAME_WIDTH = Integer.parseInt(PropertyManager.prop.getProperty("initFRAME_WIDTH"));
	public static final int FRAME_HEIGHT = Integer.parseInt(PropertyManager.prop.getProperty("initFRAME_HEIGHT"));
	
	public GameFrame(){
		super("SnakeGame");
	}
	
	public void launchFrame() {
		this.setLocation(frame_x, frame_y);
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setBackground(Color.CYAN);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
                   System.exit(0);
			}
		});
	}
	
	@Override
	public void print(Graphics g) {
		g.setColor(Color.GRAY);
	}

}
