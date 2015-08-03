package pieces;
import chessGame.MyGame;


public class Knight {
	
	/*
	 * Check if the move position is valid for the knight
	 */
	public static boolean knightMoveValid(int piecePosition, int movePosition) {
		int leftBack = -12;
		int rightForward = 12;
		int backLeft = -21;
		int forwardRight = 21;
		int backRight = -19;
		int forwardLeft = 19;
		int leftForward = 8;
		int rightBack = -8;
		if (piecePosition == (movePosition + leftBack)) {
			return isKnightMoveValid(movePosition);
		}

		else if (piecePosition == (movePosition + rightForward)) {
			return isKnightMoveValid(movePosition);
		}
	
		else if (piecePosition == (movePosition + backLeft)) {
			return isKnightMoveValid(movePosition);
		}
	
		else if (piecePosition == (movePosition + forwardRight)) {
			return isKnightMoveValid(movePosition);
		}

		else if (piecePosition == (movePosition + backRight)) {
			return isKnightMoveValid(movePosition);
		}
	
		else if (piecePosition == (movePosition + forwardLeft)) {
			return isKnightMoveValid(movePosition);
		}
	
		else if (piecePosition == (movePosition + rightBack)) {
			return isKnightMoveValid(movePosition);
		}
	
		else if (piecePosition == (movePosition + leftForward)) {
			return isKnightMoveValid(movePosition);
		}
		else
			return false;
	}

	private static boolean isKnightMoveValid(int movePosition) {
		if (MyGame.board[movePosition] / 10 == MyGame.currentPlayer)
			return false;
		else
			return true;
	}
}
