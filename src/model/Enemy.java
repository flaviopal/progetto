package model;

import java.awt.Dimension;
import java.awt.Point;

public abstract class Enemy extends Entity{
	
	private int points;
	
	public Enemy(Dimension dim, Point coordinates, int velocity, int lifes, int points) {
		super(dim, coordinates, velocity, lifes);
	}
	
	public void attack(Bomberman bomberman) {
		bomberman.isAttacked();
	}
	
	public void isAttacked() {
		lifes = lifes - 1;
		if(lifes == 0 ) 
			isAlive = false;
	}

}
