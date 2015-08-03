package pieces;
import chessGame.MyGame;


public class Rook {

	public static boolean rookMoveValid(int piecePosition, int movePosition) {
		int j;
		//Forward
		if ((movePosition - piecePosition) > 0
				&& (movePosition - piecePosition) % 10 == MyGame.SQUARE) {
			j = 10;
			return multiFBMove(piecePosition, movePosition, j);
		}
		//Backward
		else if ((piecePosition - movePosition) > 0
				&& (piecePosition - movePosition) % 10 == MyGame.SQUARE) {
			j = -10;
			return multiFBMove(piecePosition, movePosition, j);
		}
		//Left
		else if ((piecePosition - movePosition) > 0
				&& (piecePosition - movePosition) <= 7) {
			j = -1;
			return mutilLRMove(piecePosition, movePosition, j);
		}
		//Right
		else if ((movePosition - piecePosition) > 0
				&& (movePosition - piecePosition) <= 7) {
			j = 1;
			return mutilLRMove(piecePosition, movePosition, j);
		}
		//Any other move should be invalid
		else
			return false;
	}

	
	
	
	
	private static boolean mutilLRMove(int piecePosition, int movePosition,
			int j) {
		int checkPosition;
		checkPosition = piecePosition;
		for (int i = 1; i < (piecePosition - movePosition); i++) {
			checkPosition = checkPosition + j;
			if (MyGame.board[checkPosition] != MyGame.SQUARE)
				return false;
		}
		if (MyGame.board[movePosition] / 10 == MyGame.currentPlayer) {
			return false;
		} else if (MyGame.board[movePosition] == MyGame.EDGE) { 											
			return false;
		} else
			return true;
	}

	private static boolean multiFBMove(int piecePosition, int movePosition, int j) {
		int numSteps;
		int checkPosition;
		numSteps = (movePosition - piecePosition) / j;
		checkPosition = piecePosition;
		for (int i = 1; i < numSteps; i++) {
			checkPosition = checkPosition + j;
			if (MyGame.board[checkPosition] != MyGame.SQUARE)
				return false;
		}
		if (MyGame.board[movePosition] / 10 == MyGame.currentPlayer) {
			return false;
		} else
			return true;
	}


}
