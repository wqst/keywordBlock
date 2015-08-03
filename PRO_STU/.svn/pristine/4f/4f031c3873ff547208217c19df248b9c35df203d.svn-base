package chessGame;

public class GameLoop {

	public static void main(String[] args){
		//Initialize the game board
		MyGame newGame = new MyGame();
		newGame.initBoard();
		
		//Print the board
		UpdateBoard.printBoard();
		
		//Game loop
		do {
			//Players begin to play
			MyGame.playerMove(MyGame.currentPlayer);
			
			UpdateBoard.printBoard();
			
			//Switch player
			MyGame.switchPlayer();
		} while( MyGame.currentState == MyGame.PLAYING );
	}
}
