package model;

public abstract class GridElement{
	//coordinate righe e colonne
	private int row;
	private int col;
	
	public GridElement(int row, int col) {
		this.row=row;
		this.col=col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
