package chessGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chessGame.ChessGame;
import chessGame.ChessPiece;
import chessGame.Position;

/**
 * Creates a GUI visualization of a game of thrones.
 * 
 *
 */

@SuppressWarnings("serial")
public class ChessView extends JFrame {
	public static final int BOARD_WIDTH = 8;
	public static final int BOARD_HEIGHT = 8;
	public static final int BOARD_SQUARE_SIZE = 85;
	
	ChessSquareButton boardButtons[][];	/** Chess squares */
	ChessGame model;	/** Game this view is modeling */
	JPanel boardPanel;	/** Chess board */
	TopControlPanel topPanel;	/** Score controls */
	BottomControlPanel bottomPanel;	/** Reset controls */
	
	/**
	 * Constructor
	 * Initializes top controls, middle board, and bottom controls for viewing.
	 * @param model the chess game this view is modeling
	 */
	public ChessView(ChessGame model)
	{
		super("Chess");
		
		this.model = model;
				
		boardPanel = new JPanel();
		boardButtons = new ChessSquareButton[BOARD_WIDTH][BOARD_HEIGHT];
		boardPanel.setLayout(new GridLayout(BOARD_WIDTH, BOARD_HEIGHT));
		
		for (int x = 0; x < BOARD_WIDTH; x++)
			for (int y = 0; y < BOARD_HEIGHT; y++)
			{
				Color squareColor = (((x + y) % 2 == 0) ? ChessImageIcons.LIGHT_SQUARE_COLOR : ChessImageIcons.DARK_SQUARE_COLOR);
				ChessSquareButton currSquare = new ChessSquareButton(squareColor);
				
				currSquare.setActionCommand(y + " " + (BOARD_HEIGHT - 1 - x));
				
				ChessPiece currPiece = model.getChessPieceFromSquare(new Position(y, (BOARD_HEIGHT - 1 - x)));
				if (currPiece != null)
					currSquare.setIcon(currPiece.getSymbolRepresentation());
				
				boardButtons[x][y] = currSquare;
				boardPanel.add(currSquare);
			}
		
		add(boardPanel, BorderLayout.CENTER);

		topPanel = new TopControlPanel();
		add(topPanel, BorderLayout.NORTH);
		
		bottomPanel = new BottomControlPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	/**
	 * Redraws the entire chess board with corresponding symbols.
	 */
	public void drawChessBoard()
	{
		for (int x = 0; x < BOARD_WIDTH; x++)
			for (int y = 0; y < BOARD_HEIGHT; y++)
			{
				ChessSquareButton currSquare = boardButtons[x][y];
				ChessPiece currPiece = model.getChessPieceFromSquare(new Position(y, (BOARD_HEIGHT - 1 - x)));
				
				if (currPiece != null)
					currSquare.setIcon(currPiece.getSymbolRepresentation());
				else
					currSquare.setIcon(new ImageIcon());
			}
	}
	
	/**
	 * Prints a string to the message board. 
	 * @param message to be printed
	 */
	public void printMessageToBoard(String message)
	{
		topPanel.messageBoard.setText(message);
	}

	/**
	 * Changes player black's score
	 * @param i the new score
	 */
	public void setPlayerBlackScore(int i) {
		topPanel.blackPlayerScore.setText(i + "");
	}
	
	/**
	 * Changes player white's score
	 * @param i the new score
	 */
	public void setPlayerWhiteScore(int i) {
		topPanel.whitePlayerScore.setText(i + "");
	}

	/**
	 * Changes the player's name
	 * @param s the new name
	 * @param playerColor the color of the player whose name we wish to change
	 */
	public void setPlayerName(String s, ChessPiece.Color playerColor) {
		if (playerColor == ChessPiece.Color.WHITE)
			topPanel.whitePlayerButton.setText(s + " (white)");
		else
			topPanel.blackPlayerButton.setText(s + " (black)");
	}
	
	
	/**
	 * Gets the player score from the score board
	 * @param playerColor the player color
	 * @return the String representation of player name
	 */
	public String getPlayerName(ChessPiece.Color playerColor) {
		if (playerColor == ChessPiece.Color.WHITE)
			return topPanel.whitePlayerButton.getText();
		else
			return topPanel.blackPlayerButton.getText();
	}

	public String getMessageBoard() {
		return topPanel.messageBoard.getText();
	}
}
