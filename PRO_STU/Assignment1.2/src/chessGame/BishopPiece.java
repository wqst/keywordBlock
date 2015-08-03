package chessGame;

import java.util.List;

import javax.swing.ImageIcon;

import chessGui.ChessImageIcons;


/**
 * Represents the bishop piece from check.
 * The bishop moves and captures along any diagonals.
 */

public class BishopPiece extends ChessPiece {

	public BishopPiece(Color color, Position position, int boardWidth,
			int boardHeight) {
		super(color, position, boardWidth, boardHeight);
	}

	@Override
	public List<List<Position>> computePossibleMoveSpaces() {
		return computeDiagonalMoves();
	}

	@Override
	public List<List<Position>> computePossibleCaptureSpaces() {
		return computePossibleMoveSpaces();
	}

	@Override
	public String toString() {
		return getColor() == Color.WHITE ? "B" : "b";
	}

	@Override
	public ImageIcon getSymbolRepresentation() {
		return getColor() == Color.WHITE ? ChessImageIcons.WHITE_BISHOP : ChessImageIcons.BLACK_BISHOP;
	}
	

}
