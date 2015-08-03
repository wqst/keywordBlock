package chessTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chessGame.ChessGame;
import chessGame.ChessPiece;
import chessGame.Position;
import chessGame.StandardChessGame;
import chessGui.ChessControl;
import chessGui.ChessView;

/**
 * Testing for general schemes in chess control.
 * First set test primarily forfeiting and restarting the match to determine how the score changes.
 * Second set simulates a fool's mate with illegal moves and undoing.
 * Third set simulates a scholar's mate with illegal moves and undoing.
 * Forth set simulates a check resembling a scholar's mate, but not a checkmate.
 * 
 *
 */

public class ChessGuiTests {
	
	@Test
	public void testRestartGame()
	{
		ChessGame testGame = new StandardChessGame();
		ChessView testView = new ChessView(testGame);
		ChessControl testControl = new ChessControl(testGame, testView);
		
		assertEquals("intial scores are both 0",
				testControl.getBlackScore(),
				0);
		
		assertEquals("intial scores are both 0",
				testControl.getWhiteScore(),
				0);
		
		testControl.makePlayerMove(new Position(6, 1));
		testControl.makePlayerMove(new Position(6, 5));
		
		assertEquals("illegal white move", 
				testView.getMessageBoard(),
				"Error: Illegal move for White");
		
		assertEquals("still white turn",
				testGame.getCurrentPlayer(),
				ChessPiece.Color.WHITE);
		
		testControl.makePlayerMove(new Position(6, 1));
		testControl.makePlayerMove(new Position(6, 3));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player Black's Move");
		
		testControl.forfeitPlayerBlack();
		
		testControl.undoLastMove();
		assertEquals("new game - last move cannot be undone", 
				testView.getMessageBoard(),
				"No Move Left To Undo");
		
		assertEquals("black has forfeited - no change in score",
				testControl.getBlackScore(),
				0);
		
		assertEquals("black has forfeited - white gets a point",
				testControl.getWhiteScore(),
				1);
		
		testControl.forfeitPlayerWhite();
		testControl.forfeitPlayerWhite();
		testControl.forfeitPlayerBlack();
		testControl.forfeitPlayerWhite();
		
		testControl.undoLastMove();
		assertEquals("new game - last move cannot be undone", 
				testView.getMessageBoard(),
				"No Move Left To Undo");
		
		assertEquals("white forfeited 3 times - black has 3 points",
				testControl.getBlackScore(),
				3);
		
		assertEquals("black forfeited twice - white gets 2 points",
				testControl.getWhiteScore(),
				2);
	}
	
	@Test
	public void testFoolCheckmate()
	{
		// Start towards fool check mate
		ChessGame testGame = new StandardChessGame();
		ChessView testView = new ChessView(testGame);
		ChessControl testControl = new ChessControl(testGame, testView);
		
		assertEquals("init console message", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(6, 1));
		testControl.makePlayerMove(new Position(6, 5));
		
		assertEquals("illegal white move", 
				testView.getMessageBoard(),
				"Error: Illegal move for White");
		
		assertEquals("still white turn",
				testGame.getCurrentPlayer(),
				ChessPiece.Color.WHITE);
		
		testControl.makePlayerMove(new Position(6, 1));
		testControl.makePlayerMove(new Position(6, 3));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player Black's Move");
		
		testControl.makePlayerMove(new Position(4, 6));
		testControl.makePlayerMove(new Position(4, 2));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Error: Illegal move for Black");
		
		testControl.makePlayerMove(new Position(4, 6));
		testControl.makePlayerMove(new Position(4, 4));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(5, 1));
		testControl.makePlayerMove(new Position(5, 2));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player Black's Move");
		
		// Undo the last two moves
		for (int i = 0; i < 2; i++)
		{
		testControl.undoLastMove();
		assertEquals("last move undone", 
				testView.getMessageBoard(),
				"Undid Last Move");
		}
		
