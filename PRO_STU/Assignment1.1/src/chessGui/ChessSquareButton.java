package chessGui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

/**
 * Button class to simulate chess squares.
 * 
 *
 */

@SuppressWarnings("serial")
public class ChessSquareButton extends JButton {
	Color squareColor;	
	
	/**
	 * Constructor
	 */
	public ChessSquareButton(Color squareColor)
	{			
		this.squareColor = squareColor;
		
		setPreferredSize(new Dimension(ChessView.BOARD_SQUARE_SIZE, ChessView.BOARD_SQUARE_SIZE));
		setBackground(squareColor);
		setOpaque(true);
	}
}
