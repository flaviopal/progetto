package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameBoard {
	
	public static final int ROW = 11;
	public static final int COL = 13;
	public static final int[] start = new int[] {0, 0};
	public static final int[] finish = new int[] {start[0] + COL * Square.SIZE, start[1]+ ROW * Square.SIZE};
	public static final Square[][] squares = new Square[ROW][COL];
	
	private List<Wall> walls;
	private Exit exit;
	
	private int level;
	
	
    static {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                squares[row][col] = new Square(start[0] + col * Square.SIZE, start[1] + row * Square.SIZE+1);
            }
        }
    }
    
    
    public GameBoard() {
    	List<Wall> walls = new ArrayList<>();
    }
    
    public GameBoard(int level) {
    	this.level=level;
    	if(level==1)
    		walls=level1Walls();
    }
    
	
	public GameBoard(List<Wall> walls, Exit exit){
		this.walls=walls;
		this.exit=exit;
	}
	
	public static Point getLocation(GridElement element) {
		Square square = squares[element.getRow()][element.getCol()];
		return new Point(square.getX(), square.getY());
	}
	
	
	
	public List<Wall> getWalls(){
		return walls;
	}
	
	public Exit getExit() {
		return exit;
	}
	
	
	public List<Wall> level1Walls(){
		List<Wall> walls = new ArrayList<>();
		walls.add(new Wall(0,10));
		walls.add(new Wall(1,1));
		walls.add(new Wall(1,3));
		walls.add(new Wall(1,5));
		walls.add(new Wall(1,7));
		walls.add(new Wall(1,9));
		walls.add(new Wall(1,11));
		walls.add(new Wall(3,1));
		walls.add(new Wall(3,3));
		walls.add(new Wall(3,5));
		walls.add(new Wall(3,7));
		walls.add(new Wall(3,8));
		walls.add(new Wall(3,9));
		walls.add(new Wall(3,11));
		walls.add(new Wall(5,0));
		walls.add(new Wall(5,1));
		walls.add(new Wall(5,3));
		walls.add(new Wall(5,5));
		walls.add(new Wall(5,7));
		walls.add(new Wall(5,9));
		walls.add(new Wall(5,11));
		walls.add(new Wall(6,9));
		walls.add(new Wall(7,0));
		walls.add(new Wall(7,1));
		walls.add(new Wall(7,3));
		walls.add(new Wall(7,5));
		walls.add(new Wall(7,7));
		walls.add(new Wall(7,9));
		walls.add(new Wall(7,10));
		walls.add(new Wall(7,11));
		walls.add(new Wall(8,11));
		walls.add(new Wall(9,1));
		walls.add(new Wall(9,3));
		walls.add(new Wall(9,5));
		walls.add(new Wall(9,7));
		walls.add(new Wall(9,9));
		walls.add(new Wall(9,11));
		walls.add(new Wall(10,2));
		walls.add(new BreakableWall(0,5));
		walls.add(new BreakableWall(0,6));
		walls.add(new BreakableWall(0,8));
		walls.add(new BreakableWall(0,9));
		walls.add(new BreakableWall(1,8));
		walls.add(new BreakableWall(1,10));
		walls.add(new BreakableWall(2,0));
		walls.add(new BreakableWall(2,7));
		walls.add(new BreakableWall(2,11));
		walls.add(new BreakableWall(2,12));
		walls.add(new BreakableWall(3,0));
		walls.add(new BreakableWall(3,2));
		walls.add(new BreakableWall(3,12));
		walls.add(new BreakableWall(4,0));
		walls.add(new BreakableWall(4,3));
		walls.add(new BreakableWall(4,5));
		walls.add(new BreakableWall(4,6));
		walls.add(new BreakableWall(4,7));
		walls.add(new BreakableWall(6,2));
		walls.add(new BreakableWall(6,4));
		walls.add(new BreakableWall(6,10));
		walls.add(new BreakableWall(6,12));
		walls.add(new BreakableWall(7,8));
		walls.add(new BreakableWall(8,0));
		walls.add(new BreakableWall(8,8));
		walls.add(new BreakableWall(8,9));
		walls.add(new BreakableWall(8,10));
		walls.add(new BreakableWall(8,12));
		walls.add(new BreakableWall(9,2));
		walls.add(new BreakableWall(9,8));
		walls.add(new BreakableWall(10,3));
		walls.add(new BreakableWall(10,5));
		walls.add(new BreakableWall(10,9));
		return walls;
	}
	
	

}
