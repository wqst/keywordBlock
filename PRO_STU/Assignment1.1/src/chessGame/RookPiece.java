package chessGame;

import java.util.List;

import javax.swing.ImageIcon;

import chessGui.ChessImageIcons;

/**
 * Represents the rook piece in chess.
 * The rook moves and captures along any horizontal or vertical.
 */

public class RookPiece extends ChessPiece {

	/**
	 * Constructor
	 */
	public RookPiece(Color color, Position position, int boardWidth,
			int boardHeight) {
		super(color, position, boardWidth, boardHeight);
	}
	
	/**
	 * @see chessGame.ChessPiece#computePossibleMoveSpaces()
	 */
	public List<List<Position>> computePossibleMoveSpaces() 
	{
		return computeHorizontalVerticalMoves();
	}

	/**
	 * @see chessGame.ChessPiece#computePossibleCaptureSpaces()
	 */
	public List<List<Position>> computePossibleCaptureSpaces() 
	{
		return computePossibleMoveSpaces();
	}

	/**
	 * @see chessGame.ChessPiece#toString()
	 */
	public String toString() {
		return getColor() == Color.WHITE ? "R" : "r";
	}	
	
	/**
	 * @see chessGame.ChessPiece#getSymbolRepresentation()
	 */
	public ImageIcon getSymbolRepresentation() {
		return getColor() == Color.WHITE ? ChessImageIcons.WHITE_ROOK : ChessImageIcons.BLACK_ROOK;
	}
}
