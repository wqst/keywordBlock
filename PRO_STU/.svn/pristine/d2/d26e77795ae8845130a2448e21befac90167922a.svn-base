package chessGame;

import pieces.Pieces;

public class MoveExecute extends Pieces {
	// Execute the move
	public static void executeMove(int piecePosition, int movePosition) {
		System.out.println("Going to execute the Move!!!");

		// If the move-to position is 00 Update the board
		if (MyGame.board[movePosition] == MyGame.SQUARE) {
			MyGame.board[movePosition] = MyGame.board[piecePosition];
			MyGame.board[piecePosition] = 0;
			return;
		}

		// If there is an enemy at the move-to position Kill the enemy, update
		// the board
		else if (MyGame.board[movePosition] / 10 != MyGame.currentPlayer) {
			String enemy;
			// BLACK's piece is be killed
			if (MyGame.currentPlayer == MyGame.WHITE) {
				enemy = "BALCK";
				int possibleWinner = MyGame.WHITE_WIN;
				movePiece(piecePosition, movePosition, enemy, possibleWinner);

			}
			// WHITE's piece is be killed
			else if (MyGame.currentPlayer == MyGame.BLACK) {
				enemy = "WHITE";
				int possibleWinner = MyGame.BLACK_WIN;
				movePiece(piecePosition, movePosition, enemy, possibleWinner);
			}

			return;
		}
	}

	
	
	private static void movePiece(int piecePosition, int movePosition,
			String enemy, int possibleWinner) {
		String toPrint;
		if (MyGame.board[movePosition] % 10 == PAWN) {// pawn
			toPrint = enemy + "'s pawn is killed!";
			killEnemy(piecePosition, movePosition, toPrint);
		}
		else if (MyGame.board[movePosition] % 10 == KNIGHT) { // knight
			toPrint = enemy + "'s knight is killed!";
			killEnemy(piecePosition, movePosition, toPrint);
		}
		else if (MyGame.board[movePosition] % 10 == BISHOP) { // bishop
			toPrint = enemy + "'s bishop is killed!";
			killEnemy(piecePosition, movePosition, toPrint);
		}
		else if (MyGame.board[movePosition] % 10 == ROOK) { // rook
			toPrint = enemy + "'s rook is killed!";
			killEnemy(piecePosition, movePosition, toPrint);
		}
		else if (MyGame.board[movePosition] % 10 == QUEEN) { // queen
			toPrint = enemy + "'s queen is killed!";
			killEnemy(piecePosition, movePosition, toPrint);
		}
		else if (MyGame.board[movePosition] % 10 == ARCHBISHOP) { // Archbishop
			toPrint = enemy + "'s Archbishop is killed!";
			killEnemy(piecePosition, movePosition, toPrint);
		}
		else if (MyGame.board[movePosition] % 10 == CHANCELLOR) { // Chancellor
			toPrint = enemy + "'s Chancellor is killed!";
			killEnemy(piecePosition, movePosition, toPrint);
		}
		else if (MyGame.board[movePosition] % 10 == KING) { // king
			toPrint = enemy + "'s King is killed! ";
			killEnemy(piecePosition, movePosition, toPrint);
			MyGame.currentState = possibleWinner;
		}
	}

	private static void killEnemy(int piecePosition, int movePosition,
			String toPrint) {
		System.out.println(toPrint);
		MyGame.board[movePosition] = MyGame.board[piecePosition];
		MyGame.board[piecePosition] = 0;
		return;
	}
}
