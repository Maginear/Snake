package gameMenu;

import entity.Egg;
import entity.Snake;
import frame.GameFrame;

public class SnakeGame {
	
	public static void main(String []args) {
		SnakeGame sg =  new SnakeGame();
		Snake sna = new Snake(sg);
		Egg egg =  new Egg(sg);
		GameFrame gf = new GameFrame(sg, sna, egg);
        gf.launchFrame();
	}
	
	
}
