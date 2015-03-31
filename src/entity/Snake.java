package entity;

import util.Direction;

public class Snake {
	public int snake_x;
	public int snake_y;
	public boolean life = true;
	public static final int SNAKE_WIDTH = 10;
	public static final int SNAKE_HEIGHT = 10;

	public Snake(int snake_x, int snake_y) {
		this.snake_x = snake_x;
		this.snake_y = snake_y;
	}

	public void move(Direction dir) {
        
	}

	public boolean isEatEgg(Egg egg) {
		return true;
	}

	public boolean getlife() {
		return life;
	}
}
