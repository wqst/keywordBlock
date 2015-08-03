package chessGame;

import java.util.ArrayList;
import java.util.List;

import chessGame.ChessPiece.Color;

/**
 * Template class for representing a chess game, including all pieces, the board, and winning conditions.
 */

public abstract class ChessGame {
	protected ChessBoard chessBoard;	/** The chess board. */
	protected List<ChessPiece> whitePieces, blackPieces;	/** The set of pieces for each player. */
	protected final int boardWidth, boardHeight;	/** Board width and height. */
	protected ChessPiece.Color currentPlayer;	/** Who's turn it currently is. */
	
	/**
	 * Constructor.
	 * Creates chess board with given width and height while initializing the player piece lists and setting first turn to white.
	 */
	public ChessGame(int boardWidth, int boardHeight)
	{
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.setChessBoard(new ChessBoard(boardWidth, boardHeight));
				
		this.whitePieces = new ArrayList<ChessPiece>();
		this.blackPieces = new ArrayList<ChessPiece>();
		this.setCurrentPlayer(ChessPiece.Color.WHITE);
	}
	
	/**
	 * Fetches the piece at the given square.
	 * @param p the position of the square
	 * @return the chess piece located there
	 */
	public ChessPiece getChessPieceFromSquare(Position p)
	{
		return chessBoard.get(p);
	}
	
	/**
	 * Fetches the piece list of the given player.
	 * @param playerColor the player color
	 * @return the corresponding piece list
	 */
	public List<ChessPiece> getGivenPlayerPieces(ChessPiece.Color playerColor)
	{
		return playerColor == ChessPiece.Color.WHITE ? whitePieces : blackPieces;
	}
	
	/**
	 * Switch player turns.
	 */
	public void switchPlayerTurn()
	{	
		setCurrentPlayer((getCurrentPlayer() == ChessPiece.Color.WHITE ? 
				ChessPiece.Color.BLACK : ChessPiece.Color.WHITE));		
	}
	
	/**
	 * Adds a chess piece to the board as specified by its internal position.
	 * @param newPiece the piece to be added to board
	 * @throws IllegalArgumentException if the piece does not fall on board
	 * @throws IllegalArgumentException if the space is already taken
	 */
	public void addChessPieceToBoard(ChessPiece newPiece)
	{
		if (!newPiece.isValidPosition(newPiece.getPosition()))
			throw new IllegalArgumentException("Error: Piece does not fall on board.");
		
		if (getChessBoard().get(newPiece.getPosition()) != null)
			throw new IllegalArgumentException("Error: Space is already taken.");
		
		getChessBoard().set(newPiece.getPosition(), newPiece);
		List<ChessPiece> pieceSet = getGivenPlayerPieces(newPiece.getColor());
		pieceSet.add(newPiece);
	}
	
	/**
	 * Compute legal moves for all pieces owned by the current player.
	 * Return if any such moves place the opponent king in check.
	 * (with a possibility of check mate).
	 * @return whether the opponent is currently in check or not
	 */
	public boolean computeAllCurrentPlayerMoves()
	{
		boolean foundPossibleCheckmate = false;
		List<ChessPiece> pieceSet = getGivenPlayerPieces(getCurrentPlayer());
		
		for (ChessPiece chessPiece : pieceSet)
		{
			chessPiece.setLegalMoves(new ArrayList<Position>());
			computeLegalMoves(chessPiece);
			foundPossibleCheckmate = foundPossibleCheckmate || computeLegalCaptures(chessPiece);
		}
		
		return foundPossibleCheckmate;
	}
	
	/**
	 * Compute and stores legal captures for current piece.
	 * Return if any such captures place the opponent king in check.
	 * (with a possibility of check mate).
	 * @param currentPiece the piece to compute all legal captures on
	 * @return whether this piece puts the opponent in check or not
	 */
	public boolean computeLegalCaptures(ChessPiece currentPiece)
	{
		boolean foundPossibleCheckmate = false;
		
		List<Position> currentLegalCaptures = new ArrayList<Position>();
		
		for (List<Position> singleMoveSet : currentPiece.computePossibleCaptureSpaces())
			for (Position currentMove : singleMoveSet)
			{
				ChessPiece otherPiece = getChessBoard().get(currentMove);
				
				if (otherPiece == null)	// No piece to capture on this space
					continue;
				
				else if (currentPiece.getColor() == otherPiece.getColor())	// Cannot capture a same-color piece
					break;
				
				else	// Piece can be captured
				{		
					if (otherPiece instanceof KingPiece)
						foundPossibleCheckmate = true;
					
					currentLegalCaptures.add(currentMove);
					break;
				}
			}
		
		currentPiece.getLegalMoves().addAll(currentLegalCaptures);
		return foundPossibleCheckmate;
	}
	
