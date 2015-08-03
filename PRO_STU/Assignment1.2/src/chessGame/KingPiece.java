package chessGame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import chessGui.ChessImageIcons;


/**
 * Represents the king piece in chess.
 * The king may move and capture anywhere one space away from it.
 */

public class KingPiece extends ChessPiece {

	/**
	 * Construtor
	 */
	public KingPiece(Color color, Position position, int boardWidth,
			int boardHeight) {
		super(color, position, boardWidth, boardHeight);
	}

	/**
	 * @see chessGame.ChessPiece#computePossibleMoveSpaces()
	 */
	public List<List<Position>> computePossibleMoveSpaces() 
	{
		List<List<Position>> possibleMoveSpaces = new ArrayList<List<Position>>();		
		
		addSingleMoveSet(possibleMoveSpaces, new Position(1, 0));
		addSingleMoveSet(possibleMoveSpaces, new Position(-1, 0));
		addSingleMoveSet(possibleMoveSpaces, new Position(0, 1));
		addSingleMoveSet(possibleMoveSpaces, new Position(0, -1));
		addSingleMoveSet(possibleMoveSpaces, new Position(1, 1));
		addSingleMoveSet(possibleMoveSpaces, new Position(1, -1));
		addSingleMoveSet(possibleMoveSpaces, new Position(-1, 1));
		addSingleMoveSet(possibleMoveSpaces, new Position(-1, -1));
		
		return possibleMoveSpaces;
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
		return getColor() == Color.WHITE ? "K" : "k";
	}
	
	/**
	 * @see chessGame.ChessPiece#getSymbolRepresentation()
	 */
	public ImageIcon getSymbolRepresentation() {
		return getColor() == Color.WHITE ? ChessImageIcons.WHITE_KING : ChessImageIcons.BLACK_KING;
	}

}
