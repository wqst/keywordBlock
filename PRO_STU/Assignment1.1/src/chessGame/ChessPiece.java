package chessGame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


/**
 * Template class for all other chess pieces.
 */

public abstract class ChessPiece {

	/**
	 * Color enum to differentiate between opposing players and their pieces.
	 */
	public enum Color {
		BLACK,	/**< Enum value BLACK. */
		WHITE	/**< Enum value WHITE. */
	};
	
	protected Position position;	/**< Current position of the piece on the board. */
	protected List<Position> legalMoves;	/**< List of legal moves this piece can make. Handed down from ChessGame. */
	protected final Color color;	/**< Piece color. */
	protected final int boardWidth, boardHeight;	/**< Board width and height. */
	
	/**
	 * Constructor.
	 * Generates the piece at the given position and initializes legal moves.
	 */
	public ChessPiece(Color color, Position position, int boardWidth, int boardHeight)
	{
		this.color = color;
		this.setPosition(position);
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.legalMoves = new ArrayList<Position>();
	}
	
	/**
	 * Checks if the next position will fall on the board.
	 * @param currentPosition the position to move to
	 * @return whether this next position falls on the board
	 */
	public boolean isValidPosition(Position currentPosition)
	{
		return currentPosition.getX() >= 0 && currentPosition.getX() < boardWidth &&
				currentPosition.getY() >= 0 && currentPosition.getY() < boardHeight;
	}
	
	/**
	 * Given a position, direction, and list of steps already taken,
	 * Recursively compute the list of steps this piece can take
	 * Until it reaches the edge of the board.
	 * @param currentPosition the current position taken in the recursive step
	 * @param stepSize vector in position form determining where to move next
	 * @param stepList list of possible steps generated thus far
	 * @return a list of valid steps in that direction that reach the edge of the board
	 */
	public List<Position> computePossibleSteps(Position currentPosition, Position stepSize, List<Position> stepList)
	{
		currentPosition = currentPosition.addPositions(stepSize);
		
		if (!isValidPosition(currentPosition))
			return stepList;
		else
		{
			stepList.add(currentPosition);
			return computePossibleSteps(currentPosition, stepSize, stepList);
		}
	}

	/**
	 * Computes possible diagonal moves this piece can make (ignoring other pieces).
	 * @return list of diagonal moves this piece can make
	 */
	public List<List<Position>> computeDiagonalMoves()
	{
		List<List<Position>> diagonalMoves = new ArrayList<List<Position>>();
		
		diagonalMoves.add(computePossibleSteps(getPosition(), new Position(1, 1), new ArrayList<Position>()));
		diagonalMoves.add(computePossibleSteps(getPosition(), new Position(-1, -1), new ArrayList<Position>()));
		diagonalMoves.add(computePossibleSteps(getPosition(), new Position(-1, 1), new ArrayList<Position>()));
		diagonalMoves.add(computePossibleSteps(getPosition(), new Position(1, -1), new ArrayList<Position>()));
		
		return diagonalMoves;
	}
	
	/**
	 * Computes possible horizontal and vertical moves this piece can make (ignoring other pieces).
	 * @return list of possible horizontal and vertical moves this piece can make
	 */
	public List<List<Position>> computeHorizontalVerticalMoves()
	{
		List<List<Position>> horizontalVerticalMoves = new ArrayList<List<Position>>();
		
		horizontalVerticalMoves.add(computePossibleSteps(getPosition(), new Position(0, 1), new ArrayList<Position>()));
		horizontalVerticalMoves.add(computePossibleSteps(getPosition(), new Position(1, 0), new ArrayList<Position>()));
		horizontalVerticalMoves.add(computePossibleSteps(getPosition(), new Position(0, -1), new ArrayList<Position>()));
		horizontalVerticalMoves.add(computePossibleSteps(getPosition(), new Position(-1, 0), new ArrayList<Position>()));
		
		return horizontalVerticalMoves;
	}
	
	/**
	 * Computes the possible L-shaped moves that this piece can make (ignoring other pieces).
	 * @return the list of L-shaped moves
	 */
	public List<List<Position>> computeLshapedMoves() 
	{
		List<List<Position>> computeLshapedMoves = new ArrayList<List<Position>>();		
		
		addSingleMoveSet(computeLshapedMoves, new Position(2, 1));
		addSingleMoveSet(computeLshapedMoves, new Position(1, 2));
		addSingleMoveSet(computeLshapedMoves, new Position(2, -1));
		addSingleMoveSet(computeLshapedMoves, new Position(-1, 2));
		addSingleMoveSet(computeLshapedMoves, new Position(-2, 1));
		addSingleMoveSet(computeLshapedMoves, new Position(1, -2));
		addSingleMoveSet(computeLshapedMoves, new Position(-2, -1));
		addSingleMoveSet(computeLshapedMoves, new Position(-1, -2));
		
		return computeLshapedMoves;
	}
	
	/**
	 * Adds a single move to the possible-moves set if it falls on the board.
	 * @param possibleMoveSpaces the list of move sets we want to add the new move to
	 * @param move the new move we wish to add
	 * @return whether the move was successfully added to the move set or not
	 */
	public boolean addSingleMoveSet(List<List<Position>> possibleMoveSpaces, Position move)
	{
		Position possibleMove = getPosition().addPositions(move);
		
		if (!isValidPosition(possibleMove))
			return false;
		
		List<Position> singleMoveSet = new ArrayList<Position>();
		singleMoveSet.add(possibleMove);
		possibleMoveSpaces.add(singleMoveSet);
		
		return true;
	}
	
	/**
	 * To be implemented in extended chess pieces:
	 * Computes the possible spaces this type of piece can move to (ignoring other pieces).
	 * @return list of possible movements this piece can make without capturing
	 */
	public abstract List<List<Position>> computePossibleMoveSpaces();
	
	/**
	 * To be implemented in extended chess pieces:
	 * Computes the possible spaces this type of piece can move to capture another piece on (ignoring other pieces).
	 * @return list of possible capture moves this piece can make
	 */
	public abstract List<List<Position>> computePossibleCaptureSpaces();
	
	/**
	 * To be implemented in extended chess pieces:
	 * Returns the corresponding letter symbol for this piece - useful for unit tests.
	 * @return the string representation of the piece.\
	 */
	public abstract String toString();
	
	/**
	 * To be implemented in extended chess pieces:
	 * Returns the corresponding picture symbol for this piece - useful for chess diagrams.
	 * @return the symbol representation of the piece
	 */
	public abstract ImageIcon getSymbolRepresentation();

	public boolean equals(Object that)
	{
		if (this.getClass() == that.getClass())
		{
			ChessPiece thatChessPiece = (ChessPiece) that;
			return this.position.equals(thatChessPiece.position) &&
					this.color == thatChessPiece.color;
		}
		
		return false;
	}
	
	public List<Position> getLegalMoves() {
		return legalMoves;
	}

	public void setLegalMoves(List<Position> legalMoves) {
		this.legalMoves = legalMoves;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Color getColor() {
		return color;
	}
}
