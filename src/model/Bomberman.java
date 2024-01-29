package model;

import java.awt.Dimension;
import java.awt.Point;

public class Bomberman extends Entity{
	
	private boolean isInvincible;
	private int nBomb;
	
	public Bomberman(int x, int y) {
		super(new Dimension(Square.SIZE, Square.SIZE) , new Point(x,y), 5, 1);
	}
	
	public Bomberman(Dimension dim, Point coordinates, int velocity, int lifes) {
		super(dim, coordinates, velocity, lifes);
	}
	
	public Bomb placeBomb(int row, int col) {
		if (nBomb==0)
			return null;
		Bomb bomb = new Bomb(row, col);
		nBomb = nBomb - 1;
		return bomb;
	}
	
	public void isAttacked() {
		if(!isInvincible) {
			lifes = lifes - 1;
			if(lifes == 0 ) 
				isAlive = false;
		}
	}
	

	public int getnBomb() {
		return nBomb;
	}


	public boolean isInvincible() {
		return isInvincible;
	}


	public void setnBomb(int nBomb) {
		this.nBomb = nBomb;
	}

	public void setInvincible(boolean isInvincible) {
		this.isInvincible = isInvincible;
	}
	
	
	
	
	public class Bomb extends GridElement{
		
		private int timer;

		public Bomb(int row, int col) {
			super(row, col);
			timer=2000;
		}
		
		public void decreaseTime(int t) {
			timer = timer - t;
		}
		
		public int getTimer() {
			return timer;
		}
		
		public void explode() {
			nBomb = nBomb -1;
		}

	}

}
