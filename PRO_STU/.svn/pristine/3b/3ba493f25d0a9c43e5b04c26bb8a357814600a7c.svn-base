package chessGui;

import javax.swing.JButton;

/**
 * Bottom control panel for chess GUI.
 * Handles buttons dealing with black and white surrender, undoing moves, and resetting the entire game.
 * 
 *
 */
@SuppressWarnings("serial")
public class BottomControlPanel extends ControlPanel {
	JButton blackForfeitButton, whiteForfeitButton;
	JButton undoButton;
	JButton restartButton;
	
	/**
	 * Constructor
	 */
	public BottomControlPanel()
	{
		super();
		
		whiteForfeitButton = new JButton("Player White Forfeits");
		whiteForfeitButton.setActionCommand("playerWhiteForfeits");
		blackForfeitButton = new JButton("Player Black Forfeits");
		blackForfeitButton.setActionCommand("playerBlackForfeits");
		
		undoButton = new JButton("Undo Last Move");
		undoButton.setActionCommand("undoLastMove");
		
		restartButton = new JButton("Restart Game");
		restartButton.setActionCommand("restartGame");
		
		addComponentToBoard(whiteForfeitButton, BUTTON_DIMENSION, 0, 2, 1, 1);
		addComponentToBoard(blackForfeitButton, BUTTON_DIMENSION, 1, 2, 1, 1);
		addComponentToBoard(restartButton, BUTTON_DIMENSION, 2, 2, 1, 1);
		addComponentToBoard(undoButton, BUTTON_DIMENSION, 3, 2, 1, 1);
	}

}
