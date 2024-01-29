package controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import model.Bomberman;
import model.Game;
import model.GameBoard;
import model.Square;
import model.Wall;

public class Controller implements KeyListener{
	
	private Game game;
	
	public Controller(Game game) {
		this.game=game;
	}
	
	
	
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        Bomberman bomberman = game.getBomberman();
        int dx=0;
        int dy=0;

        // Gestisci le pressioni dei tasti e muovi il personaggio
        if (keyCode == KeyEvent.VK_UP) {
        	dx=0;
        	dy=-bomberman.getVelocity();
        } 
        else if (keyCode == KeyEvent.VK_DOWN) {
        	dx=0;
        	dy=bomberman.getVelocity();
        } 
        else if (keyCode == KeyEvent.VK_LEFT) {
        	dx=-bomberman.getVelocity();
        	dy=0;
        } 
        else if (keyCode == KeyEvent.VK_RIGHT) {
        	dx=bomberman.getVelocity();
        	dy=0;
        }
        
        updateDirection(dx, dy);
        
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
    	game.setBombermanMoving(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Implementa se necessario
    }
    
    
    public void updateDirection(int dx, int dy) {
    	Bomberman bomberman = game.getBomberman();
        if (dy > 0) {
            bomberman.setDirection(0); // Down
        } else if (dx < 0) {
        	bomberman.setDirection(1); // Left
        } else if (dx > 0) {
        	bomberman.setDirection(2); // Right
        } else if (dy < 0) {
        	bomberman.setDirection(3); // Up
        }
        
        Point point=bomberman.getCoordinates();
        
        if ((dx != 0 || dy != 0) ) {
        	game.moveBomberman(dx, dy);
        	//bomberman.move(dx, dy);
            bomberman.setMoving(true);
            //animationCounter++;
        } else {
        	bomberman.setMoving(false);
        }
    }
    
  
	
	
	/*
	 * public boolean checkWallsCollision(int x, int y) { int row = (y -
	 * GameBoard.start[1]) / Square.SIZE; int col = (x - GameBoard.start[0]) /
	 * Square.SIZE; List<Wall> walls = game.getGameBoard().getWalls(); for
	 * (Iterator<Wall> iterator = walls.iterator(); iterator.hasNext();) { Wall wall
	 * = iterator.next(); int wallRow = wall.getRow(); int wallCol = wall.getCol();
	 * if ((wallRow==row && wallCol==col)|| (wallRow==row && wallCol==(col+1))||
	 * (wallRow==(row+1) && wallCol==col)|| (wallRow==(row+1)&& wallCol ==(col+1)))
	 * return true; } return false; }
	 */
	
	
	
	public boolean checkWallsCollision(int x, int y) {
		int row = (y - GameBoard.start[1]) / Square.SIZE;
		int col = (x - GameBoard.start[0]) / Square.SIZE;
		List<Wall> walls = game.getGameBoard().getWalls();
		for (Iterator<Wall> iterator = walls.iterator(); iterator.hasNext();) {
			Wall wall = iterator.next();
			int wallRow = wall.getRow();
			int wallCol = wall.getCol();
			if ((wallRow==row && wallCol==col)||
					(wallRow==row && wallCol==(col+1))||
					(wallRow==(row+1) && wallCol==col)||
					(wallRow==(row+1)&& wallCol ==(col+1)))
				return true;
		}
		return false;
	}
	
	
    private void startAnimation() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	
            }
        }, 0, 400); // aggiorna ogni 0.4 secondi
    }
	
	
	
}
