package entity;

import controller.Controller;

public class Even {
	private Controller ctr;
	
	public Even(Controller ctr){
		this.ctr = ctr;
	}
	
	public Controller getCtr(){
		return ctr;
	}
	
	public void setCtr(Controller ctr){
		this.ctr = ctr;
	}
}