	/**
	 * Compute and stores legal moves for the current piece, excluding capture moves.
	 * @param currentPiece the piece to compute all legal moves for
	 */
	public void computeLegalMoves(ChessPiece currentPiece)
	{
		List<Position> currentLegalMoves = new ArrayList<Position>();
		
		for (List<Position> singleMoveSet : currentPiece.computePossibleMoveSpaces())
			for (Position currentMove : singleMoveSet)
			{
				if (getChessBoard().get(currentMove) != null)	// Space is already occupied by another piece
					break;
				
				currentLegalMoves.add(currentMove);
			}
		
		currentPiece.getLegalMoves().addAll(currentLegalMoves);
	}
	
	/**
	 * Selects a current square and a square to move to.
	 * Ensures that the inputs forms a legal move - if it is, carry out the move.
	 * If move places opponents in check, investigates if this is check mate.
	 * Switches player turns after all actions complete.
	 * @param currentPosition the position of the piece to be moved
	 * @param nextPosition the position the piece should be moved to
	 * @throws IllegalArgumentException if empty space is selected
	 * @throws IllegalArgumentExcpetion if opponent piece is selected
	 * @throws IllegalArgumentExcpetion if the attempted move is not legal
	 */
	public ChessMove movePiece(Position currentPosition, Position nextPosition)
	{		
		ChessPiece currentPiece = getChessBoard().get(currentPosition);
		
		// Check if space with piece was selected
		if (currentPiece == null)
			throw new IllegalArgumentException("Error: selected empty space.");
		
		// Check to make sure current piece is right color
		if (currentPiece.getColor() != getCurrentPlayer())
			throw new IllegalArgumentException("Error: selected opponent's piece at " + currentPosition.toString());
		
		// Check if next position is a legal move
		boolean isLegalMove = false;
		for (Position movePosition : currentPiece.getLegalMoves())
			if (nextPosition.equals(movePosition))
				isLegalMove = true;
		
		if (!isLegalMove)
			return new ChessMove(null, null, null, null, MoveStatus.ILLEGAL_MOVE);
		
		// All conditions met - go ahead and move this piece
		ChessPiece capturedPiece = movePieceLegally(currentPiece, nextPosition);
		ChessMove nextMove = new ChessMove(currentPiece, capturedPiece, currentPosition, nextPosition, MoveStatus.NORMAL_MOVE);
		
		// Move made places opponent in check - this might be a check mate
		if (computeAllCurrentPlayerMoves())
		{
			nextMove.setMoveStatus(MoveStatus.CHECK);
			if (isOpponentInCheckmate())
				nextMove.setMoveStatus(MoveStatus.CHECK_MATE);
		}
		
		switchPlayerTurn();
		System.out.println("PLAYER MOVED!");
		
		// Last move puts you in check
		if (computeAllCurrentPlayerMoves())
		{
			undoLegalMove(nextMove);
			return new ChessMove(null, null, null, null, MoveStatus.ILLEGAL_MOVE);
		}
		
		return nextMove;
	}
	
	/**
	 * Determines if destination piece will move to will capture an opponent piece.
	 * If it does remove the piece from board and return it.
	 * Else return null, indicating no piece was captured.
	 * @param newPosition the position to make move to
	 * @return the chess piece that was captured, null if no chess piece was captured
	 */
	public ChessPiece removeCapturedPieceFromBoard(Position newPosition)
	{
		ChessPiece capturedPiece = getChessBoard().get(newPosition);
		
		if (capturedPiece != null)
		{			
			if (capturedPiece.getColor() == ChessPiece.Color.WHITE)
				whitePieces.remove(whitePieces.indexOf(capturedPiece));
			
			else
				blackPieces.remove(blackPieces.indexOf(capturedPiece));		
		}
		
		return capturedPiece;
	}
	
