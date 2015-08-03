package chessGame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import chessGui.ChessImageIcons;


/**
 * Represents the pawn piece from chess.
 * The pawn can only move in one direction - toward the opponent side.
 * The pawn can move only one space forward, or twice on their first move.
 * The pawn can capture diagonally forward.
 */

public class PawnPiece extends ChessPiece {
	int numMoves;	/**< The number of moves this piece has made - pawns can only move two squares during their first move. */

	/**
	 * Constructor
	 */
	public PawnPiece(Color color, Position position, int boardWidth,
			int boardHeight) {
		super(color, position, boardWidth, boardHeight);
		numMoves = 0;
	}

	/**
	 * @see chessGame.ChessPiece#computePossibleMoveSpaces()
	 */
	public List<List<Position>> computePossibleMoveSpaces() 
	{
		List<List<Position>> possibleMoveSpaces = new ArrayList<List<Position>>();		
		
		if (getColor() == Color.WHITE)	// White pawns always move up the board
		{
			if (numMoves == 0)
			{
				List<Position> singleMoveSet = new ArrayList<Position>();
				
				singleMoveSet.add(getPosition().addPositions(new Position(0, 1)));
				singleMoveSet.add(getPosition().addPositions(new Position(0, 2)));
				
				possibleMoveSpaces.add(singleMoveSet);
			}
			
			else
			{
				addSingleMoveSet(possibleMoveSpaces, new Position(0, 1));
			}
		}
		
		else	// Black pawns always move down the board
		{
			if (numMoves == 0)
			{
				List<Position> singleMoveSet = new ArrayList<Position>();
				
				singleMoveSet.add(getPosition().addPositions(new Position(0, -1)));
				singleMoveSet.add(getPosition().addPositions(new Position(0, -2)));
				
				possibleMoveSpaces.add(singleMoveSet);
			}
			
			else
			{
				addSingleMoveSet(possibleMoveSpaces, new Position(0, -1));
			}
		}
		
		return possibleMoveSpaces;
	}

	/**
	 * @see chessGame.ChessPiece#computePossibleCaptureSpaces()
	 */
	public List<List<Position>> computePossibleCaptureSpaces() 
	{
		List<List<Position>> possibleCaptureSpaces = new ArrayList<List<Position>>();
		
		if (getColor() == Color.WHITE)	// White pawns always move up the board
		{
			addSingleMoveSet(possibleCaptureSpaces, new Position(1, 1));
			addSingleMoveSet(possibleCaptureSpaces, new Position(-1, 1));
		}
		
		else	// Black pawns always move down the board
		{
			addSingleMoveSet(possibleCaptureSpaces, new Position(1, -1));
			addSingleMoveSet(possibleCaptureSpaces, new Position(-1, -1));
		}
		
		return possibleCaptureSpaces;
	}
	
	public boolean equals(Object that)
	{
		if (this.getClass() == that.getClass())
		{
			PawnPiece thatChessPiece = (PawnPiece) that;
			return this.position.equals(thatChessPiece.position) &&
					this.color == thatChessPiece.color &&
					this.numMoves == thatChessPiece.numMoves;
		}
		
		return false;
	}

	/**
	 * @see chessGame.ChessPiece#toString()
	 */
	public String toString() {
		return getColor() == Color.WHITE ? "P" : "p";
	}
	
	/**
	 * @see chessGame.ChessPiece#getSymbolRepresentation()
	 */
	public ImageIcon getSymbolRepresentation() {
		return getColor() == Color.WHITE ? ChessImageIcons.WHITE_PAWN : ChessImageIcons.BLACK_PAWN;

	}

}
