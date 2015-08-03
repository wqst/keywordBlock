package chessGame;

import java.util.List;

import javax.swing.ImageIcon;

import chessGui.ChessImageIcons;


/**
 * Represents archbishop fairy piece.
 * The archbishop moves and captures along the same routes as a knight and bishop.
 */

public class ArchBishopPiece extends ChessPiece{

	/**
	 * Constructor
	 */
	public ArchBishopPiece(Color color, Position position, int boardWidth,
			int boardHeight) {
		super(color, position, boardWidth, boardHeight);
	}

	@Override
	public List<List<Position>> computePossibleMoveSpaces() {
		List<List<Position>> diagonalMoves, lshapedMoves;
		diagonalMoves = computeDiagonalMoves();
		lshapedMoves = computeLshapedMoves();
		
		diagonalMoves.addAll(lshapedMoves);
		return diagonalMoves;
	}

	@Override
	public List<List<Position>> computePossibleCaptureSpaces() {
		return computePossibleMoveSpaces();
	}

	@Override
	public String toString() {
		return getColor() == Color.WHITE ? "A" : "Q";
	}

	@Override
	public ImageIcon getSymbolRepresentation() {
		return getColor() == Color.WHITE ? ChessImageIcons.WHITE_ARCHBISHOP : ChessImageIcons.BLACK_ARCHBISHOP;
	}

}
