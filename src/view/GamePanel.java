package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Bomberman;
import model.Game;
import model.GameBoard;
import model.Square;
import model.Wall;

public class GamePanel extends JPanel implements Observer{
	
	private GameFrame gmf;
	private BufferedImage[] bombermanSprite;
	private BufferedImage wallSprite;
	private BufferedImage[] breakableWallSprite;
	private Object infoToPaint;
	private int animationCounter;
	
	public GamePanel() {
		/*
		 * gmf = new GameFrame(); gmf.getContentPane().add(this); gmf.pack();
		 * gmf.setTitle("Super Bomberman"); gmf.setResizable(false);
		 * gmf.setVisible(true); this.setFocusable(true);
		 */
        initialize();  
	}
	
	public void initialize() {
		loadSprites();
		animationCounter=0;
	}

	private void loadSprites() {
        bombermanSprite = new BufferedImage[12];
        try {
            for (int i = 0; i <= 11; i++) {
                bombermanSprite[i] = ImageIO.read(getClass().getResource("/sprites/bomberman/" + (i + 1) + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        breakableWallSprite = new BufferedImage[4];
        try {
            for (int i = 0; i<=3; i++) {
            	breakableWallSprite[i] = ImageIO.read(getClass().getResource("/sprites/destructible/alarm0" + (i + 1) + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        try {
        	wallSprite = ImageIO.read(getClass().getResource("/sprites/building.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}

	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (infoToPaint instanceof Game) {
        	Game game = ((Game)infoToPaint);
        	List<Wall> walls = game.getGameBoard().getWalls();
        	Bomberman bomberman = game.getBomberman();
        	drawWalls(g, walls);
        	drawBomberman(g, bomberman);
        }
        
    }
    
    
    public void drawWalls(Graphics g, List<Wall> walls) {
		for (Iterator<Wall> iterator = walls.iterator(); iterator.hasNext();) {
			Wall wall = iterator.next();
			Point point = GameBoard.getLocation(wall);
			g.drawImage(wallSprite, point.x, point.y, Square.SIZE, Square.SIZE, null);
		}
    }
    
    public void drawBomberman(Graphics g, Bomberman bomberman) {
    	int currentSpriteIndex = getCurrentBoySprite(bomberman);
    	BufferedImage currentSprite = bombermanSprite[currentSpriteIndex];
    	Point point = bomberman.getCoordinates();
    	g.drawImage(currentSprite, point.x, point.y, Square.SIZE, Square.SIZE, null);
    	animationCounter++;
    }
    
    
    public int getCurrentBoySprite(Bomberman bomberman) {
        if (bomberman.isMoving()) {
            int startIndex = bomberman.getDirection() * 3;
            int spriteIndex = startIndex + (animationCounter % 2);
            return spriteIndex;
        } else {
            int startIndex = bomberman.getDirection() * 3;
            return startIndex;
        }
    }
    
    
	@Override
	public void update(Observable o, Object arg) {
		infoToPaint=arg;
		repaint();
	}
	
	

}
