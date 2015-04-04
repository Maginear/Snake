package controller;

import entity.Egg;
import entity.GameListener_implment;
import entity.Snake;
import frame.GameFrame;

public class Controller {
	public Egg eg = Egg.getNewEgg();
	public Snake sna = new Snake(this);
	public GameFrame gf = new GameFrame(this);
	public GameListener_implment gf_impl = new GameListener_implment(); 
	public Controller() {
		sna.addSnakeListener(gf_impl);
	}
	
	public void snakeEatEgg(){
		if(sna.isSnakeAteEgg(eg)){
			sna.AteEgg();
			eg = Egg.getNewEgg();
		} 
	}
	
	public void hitSelf(){
		if(sna.isSnakeHitSelf()){
			sna.life = false;
			sna.addSnakeListener(gf_impl);
		}
	}
}
