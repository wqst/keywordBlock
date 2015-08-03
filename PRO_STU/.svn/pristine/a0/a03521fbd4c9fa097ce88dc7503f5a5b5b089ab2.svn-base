package chessGame;

/**
 * Represents the setup of a standard chess game, with all 32 pieces.
 */

public class StandardChessGame extends Empty8x8Game {
	
	/**
	 * Constructor
	 */
	public StandardChessGame() 
	{
		super();
		Position  bp, wp;
		
		// Generate pawns
		for (int x = 0; x < 8; x++)
		{
			bp = new Position(x, 6);
			wp = new Position(x, 1);
			
			addChessPieceToBoard(new PawnPiece(ChessPiece.Color.BLACK, bp, 8, 8));
			addChessPieceToBoard(new PawnPiece(ChessPiece.Color.WHITE, wp, 8, 8));
		}
		
//		// Fairy Pieces
//		bp = new Position(0, 6);
//		wp = new Position(0, 1);
//		addChessPieceToBoard(new FerzPiece(ChessPiece.Color.BLACK, bp, 8, 8));
//		addChessPieceToBoard(new ArchBishopPiece(ChessPiece.Color.WHITE, wp, 8, 8));
		
		// Generate rooks
		bp = new Position(0, 7);
		wp = new Position(0, 0);
		addChessPieceToBoard(new RookPiece(ChessPiece.Color.BLACK, bp, 8, 8));
		addChessPieceToBoard(new RookPiece(ChessPiece.Color.WHITE, wp, 8, 8));
		bp = new Position(7, 7);
		wp = new Position(7, 0);
		addChessPieceToBoard(new RookPiece(ChessPiece.Color.BLACK, bp, 8, 8));
		addChessPieceToBoard(new RookPiece(ChessPiece.Color.WHITE, wp, 8, 8));
		
		// Generate knights
		bp = new Position(1, 7);
		wp = new Position(1, 0);
		addChessPieceToBoard(new KnightPiece(ChessPiece.Color.BLACK, bp, 8, 8));
		addChessPieceToBoard(new KnightPiece(ChessPiece.Color.WHITE, wp, 8, 8));
		bp = new Position(6, 7);
		wp = new Position(6, 0);
		addChessPieceToBoard(new KnightPiece(ChessPiece.Color.BLACK, bp, 8, 8));
		addChessPieceToBoard(new KnightPiece(ChessPiece.Color.WHITE, wp, 8, 8));
		
		// Generate bishops
		bp = new Position(2, 7);
		wp = new Position(2, 0);
		addChessPieceToBoard(new BishopPiece(ChessPiece.Color.BLACK, bp, 8, 8));
		addChessPieceToBoard(new BishopPiece(ChessPiece.Color.WHITE, wp, 8, 8));
		bp = new Position(5, 7);
		wp = new Position(5, 0);
		addChessPieceToBoard(new BishopPiece(ChessPiece.Color.BLACK, bp, 8, 8));
		addChessPieceToBoard(new BishopPiece(ChessPiece.Color.WHITE, wp, 8, 8));
		
		// Generate queens
		bp = new Position(3, 7);
		wp = new Position(3, 0);
		addChessPieceToBoard(new QueenPiece(ChessPiece.Color.BLACK, bp, 8, 8));
		addChessPieceToBoard(new QueenPiece(ChessPiece.Color.WHITE, wp, 8, 8));
		
		// Generate kings
		bp = new Position(4, 7);
		wp = new Position(4, 0);
		addChessPieceToBoard(new KingPiece(ChessPiece.Color.BLACK, bp, 8, 8));
		addChessPieceToBoard(new KingPiece(ChessPiece.Color.WHITE, wp, 8, 8));
		
		computeAllCurrentPlayerMoves();
	}
}
