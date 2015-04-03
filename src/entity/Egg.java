package entity;

import gameMenu.SnakeGame;

import java.awt.Graphics;
import java.util.Random;

import util.PropertyManager;

public class Egg {
	public int CELL = Integer.parseInt(PropertyManager.getProperty("initCELL"));
	public int egg_x = Integer.parseInt(PropertyManager.getProperty("initEgg_x")) * CELL;
	public int egg_y = Integer.parseInt(PropertyManager.getProperty("initEgg_y")) * CELL;
	public int EGG_WIDTH = Integer.parseInt(PropertyManager.getProperty("initEgg_WIDTH")) * CELL;
	public int EGG_HEIGHT = Integer.parseInt(PropertyManager.getProperty("initEgg_HEIGHT")) * CELL;
	public boolean eggLife;
	public SnakeGame sg;
	public Random r = new Random();

	public Egg(SnakeGame sg){
		eggLife = true;
		this.sg = sg;
	}
	
	public Egg(int egg_x, int egg_y) {
		this.egg_x = egg_x;
		this.egg_y = egg_y;
		eggLife = true;
	}

	public Egg getNewEgg(){
		Egg eg = new Egg(r.nextInt(40),r.nextInt(30));
		
		if(eg)
		return eg;
	}
	
	public void EggEta(){
		this.eggLife = false;
	}
	
	public boolean getEggLife(){
		return eggLife;
	}
	
	public void drawMe(Graphics g){
		
	}
	
}
