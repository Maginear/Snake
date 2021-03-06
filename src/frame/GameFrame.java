package frame;

import entity.Egg;
import entity.Snake;
import gameMenu.SnakeGame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controller.Controller;
import util.PropertyManager;


public class GameFrame extends Frame{
	public int CELL = Integer.parseInt(PropertyManager.getProperty("initCELL"));
	public int frame_x = Integer.parseInt(PropertyManager.getProperty("initframe_x")) * CELL;
	public int frame_y = Integer.parseInt(PropertyManager.getProperty("initframe_y")) * CELL;
	public int FRAME_WIDTH = Integer.parseInt(PropertyManager.prop.getProperty("initFRAME_WIDTH")) * CELL;
	public int FRAME_HEIGHT = Integer.parseInt(PropertyManager.prop.getProperty("initFRAME_HEIGHT")) * CELL;
	public Image offScreenImage = null;
	public Controller ctr;
	
	public GameFrame(Controller ctr){
		super("SnakeGame");
		this.ctr = ctr;
	}
	
	public void launchFrame() {
		this.setLocation(frame_x, frame_y);
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setBackground(Color.BLACK);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
                   System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());
		
        new Thread(new DrawThread()).start();		
	}
	
	public class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			ctr.sna.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			ctr.sna.keyReleased(e);
		}
		
	}
	
	public void paint(Graphics g) {
		ctr.eg.drawMe(g);
		ctr.sna.drawMe(g);
	}
	
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null){
			offScreenImage = this.createImage(FRAME_WIDTH, FRAME_HEIGHT);
		}
		Graphics goff = offScreenImage.getGraphics();
		Color c = goff.getColor();
		goff.setColor(Color.LIGHT_GRAY);
		goff.fill3DRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT, true);
		goff.setColor(c);
		paint(goff);
		g.drawImage(offScreenImage,0,0, null);
	}

	public class DrawThread implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
		}
	}
	
	
}
