package entity;

import gameMenu.SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import util.Direction;
import util.PropertyManager;

public class Snake {
	public int CELL = Integer.parseInt(PropertyManager.getProperty("initCELL"));
	public int snake_x = Integer.parseInt(PropertyManager.getProperty("initSnake_x"));
	public int snake_y = Integer.parseInt(PropertyManager.getProperty("initSnake_y"));
	public boolean life = true;
	public static final int SNAKE_WIDTH = 50;
	public static final int SNAKE_HEIGHT = 50;
	public Direction dir = Direction.RIGHT;
	
	public SnakeGame sg;
	public List<Point> snakeBody = new ArrayList<Point>();

	public Snake(SnakeGame sg){
		new Thread(new SnakeMove()).start();
		this.sg = sg;
		initBody();
 	}
	
	public Snake(int snake_x, int snake_y) {
		this.snake_x = snake_x;
		this.snake_y = snake_y;
		new Thread(new SnakeMove()).start();
	}

	public void move() {
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
	}
	
	private class SnakeMove implements Runnable{

		@Override
		public void run() {
			while (true) {
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

	public boolean isEatEgg(Egg egg) {
		return true;
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
		Color c = g.getColor();
		g.setColor(Color.CYAN);
		for(Point poi : snakeBody){
		g.fillRect(poi.x * CELL, poi.y * CELL, CELL, CELL);
		}
		g.setColor(c);
	}
}
