package chessGame;

import java.util.Scanner;
import java.applet.Applet;
import java.awt.*;

public class MyGame extends java.awt.Canvas {
	
	public static int WHITE = 1; 
	public static int BLACK = 2;
	
	public static int EDGE = 99;
	public static int SQUARE = 0;

	public static final int PLAYING = 0;
	public static final int WHITE_WIN = 1;
	public static final int BLACK_WIN = 2;

	public static int currentState; 
	public static int currentPlayer; 
	public static int currentPosition;
	public static Scanner in = new Scanner(System.in);
	/*
	 * 12*10 board. For each piece, the 1st digit is color: 2 for black, 1 for
	 * white. The 2nd digit is the type of piece: 1 for pawn, 2 for knight, 3
	 * for bishop, 4 for rook, 5 for queen, 6 for king
	 */
	static int[] orignalPosition = { 99, 99, 99, 99, 99, 99, 99, 99, 99, 99,
			99, 24, 22, 23, 25, 26, 23, 22, 24, 99, 99, 21, 21, 21, 21, 21, 21,
			21, 21, 99, 99, 00, 00, 00, 00, 00, 00, 00, 00, 99, 99, 00, 00, 00,
			00, 00, 00, 00, 00, 99, 99, 00, 00, 00, 00, 00, 00, 00, 00, 99, 99,
			00, 00, 00, 00, 00, 00, 00, 00, 99, 99, 11, 11, 11, 11, 11, 11, 11,
			11, 99, 99, 14, 12, 13, 15, 16, 13, 12, 14, 99, 99, 99, 99, 99, 99,
			99, 99, 99, 99, 99, };

	public static int[] board = new int[100];

	public void initBoard() {
		for (int i = 0; i < 100; i++) {
			board[i] = orignalPosition[i];
		}
		repaint();
		
		currentState = PLAYING; 
		currentPlayer = WHITE; 
	}

	public static void playerMove(int playerColor) {

		boolean validPick = false;

		//Check if player choose right color
		do {
			int chosenPieceIndex;

			if (playerColor == WHITE) {
				//Check if king is safe first
				if (ConditionCheck.isChecked()) {
					System.out
							.println("Warning, Player 'White', your king is under checked");
				}
				//Then player choose piece
				System.out
						.println("Player 'White', please choose your piece: ");
			} else {
				if (ConditionCheck.isChecked()) {
					System.out
							.println("Warning, Player 'Black', your king is under checked");
				}
				System.out
						.println("Player 'Black', please choose your piece: ");
			}

			//read the user input
			chosenPieceIndex = in.nextInt(); 

			//Check if player chooses the right color
			if (MyGame.board[chosenPieceIndex] / 10 == MyGame.currentPlayer) {

				System.out
						.println("Please choose a valid position you want to move: ");

				int chosenPosition = in.nextInt();

				//Check if it is not a valid move
				if (!MoveValidCheck.isValidMove(chosenPieceIndex, chosenPosition)) {
					System.out.println("This move to " + chosenPosition
							+ " is not a valid move.");
					validPick = false;
				} else {
					validPick = true;
					MoveExecute.executeMove(chosenPieceIndex, chosenPosition);
				}
			}
		} while (!validPick);
	}
	
	//Switch player
	public static void switchPlayer(){
		if( currentPlayer == WHITE )
			currentPlayer = BLACK;
		else
			currentPlayer = WHITE;
	}

}
