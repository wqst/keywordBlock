package chessGame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import chessGui.ChessImageIcons;


/**
 * Represents the Ferz fairy piece from chess.
 * The ferz moves like a bishop, but only one space in each direction.
 */

public class FerzPiece extends ChessPiece {

	/**
	 * Constructor
	 */
	public FerzPiece(Color color, Position position, int boardWidth,
			int boardHeight) {
		super(color, position, boardWidth, boardHeight);
	}

	@Override
	public List<List<Position>> computePossibleMoveSpaces() {
		List<List<Position>> possibleMoves = new ArrayList<List<Position>>();		
		
		addSingleMoveSet(possibleMoves, new Position(-1, -1));
		addSingleMoveSet(possibleMoves, new Position(1, 1));
		addSingleMoveSet(possibleMoves, new Position(1, -1));
		addSingleMoveSet(possibleMoves, new Position(-1, 1));
		
		return possibleMoves;
	}

	@Override
	public List<List<Position>> computePossibleCaptureSpaces() {
		return computePossibleMoveSpaces();
	}

	@Override
	public String toString() {
		return getColor() == Color.WHITE ? "F" : "U";
	}

	@Override
	public ImageIcon getSymbolRepresentation() {
		return getColor() == Color.WHITE ? ChessImageIcons.WHITE_FERZ : ChessImageIcons.BLACK_FERZ;
	}

}
