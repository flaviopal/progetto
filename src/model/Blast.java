package model;

public class Blast extends GridElement{
	
	private int timer;

	public Blast(int row, int col) {
		super(row, col);
		timer=1000;
	}
	
	public void decreaseTime(int t) {
		timer = timer - t;
	}
	
	public int getTimer() {
		return timer;
	}

}
