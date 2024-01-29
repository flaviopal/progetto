package model;

public class Exit extends GridElement{
	
	private boolean isActive;
	
	public Exit(int row, int col) {
		super(row, col);
	}
	
	public void activates() {
		isActive=true;
	}
	
	public boolean isActive() {
		return isActive;
	}

}
