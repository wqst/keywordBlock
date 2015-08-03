package pieces;
import chessGame.MyGame;

public class King {

	public static boolean kingMoveValid(int piecePosition, int movePosition) {
		
		System.out.println("This is king!!");
		//Forward
		if (piecePosition == (movePosition - 10)) {
			return isKingMoveValid(movePosition);
		}
		//Backward
		else if (piecePosition == (movePosition + 10)) {
			return isKingMoveValid(movePosition);
		}
		//right
		else if (piecePosition == (movePosition - 1)) {
			return isKingMoveValid(movePosition);
		}
		//Left
		else if (piecePosition == (movePosition + 1)) {
			return isKingMoveValid(movePosition);
		}
		//Backward left diagonal
		else if (piecePosition == (movePosition + 11)) {
			return isKingMoveValid(movePosition);
		}
		//Backward right diagonal
		else if (piecePosition == (movePosition + 9)) {
			return isKingMoveValid(movePosition);
		}
		//Forward left diagonal
		else if (piecePosition == (movePosition - 9)) {
			return isKingMoveValid(movePosition);
		}
		//Forward right diagonal
		else if (piecePosition == (movePosition - 11)) {
			return isKingMoveValid(movePosition);
		}
		// any other position
		else
			return false;
	}
	private static boolean isKingMoveValid(int movePosition) {
		if (MyGame.board[movePosition] / 10 == MyGame.currentPlayer)
			return false;
		else
			return true;
	}
	
	
}
