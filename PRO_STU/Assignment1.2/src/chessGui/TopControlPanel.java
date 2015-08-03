package chessGui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Represents the top control panel used for scoring purposes
 * 
 *
 */

@SuppressWarnings("serial")
public class TopControlPanel extends ControlPanel {
	JButton whitePlayerButton, blackPlayerButton;
	JLabel whitePlayerScore, blackPlayerScore;
	JLabel messageBoard;
	
	/**
	 * Constructor
	 */
	public TopControlPanel()
	{
		super();
		
		whitePlayerButton = new JButton("Player White's Score");
		whitePlayerButton.setActionCommand("playerWhite");
		blackPlayerButton = new JButton("Player Black's Score");
		blackPlayerButton.setActionCommand("playerBlack");
		
		whitePlayerScore = new JLabel("0", JLabel.CENTER);
		whitePlayerScore.setForeground(Color.BLACK);
		whitePlayerScore.setBackground(Color.WHITE);
		whitePlayerScore.setOpaque(true);
		
		blackPlayerScore = new JLabel("0", JLabel.CENTER);
		blackPlayerScore.setForeground(Color.BLACK);
		blackPlayerScore.setBackground(Color.WHITE);
		blackPlayerScore.setOpaque(true);
		
		messageBoard = new JLabel("Player White's Move", JLabel.CENTER);
		messageBoard.setForeground(Color.RED);
		messageBoard.setBackground(Color.BLACK);
		messageBoard.setOpaque(true);
		
		addComponentToBoard(whitePlayerButton, BUTTON_DIMENSION, 0, 0, 1, 1);
		addComponentToBoard(whitePlayerScore, BUTTON_DIMENSION, 1, 0, 1, 1);
		addComponentToBoard(blackPlayerButton, BUTTON_DIMENSION, 2, 0, 1, 1);
		addComponentToBoard(blackPlayerScore, BUTTON_DIMENSION, 3, 0, 1, 1);
		addComponentToBoard(messageBoard, LABEL_DIMENSION, 0, 1, 4, 1);
	}
}
