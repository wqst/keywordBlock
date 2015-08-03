package chessGame;

import pieces.ArchBishop;
import pieces.Chancellor;
import pieces.Pieces;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class MoveValidCheck extends Pieces {
	/*
	 * Check if the end position is out of the board edge, or if the end
	 * position a valid move
	 */
	public static boolean isValidMove(int piecePosition, int movePosition) {

		System.out.println("Number is " + MyGame.board[piecePosition]);

		if (MyGame.board[movePosition] == MyGame.EDGE) {
			System.out.println("Out of the edge...");
			return false; // out of the edge
		}
		if (piecePosition == movePosition) {
			System.out.println("Please make a move...");
			return false;
		}
		
		switch (MyGame.board[piecePosition] % 10) {
		case PAWN: 
			if(Pawn.pawnMoveValid(piecePosition, movePosition))
				return true;
			else return false;
		case KNIGHT: 
			if(Knight.knightMoveValid(piecePosition, movePosition))
					return true;
			else return false;

		case BISHOP: 
			if(Bishop.bishopMoveValid(piecePosition, movePosition))
					return true;
			else return false;

		case ROOK: 
			if(Rook.rookMoveValid(piecePosition, movePosition))
					return true;
			else return false;

		case QUEEN: 
			if(Queen.queenMoveValid(piecePosition, movePosition))
					return true;
			else return false;

		case KING: 
			if(King.kingMoveValid(piecePosition, movePosition))
					return true;
			else return false;
			
		case ARCHBISHOP:
			if(ArchBishop.archbishopMoveValid(piecePosition, movePosition))
					return true;
			else return false;
			
		case CHANCELLOR:
			if(Chancellor.chancellorMoveValid(piecePosition, movePosition))
					return true;
			else return false;

		}
		return false;
	}
}
