package view;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GameBoard;
import model.Square;

public class GameFrame extends JFrame{
	
	private JPanel contentPane;
	private GamePanel gamePanel;
	private BorderLayout borderLayout1 = new BorderLayout();

	public GameFrame() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		setBounds(350,120,GameBoard.COL * Square.SIZE+20,GameBoard.ROW * Square.SIZE+40);
		try {
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		gamePanel = new GamePanel();
		add(gamePanel);
		gamePanel.setBounds(GameBoard.start[0], GameBoard.start[1], GameBoard.finish[0], GameBoard.finish[1]);
	}

	//Component initialization
	private void initialize() throws Exception {
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(borderLayout1);
	}

	@Override
	//Overridden so we can exit when window is closed
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}
	
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
	

}