package entity;

import gameMenu.SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import util.Direction;
import util.GameListener;
import util.PropertyManager;
import controller.Controller;

public class Snake {
	public int CELL = Integer.parseInt(PropertyManager.getProperty("initCELL"));
	public int snake_x = Integer.parseInt(PropertyManager.getProperty("initSnake_x"));
	public int snake_y = Integer.parseInt(PropertyManager.getProperty("initSnake_y"));
	public boolean life = true;
	public static final int SNAKE_WIDTH = 50;
	public static final int SNAKE_HEIGHT = 50;
	public Direction dir = Direction.RIGHT;
	public GameListener gl;
	public Point lastPoi;
	public Controller ctr;
	public Thread t;
	
	public static List<Point> snakeBody = new ArrayList<Point>();

	public Snake(Controller ctr){
	    t = new Thread(new SnakeMove());
		t.start();
		this.ctr = ctr;
		initBody();
 	}
	
	public Snake(int snake_x, int snake_y, SnakeGame sg, Egg eg) {
		this.snake_x = snake_x;
		this.snake_y = snake_y;
	}

	public void move() {
		lastPoi = new Point(snakeBody.get(snakeBody.size()-1).getLocation());
		
        switch(dir){
		case RIGHT:
			for (int i = snakeBody.size() - 1; i > 0; i--) {
				snakeBody.get(i)
						.setLocation(snakeBody.get(i - 1).getLocation());
			}
			snakeBody.get(0).x++;
			 break;
			 
		case UP:
			for (int i = snakeBody.size() - 1; i > 0; i--) {
				snakeBody.get(i)
						.setLocation(snakeBody.get(i - 1).getLocation());
			}
			snakeBody.get(0).y--;
			break;
			
		case LEFT:
			for (int i = snakeBody.size() - 1; i > 0; i--) {
				snakeBody.get(i)
						.setLocation(snakeBody.get(i - 1).getLocation());
			}
			snakeBody.get(0).x--;
			break;
			
		case DOWN:
			for (int i = snakeBody.size() - 1; i > 0; i--) {
				snakeBody.get(i)
						.setLocation(snakeBody.get(i - 1).getLocation());
			}
			snakeBody.get(0).y++;
			break;
		}
        
        gl.doMove(new Even(ctr));
	}
	
	private class SnakeMove implements Runnable{

		@Override
		public void run() {
			while (life) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				move();
			}
		}
	}
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		Direction newDir;
		
		switch(keyCode){
		case KeyEvent.VK_LEFT:
			newDir = Direction.LEFT;
			if(dir != Direction.RIGHT && dir != newDir)
				dir = newDir;
			break;
		case KeyEvent.VK_UP:
			newDir = Direction.UP;
			if(dir != Direction.DOWN && dir != newDir)
				dir = newDir;
			break;
		case KeyEvent.VK_RIGHT:
			newDir = Direction.RIGHT;
			if(dir != Direction.LEFT && dir != newDir)
				dir = newDir;
			break;
		case KeyEvent.VK_DOWN:
			newDir = Direction.DOWN;
			if(dir != Direction.UP && dir != newDir)
				dir = newDir;
			break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		
	}

	public boolean isSnakeAteEgg(Egg eg){
		if(snakeBody.get(0).equals(eg)){
			return true;
		}
		return false;
	}
	
	public boolean isSnakeHitSelf(){
		for(Point poi: snakeBody){	
			if(poi != snakeBody.get(0)){
				if(poi.equals(snakeBody.get(0))){
					return true;
				}
			}
		}
		return false;
	}
	
	public void AteEgg(){
		snakeBody.add(lastPoi);
	}

	public boolean getlife() {
		return life;
	}
	
	public void initBody(){
		for(int i = 0; i <= 5; i++){
			snakeBody.add(new Point(snake_x, snake_y + i));
		}
	}
	
	public void drawMe(Graphics g){
		if (life) {
			Color c = g.getColor();
			g.setColor(Color.CYAN);
			for (Point poi : snakeBody) {
				g.fillRect(poi.x * CELL, poi.y * CELL, CELL, CELL);
			}
			g.setColor(c);
		}
	}
	
	public void addSnakeListener(GameListener gl){
		this.gl = gl;
	}
}
