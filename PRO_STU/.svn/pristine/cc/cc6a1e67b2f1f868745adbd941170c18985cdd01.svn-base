package chessGame;

/**
 * Wrapper class for 2D array representing the chess board.
 */

public class ChessBoard {
	private ChessPiece[][] board;	/** Chess board representation */
	
	/**
	 * Constructor
	 * Creates chess board with given width and height.
	 */
	public ChessBoard(int boardWidth, int boardHeight)
	{
		board = new ChessPiece[boardWidth][boardHeight];
	}
	
	/**
	 * Gets the piece at the the given position on board, null if there is no such piece.
	 * @param p the position to fetch from
	 * @return the piece that was at that square
	 */
	public ChessPiece get(Position p)
	{
		return board[p.getX()][p.getY()];
	}
	
	/**
	 * Places the given piece at that position
	 * @param p the position where we wish to place a piece
	 * @param c the piece we wish to place
	 */
	public void set(Position p, ChessPiece c){
		board[p.getX()][p.getY()] = c;
	}
	
	public boolean equals(Object that)
	{
		if (this.getClass() == that.getClass())
		{
			ChessBoard thatChessBoard = (ChessBoard) that;
			if (this.board.length == thatChessBoard.board.length)
			{
				for (int x = 0; x < board.length; x++)
					for (int y = 0; y < board.length; y++)
						if (!this.board[x][y].equals(thatChessBoard.board[x][y]))
							return false;
				return true;
			}					
		}
		return false;
	}
}
