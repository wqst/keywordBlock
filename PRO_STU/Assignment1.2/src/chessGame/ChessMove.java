package chessGame;

public class ChessMove {
	ChessPiece movedPiece;
	ChessPiece capturedPiece;
	Position startPosition;
	Position endPosition;
	private MoveStatus moveStatus;
	
	/**
	 * Constructor
	 * @param movedPiece the piece that was moved
	 * @param capturedPiece the piece that was captured (null if no piece captured)
	 * @param startPosition the position this piece started at
	 * @param endPosition the position this piece moved to
	 * @param moveStatus the status of the move
	 */
	public ChessMove(ChessPiece movedPiece, ChessPiece capturedPiece, 
			Position startPosition, Position endPosition, MoveStatus moveStatus)
	{
		this.movedPiece = movedPiece;
		this.capturedPiece = capturedPiece;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		this.setMoveStatus(moveStatus);
	}
	
	public String toString()
	{
		return "(" + movedPiece + ", " + capturedPiece + ", " + 
				startPosition + ", " + endPosition + ", " + getMoveStatus() + ")";
	}

	public MoveStatus getMoveStatus() {
		return moveStatus;
	}

	public void setMoveStatus(MoveStatus moveStatus) {
		this.moveStatus = moveStatus;
	}
	
}
