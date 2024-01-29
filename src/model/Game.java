package model;

import java.util.List;
import java.util.Observable;

import model.Bomberman.Bomb;

public class Game extends Observable{
	
	private GameBoard gameBoard;
	private List<Enemy> enemies;
	private List<Bomb> bombs;
	private Bomberman bomberman;
	private boolean isPlaying;
	private int score;
	private int level;
	
    public Game(GameBoard gameBoard, List<Enemy> enemies, Bomberman bomberman) {
    	this.gameBoard=gameBoard;
    	this.enemies=enemies;
    	this.bomberman=bomberman;
    	score=0;
    }


	public GameBoard getGameBoard() {
		return gameBoard;
	}


	public List<Enemy> getEnemies() {
		return enemies;
	}


	public List<Bomb> getBombs() {
		return bombs;
	}


	public Bomberman getBomberman() {
		return bomberman;
	}


	public boolean isPlaying() {
		return isPlaying;
	}


	public int getScore() {
		return score;
	}
	
	public void play() {
		isPlaying=true;
		setChanged();
        notifyObservers(this);
	}
	
	
	public void setBombermanMoving(boolean isMoving) {
		bomberman.setMoving(isMoving);
        setChanged();
        notifyObservers(this);
	}
    
    
    public void moveBomberman(int dx, int dy){
    	bomberman.move(dx, dy);
        setChanged();
        notifyObservers(this);
    }
    
    
    
    
    
	
	
}
