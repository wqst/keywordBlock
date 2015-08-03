package chessGui;

import chessGame.ChessGame;
import chessGame.StandardChessGame;

/**
 * Main function as established by MVC schema.
 *
 *
 */
public class ChessMVC {

	/**
	 * Creates model, view, and control and starts the game.
	 * The game loop merely handles rendering the view, since user-input is event-driven and handled through signals by control.
	 * The game loop never terminates - upon a match finishing the board will return to the original configuration and begin a new match.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		ChessGame model = new StandardChessGame();
		ChessView view = new ChessView(model);
		view.setVisible(true);
		new ChessControl(model, view);
		
		// Game loop - never ends
		while (true)
		{
			view.drawChessBoard();
		}
	}
	
}
