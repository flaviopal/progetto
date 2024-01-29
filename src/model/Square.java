package model;


public class Square {
	
	public static final int SIZE = 32;
	//coordinate in pixel
	private int x;
	private int y;
	
	public Square(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
