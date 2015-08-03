package pieces;

public class ArchBishop {
	
	public static boolean archbishopMoveValid(int piecePosition, int movePosition) {
		
		if( Bishop.bishopMoveValid(piecePosition, movePosition) || Knight.knightMoveValid(piecePosition, movePosition) )
				return true;
		else return false;
	}
}
