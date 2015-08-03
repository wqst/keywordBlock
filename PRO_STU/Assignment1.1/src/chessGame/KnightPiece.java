package chessGame;

import java.util.List;

import javax.swing.ImageIcon;

import chessGui.ChessImageIcons;


/**
 * Represents knight piece from chess.
 * The knight has a set of 8 possible move sets, each having only one move in an L-shape.
 * The knight moves and captures along the same move set.
 */

public class KnightPiece extends ChessPiece {

	/**
	 * Constructor
	 */
	public KnightPiece(Color color, Position position, int boardWidth,
			int boardHeight) {
		super(color, position, boardWidth, boardHeight);
	}
	
	/**
	 * @see chessGame.ChessPiece#computePossibleMoveSpaces()
	 */
	public List<List<Position>> computePossibleMoveSpaces() 
	{
		return computeLshapedMoves();
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
		return getColor() == Color.WHITE ? "N" : "n";
	}

	/**
	 * @see chessGame.ChessPiece#getSymbolRepresentation()
	 */
	public ImageIcon getSymbolRepresentation() {
		return getColor() == Color.WHITE ? ChessImageIcons.WHITE_KNIGHT : ChessImageIcons.BLACK_KNIGHT;
	}
}
