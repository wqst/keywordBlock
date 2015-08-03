package chessGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JOptionPane;

import chessGame.ChessGame;
import chessGame.ChessMove;
import chessGame.ChessPiece;
import chessGame.ChessPiece.Color;
import chessGame.Position;
import chessGame.MoveStatus;
import chessGame.StandardChessGame;

/**
 * Main body of the game loop.
 * Upon any action event updates the board as necessary.
 * 
 *
 */
public class ChessControl implements ActionListener {
	ChessGame chessModel;	/** The chess game this is controlling */
	ChessView chessView;	/** The chess view that is associated with the game */
	ChessPiece currentPiece;	/** The first move selected in a two-position move set */
	Stack<ChessMove> previousMoves;	/** Record of previous moves made */
	private int whiteScore;	/** Number of matches white player has won */
	private int blackScore;	/** Number of matches black player has won */
	
	/**
	 * Constructor
	 * @param chessModel the chess game this is controlling
	 * @param chessView the image view of game this adjusts
	 */
	public ChessControl(ChessGame chessModel, ChessView chessView)
	{
		this.chessModel = chessModel;
		this.chessView = chessView;
		this.currentPiece = null;
		this.previousMoves = new Stack<ChessMove>();
		this.setBlackScore(0);
		this.setWhiteScore(0);
		
		// Add as an action listener for the chess board, top panel, and bottom panel
		for (int x = 0; x < ChessView.BOARD_WIDTH; x++)
			for (int y = 0; y < ChessView.BOARD_HEIGHT; y++)
				chessView.boardButtons[x][y].addActionListener(this);
		
		TopControlPanel topPanel = chessView.topPanel;
		topPanel.blackPlayerButton.addActionListener(this);
		topPanel.whitePlayerButton.addActionListener(this);
		
		BottomControlPanel bottomPanel = chessView.bottomPanel;
		bottomPanel.blackForfeitButton.addActionListener(this);
		bottomPanel.whiteForfeitButton.addActionListener(this);
		bottomPanel.restartButton.addActionListener(this);
		bottomPanel.undoButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equals("undoLastMove"))
			undoLastMove();
		else if (command.equals("restartGame"))
			restartGame();
		else if (command.equals("playerBlackForfeits"))
			forfeitPlayerBlack();
		else if (command.equals("playerWhiteForfeits"))
			forfeitPlayerWhite();
		else if (command.equals("playerBlack"))
			changePlayerName(ChessPiece.Color.BLACK);
		else if (command.equals("playerWhite"))
			changePlayerName(ChessPiece.Color.WHITE);
		else
			makePlayerMove(new Position(command));
	}
	
	/**
	 * Requests to change player name through an input dialog
	 * @param playerColor the player color who wants to change names
	 */
	public void changePlayerName(ChessPiece.Color playerColor)
	{
		String s = JOptionPane.showInputDialog(
				chessView,
				"Please enter a new player name",
				"Player Name Entry",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"Player Name").toString();
		
		if (s != null)
			chessView.setPlayerName(s, playerColor);
		else
			changePlayerName(playerColor);
	}
	
	/**
	 * Undoes the last move made
	 */
	public void undoLastMove()
	{
		if (!previousMoves.isEmpty())
		{
			ChessMove lastMove = previousMoves.pop();
			chessModel.undoLegalMove(lastMove);
			chessView.drawChessBoard();
			chessView.printMessageToBoard("Undid Last Move");
		}
		else
			chessView.printMessageToBoard("No Move Left To Undo");
	}
	
	/**
	 * Restarts the game with both scores at 0
	 */
	public void restartGame()
	{
		chessModel = new StandardChessGame();
		chessView.model = chessModel;
		chessView.setPlayerBlackScore(setBlackScore(0));
		chessView.setPlayerWhiteScore(setWhiteScore(0));
		chessView.printMessageToBoard("Restarted Game: All Scores Set To 0");
		previousMoves = new Stack<ChessMove>();
	}
	
	/**
	 * Player black forfeits - white wins
	 */
	public void forfeitPlayerBlack()
	{
		chessModel = new StandardChessGame();
		chessView.model = chessModel;
		chessView.setPlayerWhiteScore(setWhiteScore(getWhiteScore() + 1));
		chessView.printMessageToBoard("Player White Wins");
		previousMoves = new Stack<ChessMove>();
		writeScoresToFile();
	}
	
	/**
	 * Player white forfeits - black wins
	 */
	public void forfeitPlayerWhite()
	{
		chessModel = new StandardChessGame();
		chessView.model = chessModel;
		chessView.setPlayerBlackScore(setBlackScore(getBlackScore() + 1));
		chessView.printMessageToBoard("Player Black Wins");
		previousMoves = new Stack<ChessMove>();
		writeScoresToFile();
	}

	/**
	 * Handles all movements on board.
	 * If no other square has been selected yet store it and wait for destination square.
	 * If player attempts illegal move report it to the message board.
	 * If player makes a legal move print the result to the message board (check, victory, etc)
	 * @param selectedPosn the next selected chess space
	 */
	public void makePlayerMove(Position selectedPosn) 
	{
		chessView.drawChessBoard();
		ChessPiece selectedPiece = chessModel.getChessPieceFromSquare(selectedPosn);
		
		ChessPiece.Color currentPlayer = chessModel.getCurrentPlayer();
		
		String currentPlayerString = "White";
		String otherPlayerString = "Black";
		
		if (currentPlayer != ChessPiece.Color.WHITE)
		{
			currentPlayerString = "Black";
			otherPlayerString = "White";
		}
		
		// Only allow this piece movement if an actual piece of the same player color is selected
		if (currentPiece != null && currentPiece.getColor() == currentPlayer)
		{
			ChessMove lastMove = chessModel.movePiece(currentPiece.getPosition(), selectedPosn);
			
			// In case of illegal move
			if (lastMove.getMoveStatus() == MoveStatus.ILLEGAL_MOVE)
			{
				chessView.printMessageToBoard("Error: Illegal move for " + currentPlayerString);
				currentPiece = null;
				return;
			}
			
			previousMoves.push(lastMove);
			chessView.drawChessBoard();
			
			// Upon successful movement update message board
			switch (lastMove.getMoveStatus())
			{
				case CHECK:
					chessView.printMessageToBoard(currentPlayerString + " has put " + otherPlayerString + " in check!");
					break;
				case CHECK_MATE:
					if (chessModel.getCurrentPlayer() == ChessPiece.Color.WHITE)
						forfeitPlayerWhite();
					else
						forfeitPlayerBlack();
					break;
				default:
					chessView.printMessageToBoard("Player " + otherPlayerString + "'s Move");
					break;
			}
			
			currentPiece = null;
			return;
		}
		
		// Else this was first position selected in a move set
		if (selectedPiece != null)
			currentPiece = selectedPiece;
	}
	
	/**
	 * Upon the score being updated write the result to a file called score
	 */
	public void writeScoresToFile()
	{
		String whitePlayer = chessView.getPlayerName(Color.WHITE);
		String blackPlayer = chessView.getPlayerName(Color.BLACK);
		String newline = System.getProperty("line.separator");
		
		try 
		{
			FileWriter fstream = new FileWriter("score.txt", true);
			fstream.append(whitePlayer + " (white): " + whiteScore + "/");
			fstream.append(blackPlayer + " (black): " + blackScore + newline);
			fstream.flush();
			fstream.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
	}

	public int getBlackScore() {
		return blackScore;
	}

	public int setBlackScore(int blackScore) {
		this.blackScore = blackScore;
		return blackScore;
	}

	public int getWhiteScore() {
		return whiteScore;
	}

	public int setWhiteScore(int whiteScore) {
		this.whiteScore = whiteScore;
		return whiteScore;
	}

}
