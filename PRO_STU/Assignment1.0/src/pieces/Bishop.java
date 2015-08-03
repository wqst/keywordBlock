package pieces;
import chessGame.MyGame;

public class Bishop {
	
	public static boolean bishopMoveValid(int piecePosition, int movePosition) {
		
		int j;
		//Forward left
		if ((movePosition - piecePosition) > 0
				&& (movePosition - piecePosition) % 9 == MyGame.SQUARE) {
			j = 9;
			return bishopMoveValid(piecePosition, movePosition, j);
		}
		//Forward right
		else if ((movePosition - piecePosition) > 0
				&& (movePosition - piecePosition) % 11 == MyGame.SQUARE) {
			j = 11;
			return bishopMoveValid(piecePosition, movePosition, j);
		}
		//Backward left
		else if ((piecePosition - movePosition) > 0
				&& (piecePosition - movePosition) % 11 == MyGame.SQUARE) {
			j = -11;
			return bishopMoveValid(piecePosition, movePosition, j);
		}
		//Backward right
		else if ((piecePosition - movePosition) > 0
				&& (piecePosition - movePosition) % 9 == MyGame.SQUARE) {
			j = -9;
			return bishopMoveValid(piecePosition, movePosition, j);
		}
		//Any other move should be invalid
		else
			return false;
	}

	
	
	
	private static boolean bishopMoveValid(int piecePosition, int movePosition, int j) {
		int numDiagonal;
		int checkPosition;
		numDiagonal = (movePosition - piecePosition) / j;
		checkPosition = piecePosition;
		for (int i = 1; i < numDiagonal; i++) {
			checkPosition = checkPosition + j;
			if (MyGame.board[checkPosition] != MyGame.SQUARE) 
				return false;
		}
		return checkBishopLastStep(movePosition);
	}

	private static boolean checkBishopLastStep(int movePosition) {
		if (MyGame.board[movePosition] / 10 == MyGame.currentPlayer) { 
			return false;
		} else
			return true;
	}
	
	
}