		// Resume normal game play
		testControl.makePlayerMove(new Position(4, 6));
		testControl.makePlayerMove(new Position(4, 4));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(5, 1));
		testControl.makePlayerMove(new Position(5, 2));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player Black's Move");

		testControl.makePlayerMove(new Position(3, 7));
		testControl.makePlayerMove(new Position(7, 3));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Player Black Wins");
		
		testControl.undoLastMove();
		assertEquals("new game - last move cannot be undone", 
				testView.getMessageBoard(),
				"No Move Left To Undo");
	}
	
	@Test
	public void testScholarsCheckmate()
	{
		ChessGame testGame = new StandardChessGame();
		ChessView testView = new ChessView(testGame);
		ChessControl testControl = new ChessControl(testGame, testView);
		
		assertEquals("init console message", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(4, 1));
		testControl.makePlayerMove(new Position(4, 1));
		
		assertEquals("illegal white move", 
				testView.getMessageBoard(),
				"Error: Illegal move for White");
		
		assertEquals("still white turn",
				testGame.getCurrentPlayer(),
				ChessPiece.Color.WHITE);
		
		testControl.makePlayerMove(new Position(4, 1));
		testControl.makePlayerMove(new Position(4, 3));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player Black's Move");
		
		testControl.makePlayerMove(new Position(4, 6));
		testControl.makePlayerMove(new Position(4, 7));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Error: Illegal move for Black");
		
		testControl.makePlayerMove(new Position(4, 6));
		testControl.makePlayerMove(new Position(4, 4));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(5, 0));
		testControl.makePlayerMove(new Position(2, 3));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player Black's Move");
		
		testControl.makePlayerMove(new Position(5, 7));
		testControl.makePlayerMove(new Position(2, 4));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(3, 0));
		testControl.makePlayerMove(new Position(7, 4));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player Black's Move");
		
		testControl.makePlayerMove(new Position(6, 7));
		testControl.makePlayerMove(new Position(5, 5));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(7, 4));
		testControl.makePlayerMove(new Position(5, 6));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player White Wins");
		
		testControl.undoLastMove();
		assertEquals("new game - last move cannot be undone", 
				testView.getMessageBoard(),
				"No Move Left To Undo");
	}
	
	@Test
	public void testNotScholarsCheckmate()
	{
		ChessGame testGame = new StandardChessGame();
		ChessView testView = new ChessView(testGame);
		ChessControl testControl = new ChessControl(testGame, testView);
		
		assertEquals("init console message", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(4, 1));
		testControl.makePlayerMove(new Position(4, 1));
		
		assertEquals("illegal white move", 
				testView.getMessageBoard(),
				"Error: Illegal move for White");
		
		assertEquals("still white turn",
				testGame.getCurrentPlayer(),
				ChessPiece.Color.WHITE);
		
		testControl.makePlayerMove(new Position(4, 1));
		testControl.makePlayerMove(new Position(4, 3));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player Black's Move");
		
		testControl.makePlayerMove(new Position(4, 6));
		testControl.makePlayerMove(new Position(4, 7));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Error: Illegal move for Black");
		
		testControl.makePlayerMove(new Position(4, 6));
		testControl.makePlayerMove(new Position(4, 4));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(5, 0));
		testControl.makePlayerMove(new Position(3, 2));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player Black's Move");
		
		testControl.makePlayerMove(new Position(5, 7));
		testControl.makePlayerMove(new Position(2, 4));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(3, 0));
		testControl.makePlayerMove(new Position(7, 4));
		
		assertEquals("white has moved", 
				testView.getMessageBoard(),
				"Player Black's Move");
		
		testControl.makePlayerMove(new Position(6, 7));
		testControl.makePlayerMove(new Position(5, 5));
		
		assertEquals("black has moved", 
				testView.getMessageBoard(),
				"Player White's Move");
		
		testControl.makePlayerMove(new Position(7, 4));
		testControl.makePlayerMove(new Position(5, 6));
		
		assertEquals("not a checkmate just yet", 
				testView.getMessageBoard(),
				"White has put Black in check!");
		
		testControl.undoLastMove();
		assertEquals("game still going - can still undo moves", 
				testView.getMessageBoard(),
				"Undid Last Move");
	}
}
