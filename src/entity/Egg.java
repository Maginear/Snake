package entity;

import gameMenu.SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import util.GameListener;
import util.PropertyManager;
import controller.Controller;

public class Egg extends Point{
	public int CELL = Integer.parseInt(PropertyManager.getProperty("initCELL"));
	public int EGG_WIDTH = Integer.parseInt(PropertyManager.getProperty("initEgg_WIDTH")) * CELL;
	public int EGG_HEIGHT = Integer.parseInt(PropertyManager.getProperty("initEgg_HEIGHT")) * CELL;
	public GameListener gl;	
	public boolean eggLife;
	public SnakeGame sg;
	public Snake sna;

	public Egg(int egg_x, int egg_y) {
		this.x = egg_x;
		this.y = egg_y;
		eggLife = true;
	}
	
    
	public static Egg getNewEgg(){
		Random r = new Random();
		boolean Eggcover;
		Egg eg;
		do {
			eg = new Egg(r.nextInt(40), r.nextInt(30));
			Eggcover = false;
			for (Point poi :Snake.snakeBody) {
				if (poi.equals(eg)) {
					Eggcover = true;
					break;
				}
			}
		} while (Eggcover);
		return eg;
	}
	
	public void EggEta(){
		this.eggLife = false;
	}
	
	public boolean getEggLife(){
		return eggLife;
	}
	
	public void drawMe(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(this.x * CELL, this.y * CELL, CELL, CELL);
		g.setColor(c);
	}
	
	public void addEggListner(GameListener gl){
		this.gl = gl;
	}
	
}
