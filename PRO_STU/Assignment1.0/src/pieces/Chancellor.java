package pieces;

public class Chancellor {
	
	public static boolean chancellorMoveValid(int piecePosition, int movePosition) {
		
		if( Knight.knightMoveValid(piecePosition, movePosition) || Rook.rookMoveValid(piecePosition, movePosition) )
				return true;
		else return false;
	}
}
