package chessGame;

import pieces.Pieces;

public class ConditionCheck {
	public static boolean isChecked() {
		// find the position of the king
		int kingPosition = 0;

		for (int i = 11; i < 89; i++) {
			if ((MyGame.board[i] / 10 == MyGame.currentPlayer)
					&& (MyGame.board[i] % 10 == Pieces.KING)) {
				kingPosition = i;
				break;
			}
		}
		
		// knight, Archbishop, Chancellor
		int i;
		i = -21;
		if ((kingPosition - 21) >= 0
				&& isKAC(kingPosition, i)
				&& MyGame.board[kingPosition + i] / 10 != MyGame.currentPlayer) {
			return true;
		}
		i = 21;
		if ((kingPosition + 21) < 100
				&& isKAC(kingPosition, i)
				&& MyGame.board[kingPosition + i] / 10 != MyGame.currentPlayer) {
			return true;
		}
		i = -19;
		if ((kingPosition - 19) >= 0
				&& isKAC(kingPosition, i)
				&& MyGame.board[kingPosition + i] / 10 != MyGame.currentPlayer) {
			return true;
		}
		i = 19;
		if ((kingPosition + 19) < 100
				&& isKAC(kingPosition, i)
				&& MyGame.board[kingPosition + i] / 10 != MyGame.currentPlayer) {
			return true;
		}
		i = -8;
		if (isKAC(kingPosition, i)
				&& MyGame.board[kingPosition + i] / 10 != MyGame.currentPlayer) {
			return true;
		}
		i = 8;
		if (isKAC(kingPosition, i)
				&& MyGame.board[kingPosition + i] / 10 != MyGame.currentPlayer) {
			return true;
		}
		i = -12;
		if ((kingPosition - 12) >= 0
				&& isKAC(kingPosition, i)
				&& MyGame.board[kingPosition + i] / 10 != MyGame.currentPlayer) {
			return true;
		}
		i = 12;
		if ((kingPosition + 12) < 100
				&& isKAC(kingPosition, i)
				&& MyGame.board[kingPosition + i] / 10 != MyGame.currentPlayer) {
			return true;
		}

		// bishop, queen, archbishop
		int checkPosition = kingPosition;
		boolean done = false;
		do {
			checkPosition -= 9;
			// touch the edge
			if (MyGame.board[checkPosition] == MyGame.EDGE)
				done = true;
			else if (MyGame.board[checkPosition] / 10 == MyGame.currentPlayer)
				done = true;
			else if (MyGame.board[checkPosition] == MyGame.SQUARE)
				continue;
			else if (isBQA(checkPosition))
				return true;
			else
				done = true;
		} while (!done);

		checkPosition = kingPosition;
		done = false;
		do {
			checkPosition += 9;
			// touch the edge
			if (MyGame.board[checkPosition] == MyGame.EDGE)
				done = true;
			else if (MyGame.board[checkPosition] / 10 == MyGame.currentPlayer)
				done = true;
			else if (MyGame.board[checkPosition] == MyGame.SQUARE)
				continue;
			else if (isBQA(checkPosition))
				return true;
			else
				done = true;
		} while (!done);

		checkPosition = kingPosition;
		done = false;
		do {
			checkPosition -= 11;
			// touch the edge
			if (MyGame.board[checkPosition] == MyGame.EDGE)
				done = true;
			else if (MyGame.board[checkPosition] / 10 == MyGame.currentPlayer)
				done = true;
			else if (MyGame.board[checkPosition] == MyGame.SQUARE)
				continue;
			else if (isBQA(checkPosition))
				return true;
			else
				done = true;
		} while (!done);

		checkPosition = kingPosition;
		done = false;
		do {
			checkPosition += 11;
			// touch the edge
			if (MyGame.board[checkPosition] == MyGame.EDGE)
				done = true;
			else if (MyGame.board[checkPosition] / 10 == MyGame.currentPlayer)
				done = true;
			else if (MyGame.board[checkPosition] == MyGame.SQUARE)
				continue;
			else if (isBQA(checkPosition))
				return true;
			else
				done = true;
		} while (!done);

		// rook, queen, chancellor
		checkPosition = kingPosition;
		done = false;
		do {
			checkPosition -= 10;
			// touch the edge
			if (MyGame.board[checkPosition] == MyGame.EDGE)
				done = true;
			else if (MyGame.board[checkPosition] / 10 == MyGame.currentPlayer)
				done = true;
			else if (MyGame.board[checkPosition] == MyGame.SQUARE)
				continue;
			else if (isRQC(checkPosition))
				return true;
			else
				done = true;
		} while (!done);

		checkPosition = kingPosition;
		done = false;
		do {
			checkPosition += 10;
			// touch the edge
			if (MyGame.board[checkPosition] == MyGame.EDGE)
				done = true;
			else if (MyGame.board[checkPosition] / 10 == MyGame.currentPlayer)
				done = true;
			else if (MyGame.board[checkPosition] == MyGame.SQUARE)
				continue;
			else if (isRQC(checkPosition))
				return true;
			else
				done = true;
		} while (!done);

		checkPosition = kingPosition;
		done = false;
		do {
			checkPosition -= 1;
			// touch the edge
			if (MyGame.board[checkPosition] == MyGame.EDGE)
				done = true;
			else if (MyGame.board[checkPosition] / 10 == MyGame.currentPlayer)
				done = true;
			else if (MyGame.board[checkPosition] == MyGame.SQUARE)
				continue;
			else if (isRQC(checkPosition))
				return true;
			else
				done = true;
		} while (!done);

		checkPosition = kingPosition;
		done = false;
		do {
			checkPosition += 1;
			// touch the edge
			if (MyGame.board[checkPosition] == MyGame.EDGE)
				done = true;
			else if (MyGame.board[checkPosition] / 10 == MyGame.currentPlayer)
				done = true;
			else if (MyGame.board[checkPosition] == MyGame.SQUARE)
				continue;
			else if (isRQC(checkPosition))
				return true;
			else
				done = true;
		} while (!done);

		// pawn
		if (MyGame.currentPlayer == MyGame.WHITE) {
			if (MyGame.board[kingPosition - 11] % 10 == Pieces.PAWN
					&& MyGame.board[kingPosition - 11] / 10 == MyGame.BLACK)
				return true;

			if (MyGame.board[kingPosition - 9] % 10 == Pieces.PAWN
					&& MyGame.board[kingPosition - 9] / 10 == MyGame.BLACK)
				return true;
		} else {
			if (MyGame.board[kingPosition + 11] % 10 == Pieces.PAWN
					&& MyGame.board[kingPosition + 11] / 10 == MyGame.WHITE)
				return true;

			if (MyGame.board[kingPosition + 9] % 10 == Pieces.PAWN
					&& MyGame.board[kingPosition + 9] / 10 == MyGame.WHITE)
				return true;

		}
		// king
		if (MyGame.board[kingPosition + 1] % 10 == Pieces.KING)
			return true;
		if (MyGame.board[kingPosition - 1] % 10 == Pieces.KING)
			return true;
		if (MyGame.board[kingPosition + 10] % 10 == Pieces.KING)
			return true;
		if (MyGame.board[kingPosition - 10] % 10 == Pieces.KING)
			return true;
		if (MyGame.board[kingPosition + 11] % 10 == Pieces.KING)
			return true;
		if (MyGame.board[kingPosition - 11] % 10 == Pieces.KING)
			return true;
		if (MyGame.board[kingPosition + 9] % 10 == Pieces.KING)
			return true;
		if (MyGame.board[kingPosition - 9] % 10 == Pieces.KING)
			return true;

		return false;

	}

	
	
	private static boolean isRQC(int checkPosition) {
		return MyGame.board[checkPosition] % 10 == Pieces.ROOK
				|| MyGame.board[checkPosition] % 10 == Pieces.QUEEN
				|| MyGame.board[checkPosition] % 10 == Pieces.CHANCELLOR;
	}

	private static boolean isBQA(int checkPosition) {
		return MyGame.board[checkPosition] % 10 == Pieces.BISHOP
				|| MyGame.board[checkPosition] % 10 == Pieces.QUEEN
				|| MyGame.board[checkPosition] % 10 == Pieces.ARCHBISHOP;
	}

	private static boolean isKAC(int kingPosition, int i) {
		return MyGame.board[kingPosition + i] % 10 == Pieces.KNIGHT  
		|| MyGame.board[kingPosition + i] % 10 == Pieces.ARCHBISHOP 
		|| MyGame.board[kingPosition + i] % 10 == Pieces.CHANCELLOR;
	}

}
