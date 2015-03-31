package entity;

public class Egg {
	public int egg_x;
	public int egg_y;
	public static final int EGG_X = 10;
	public static final int EGG_Y = 10;

	public Egg(int egg_x, int egg_y) {
		this.egg_x = egg_x;
		this.egg_y = egg_y;
	}

	public static Egg getNewEgg(int x, int y){
		return new Egg(x,y);
	}
}
