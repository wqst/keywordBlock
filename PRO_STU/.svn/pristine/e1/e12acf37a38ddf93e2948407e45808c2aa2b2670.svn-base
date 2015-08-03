package chessGame;

import java.util.List;

import javax.swing.ImageIcon;

import chessGui.ChessImageIcons;


/**
 * Represents the queen piece from chess.
 * The queen piece moves and captures along any horizontal, vertical, or diagonal.
 */

public class QueenPiece extends ChessPiece {

	/**
	 * Constructor
	 */
	public QueenPiece(Color color, Position position, int boardWidth, int boardHeight) 
	{
		super(color, position, boardWidth, boardHeight);
	}

	/**
	 * @see chessGame.ChessPiece#computePossibleMoves()
	 */
	public List<List<Position>> computePossibleMoveSpaces() 
	{
		List<List<Position>> d, hv;
		d = this.computeDiagonalMoves();
		hv = this.computeHorizontalVerticalMoves();
		d.addAll(hv);
		
		return d;
	}

	/**
	 * @see chessGame.ChessPiece#computePossibleCaptureSpaces()
	 */
	public List<List<Position>> computePossibleCaptureSpaces() {
		return computePossibleMoveSpaces();
	}

	/**
	 * @see chessGame.ChessPiece#toString()
	 */
	public String toString() {
		return getColor() == Color.WHITE ? "Q" : "q";
	}	
	
	/**
	 * @see chessGame.ChessPiece#getSymbolRepresentation()
	 */
	public ImageIcon getSymbolRepresentation() {
		return getColor() == Color.WHITE ? ChessImageIcons.WHITE_QUEEN : ChessImageIcons.BLACK_QUEEN;
	}
}
