package pieces;
import chessGame.MyGame;

public class Pawn {
	
	/*
	 * Check if the move position is valid for a pawn
	 */
	public static boolean pawnMoveValid(int piecePosition, int movePosition) {
	System.out.println("This is pawn!!");

	if (MyGame.currentPlayer == MyGame.WHITE) {
		int forward = 10;
		int rDiagonal = 9;
		int lDiagonal = 11;
		int enemyColor = MyGame.BLACK;
		return pawnMoveValid(piecePosition, movePosition, forward, rDiagonal,
				lDiagonal, enemyColor);
	}

	else if (MyGame.currentPlayer == MyGame.BLACK) {
		int forward = -10;
		int rDiagonal = -9;
		int lDiagonal = -11;
		int enemyColor = MyGame.WHITE;
		return pawnMoveValid(piecePosition, movePosition, forward, rDiagonal,
				lDiagonal, enemyColor);
	}
	return false;
	}

	
	/*
	 * Check if the move position is valid for a pawn.
	 */
	private static boolean pawnMoveValid(int piecePosition, int movePosition,
			int forward, int rDiagonal, int lDiagonal, int enemyColor) {
		if (piecePosition == (movePosition + forward)) {		// move straight one step
			if (MyGame.board[movePosition] == MyGame.SQUARE) {		
				return true;
			}
			else				// there is a piece on the movePosition
				return false;
		}
		else if (piecePosition == (movePosition + rDiagonal)) {		// move right diagonal only if there is an enemy
			if (MyGame.board[movePosition] / 10 == enemyColor) {		// there is an enemy
				return true;
			} else
				return false;
		}
		else if (piecePosition == (movePosition + lDiagonal)) {		// move left diagonal only if there is an enemy
			if (MyGame.board[movePosition] / 10 == enemyColor)
				return true;
			else
				return false;
		}
		else			// any other move is invalid
			return false;
	}
}
