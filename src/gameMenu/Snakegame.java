package gameMenu;

import controller.Controller;
import entity.Egg;
import entity.Snake;
import frame.GameFrame;

public class SnakeGame {
	
	public static void main(String []args) {
		 Controller ctr = new Controller();
		 GameFrame gf = new GameFrame(ctr);		 
		 gf.launchFrame();
	}
	
	
}