	/**
	 * Takes a chess piece and legal move and executes them.
	 * Assumes that both inputs are legal.
	 * Returns a piece if move captured it, or null if this move did not capture anything.
	 * @param currentPosition the position of the piece to be moved
	 * @param nextPosition the position the piece should be moved to
	 * @return the chess piece that was captured, null if no chess piece was captured
	 */
	public ChessPiece movePieceLegally(ChessPiece currentPiece, Position nextPosition)
	{
		ChessPiece capturedPiece = removeCapturedPieceFromBoard(nextPosition);
		
		getChessBoard().set(currentPiece.getPosition(), null);
		currentPiece.setPosition(nextPosition);
		getChessBoard().set(nextPosition, currentPiece);
				
		if (currentPiece instanceof PawnPiece)
			((PawnPiece) currentPiece).numMoves++;
		
		return capturedPiece;
	}
	
	/**
	 * Undo's the given move.
	 * Assumes that the given move was the most recent move performed.
	 * Does not bring back a piece lost during capture moves.
	 * @param the piece whose move we wish to undo
	 * @param the position this piece was last at
	 */
	public void undoGivenMove(ChessPiece currentPiece, Position lastPosition)
	{
		getChessBoard().set(currentPiece.getPosition(), null);
		currentPiece.setPosition(lastPosition);
		getChessBoard().set(lastPosition, currentPiece);
		
		if (currentPiece instanceof PawnPiece)
			((PawnPiece) currentPiece).numMoves--;
	}
	
	/**
	 * Once check is discovered,
	 * Determine if this move constitutes a check mate.
	 * Algorithm:
	 * Switch to opponent player and simulate every move they can make.
	 * If no move they make gets them out of check, this is a check mate.
	 * @return whether the opponent in is checkmate or not.
	 */
	public boolean isOpponentInCheckmate()
	{
		boolean foundAllCheckmates = true;
		
		switchPlayerTurn();	// Start simulation of opponent moves
		List<ChessPiece> currentPlayerPieces = getGivenPlayerPieces(getCurrentPlayer());
		computeAllCurrentPlayerMoves();
		
		for (ChessPiece currentPiece : currentPlayerPieces)
		{
			Position lastPosition = currentPiece.getPosition();
			
			for (Position currentMove : currentPiece.getLegalMoves())
			{
				ChessPiece capturedPiece = movePieceLegally(currentPiece, currentMove);
				switchPlayerTurn();	// Start simulation of response to opponent moves
				
				foundAllCheckmates = foundAllCheckmates && computeAllCurrentPlayerMoves();

				switchPlayerTurn();	// End simulation of response to opponent moves
				undoGivenMove(currentPiece, lastPosition);
				if (capturedPiece != null)
					addChessPieceToBoard(capturedPiece);
			}
		}
		
		switchPlayerTurn();	// End simulation of opponent moves
		return foundAllCheckmates;
	}

	/**
	 * Undoes last legal move
	 * @param lastMove the chess move to undo
	 */
	public void undoLegalMove(ChessMove lastMove) {
		ChessPiece movedPiece = lastMove.movedPiece;
		ChessPiece capturedPiece = lastMove.capturedPiece;
		Position startPosition = lastMove.startPosition;
		Position endPosition = lastMove.endPosition;
		
		movedPiece.position = startPosition;
		chessBoard.set(startPosition, movedPiece);
		
		// Reset pawn counter
		if (movedPiece instanceof PawnPiece)
			((PawnPiece) movedPiece).numMoves--;
		
		// Reset other piece position
		if (capturedPiece != null)
		{
			capturedPiece.position = endPosition;
			if (capturedPiece.getColor() == Color.WHITE)
				whitePieces.add(capturedPiece);
			else
				blackPieces.add(capturedPiece);
		}
		
		chessBoard.set(endPosition, capturedPiece);
		
		switchPlayerTurn();
		computeAllCurrentPlayerMoves();
	}
	
	public boolean equals(Object that)
	{
		if (this.getClass() == that.getClass())
		{
			ChessGame thatChessGame = (ChessGame) that;
			
			for (ChessPiece piece : this.whitePieces)
				if (thatChessGame.whitePieces.indexOf(piece) < 0)
					return false;
			
			for (ChessPiece piece : this.blackPieces)
				if (thatChessGame.blackPieces.indexOf(piece) < 0)
					return false;
			
			return this.chessBoard.equals(thatChessGame.chessBoard) &&
					this.currentPlayer == thatChessGame.currentPlayer;
		}
		
		return false;
	}
	
	public ChessBoard getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

	public ChessPiece.Color getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(ChessPiece.Color currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

}
