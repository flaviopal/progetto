package controller;

import java.awt.Dimension;

import model.Bomberman;
import model.Game;
import model.GameBoard;
import model.Square;
import view.GameFrame;
import view.GamePanel;

public class Main {
	public static void main(String[] args) {
		GameBoard gameBoard = new GameBoard(1);
		Bomberman bomberman = new Bomberman (0,0);
		Game game = new Game(gameBoard, null, bomberman);
		Controller controller = new Controller(game);
		GameFrame gameFrame = new GameFrame();
		GamePanel gamePanel = gameFrame.getGamePanel();
		gameFrame.setVisible(true);
		game.addObserver(gamePanel);
		gamePanel.addKeyListener(controller);
		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();
		game.play();
	}
}
