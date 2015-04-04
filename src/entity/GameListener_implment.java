package entity;

import util.GameListener;

public class GameListener_implment implements GameListener {
	
	@Override
	public void doMove(Even e) {
		e.getCtr().snakeEatEgg();
		e.getCtr().hitSelf();
	}
}
