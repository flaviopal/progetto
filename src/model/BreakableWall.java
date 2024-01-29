package model;

public class BreakableWall extends Wall{
	
	private int rotation;
	private int powerUp;

	public BreakableWall(int row, int col) {
		super(row, col);
	}
	
	public BreakableWall(int row, int col, int powerUp) {
		super(row, col);
		this.powerUp=powerUp;
	}
	
	public int getRotation() {
		return rotation;
	}
	
	public void rotate() {
		rotation = (rotation + 1) % 4;
	}
	
	public int getpowerUp() {
		return powerUp;
	}

}
