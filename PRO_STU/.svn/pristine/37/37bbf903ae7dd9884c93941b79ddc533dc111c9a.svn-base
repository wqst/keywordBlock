package chessTests;

import static org.junit.Assert.*;

import chessGame.*;
import chessGame.ChessPiece.Color;

import org.junit.Test;

public class ChessBoardTests {

	int boardWidth = 8;	// Using standard board size 8x8 to create pieces
	int boardHeight = 8;

	@Test(expected=IllegalArgumentException.class)
	public void testAddPieceOffBoard() throws IllegalArgumentException
	{
		ChessGame emptyBoard = new Empty8x8Game();
		ChessPiece pawn1 = new PawnPiece(Color.BLACK, new Position(8, 8), boardWidth, boardHeight);
		emptyBoard.addChessPieceToBoard(pawn1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddTwoPiecesToSameSquare() throws IllegalArgumentException
	{
		ChessGame emptyBoard = new Empty8x8Game();
		
		ChessPiece pawn1 = new PawnPiece(Color.BLACK, new Position(3, 3), boardWidth, boardHeight);
		ChessPiece pawn2 = new PawnPiece(Color.WHITE, new Position(3, 3), boardWidth, boardHeight);
		
		emptyBoard.addChessPieceToBoard(pawn1);
		emptyBoard.addChessPieceToBoard(pawn2);
	}
	
	@Test
	public void testAddPiecesToBoard()
	{
		ChessGame emptyBoard = new Empty8x8Game();
		
		ChessPiece pawn1 = new PawnPiece(Color.BLACK, new Position(3, 3), boardWidth, boardHeight);
		ChessPiece pawn2 = new PawnPiece(Color.WHITE, new Position(1, 4), boardWidth, boardHeight);
		
		emptyBoard.addChessPieceToBoard(pawn1);
		emptyBoard.addChessPieceToBoard(pawn2);
		
		assertEquals("black pawn is now in black piece list",
				emptyBoard.getGivenPlayerPieces(Color.BLACK).get(0).getPosition(),
				pawn1.getPosition());
		assertEquals("white pawn is now in white piece list",
				emptyBoard.getGivenPlayerPieces(Color.WHITE).get(0).getPosition(),
				pawn2.getPosition());
		
		ChessPiece queen1 = new QueenPiece(Color.WHITE, new Position(5, 0), boardWidth, boardHeight);
		ChessPiece king1 = new KingPiece(Color.BLACK, new Position(2, 4), boardWidth, boardHeight);
		
		emptyBoard.addChessPieceToBoard(queen1);
		emptyBoard.addChessPieceToBoard(king1);
		
		assertEquals("white queen is not in white piece listt",
				emptyBoard.getGivenPlayerPieces(Color.WHITE).get(1).getPosition(),
				queen1.getPosition());
		assertEquals("black king is now in white piece list",
				emptyBoard.getGivenPlayerPieces(Color.BLACK).get(1).getPosition(),
				king1.getPosition());
	}
	
	@Test
	public void testRemoveCapturedPieceFromBoard()
	{
		ChessGame emptyBoard = new Empty8x8Game();
		
		ChessPiece pawn1 = new PawnPiece(Color.BLACK, new Position(3, 3), boardWidth, boardHeight);
		ChessPiece pawn2 = new PawnPiece(Color.WHITE, new Position(1, 4), boardWidth, boardHeight);
		ChessPiece queen1 = new QueenPiece(Color.WHITE, new Position(5, 0), boardWidth, boardHeight);
		ChessPiece king1 = new KingPiece(Color.BLACK, new Position(2, 4), boardWidth, boardHeight);
		
		emptyBoard.addChessPieceToBoard(pawn1);
		emptyBoard.addChessPieceToBoard(pawn2);
		emptyBoard.addChessPieceToBoard(queen1);
		emptyBoard.addChessPieceToBoard(king1);
		
		assertEquals("black king has been removed from board",
				emptyBoard.removeCapturedPieceFromBoard(new Position(2, 4)).toString(),
				king1.toString());
		assertEquals("white pawn has been removed from board",
				emptyBoard.removeCapturedPieceFromBoard(new Position(1, 4)).toString(),
				pawn2.toString());
		
		assertEquals("black king no longer in black piece list",
				emptyBoard.getGivenPlayerPieces(Color.BLACK).contains(king1),
				false);
		assertEquals("white pawn no longer in white piece list",
				emptyBoard.getGivenPlayerPieces(Color.WHITE).contains(pawn2),
				false);
	}
	
	@Test
	public void testComputeLegalMoves()
	{
		ChessGame emptyBoard = new Empty8x8Game();
		
		ChessPiece pawn1 = new PawnPiece(Color.BLACK, new Position(3, 3), boardWidth, boardHeight);
		ChessPiece pawn2 = new PawnPiece(Color.WHITE, new Position(1, 4), boardWidth, boardHeight);
		ChessPiece queen1 = new QueenPiece(Color.WHITE, new Position(4, 4), boardWidth, boardHeight);
		ChessPiece king1 = new KingPiece(Color.BLACK, new Position(2, 4), boardWidth, boardHeight);
		ChessPiece bishop1 = new BishopPiece(Color.WHITE, new Position(0, 0), boardWidth, boardHeight);
		ChessPiece knight1 = new KnightPiece(Color.BLACK, new Position(1, 2), boardWidth, boardHeight);
		
		emptyBoard.addChessPieceToBoard(pawn1);
		emptyBoard.addChessPieceToBoard(pawn2);
		emptyBoard.addChessPieceToBoard(queen1);
		emptyBoard.addChessPieceToBoard(king1);
		emptyBoard.addChessPieceToBoard(bishop1);
		emptyBoard.addChessPieceToBoard(knight1);
		
		emptyBoard.computeLegalMoves(pawn1);
		emptyBoard.computeLegalMoves(pawn2);
		emptyBoard.computeLegalMoves(queen1);
		emptyBoard.computeLegalMoves(king1);
		emptyBoard.computeLegalMoves(bishop1);
		emptyBoard.computeLegalMoves(knight1);
		
		assertEquals("black king can move to 6 locations",
				king1.getLegalMoves().size(),
				6);
		assertEquals("black pawn can move to either 2 locations",
				pawn1.getLegalMoves().size(),
				2);
		assertEquals("white pawn can move to either 2 locations",
				pawn2.getLegalMoves().size(),
				2);
		assertEquals("white queen can move to any of 20 locations",
				queen1.getLegalMoves().size(),
				20);
		assertEquals("white bishop blocked by white queen, can only move to 2 locations",
				bishop1.getLegalMoves().size(),
				2);
		assertEquals("black knight blocked by king and pawn, can only move to 3 locations",
				knight1.getLegalMoves().size(),
				3);
	}
	
	@Test
	public void testComputeLegalCaptures()
	{
		ChessGame emptyBoard = new Empty8x8Game();
		
		ChessPiece pawn1 = new PawnPiece(Color.BLACK, new Position(3, 3), boardWidth, boardHeight);
		ChessPiece pawn2 = new PawnPiece(Color.WHITE, new Position(1, 4), boardWidth, boardHeight);
		ChessPiece queen1 = new QueenPiece(Color.WHITE, new Position(4, 4), boardWidth, boardHeight);
		ChessPiece king1 = new KingPiece(Color.BLACK, new Position(2, 4), boardWidth, boardHeight);
		ChessPiece bishop1 = new BishopPiece(Color.WHITE, new Position(5, 5), boardWidth, boardHeight);
		ChessPiece knight1 = new KnightPiece(Color.BLACK, new Position(5, 6), boardWidth, boardHeight);
		
		emptyBoard.addChessPieceToBoard(pawn1);
		emptyBoard.addChessPieceToBoard(pawn2);
		emptyBoard.addChessPieceToBoard(queen1);
		emptyBoard.addChessPieceToBoard(king1);
		emptyBoard.addChessPieceToBoard(bishop1);
		emptyBoard.addChessPieceToBoard(knight1);
		
		emptyBoard.computeLegalCaptures(pawn1);
		emptyBoard.computeLegalCaptures(pawn2);
		emptyBoard.computeLegalCaptures(queen1);
		emptyBoard.computeLegalCaptures(king1);
		emptyBoard.computeLegalCaptures(bishop1);
		emptyBoard.computeLegalCaptures(knight1);
		
		assertEquals("black king can capture white pawn",
				king1.getLegalMoves().contains(pawn2.getPosition()),
				true);
		assertEquals("white pawn cannot capture black king",
				pawn2.getLegalMoves().contains(king1.getPosition()),
				false);
		assertEquals("white queen can capture black pawn",
				queen1.getLegalMoves().contains(pawn1.getPosition()),
				true);
		assertEquals("black pawn cannot capture white queen",
				pawn1.getLegalMoves().contains(queen1.getPosition()),
				false);
		assertEquals("white bishop cannot capture anything, especially not same-color queen",
				bishop1.getLegalMoves().size(),
				0);
		assertEquals("black knight can capture white queen",
				knight1.getLegalMoves().contains(queen1.getPosition()),
				true);
	}
	
	@Test
	public void testMovePieceLegally()
	{
		ChessGame emptyBoard = new Empty8x8Game();
		
		ChessPiece pawn1 = new PawnPiece(Color.BLACK, new Position(3, 3), boardWidth, boardHeight);
		ChessPiece pawn2 = new PawnPiece(Color.WHITE, new Position(1, 4), boardWidth, boardHeight);
		ChessPiece queen1 = new QueenPiece(Color.WHITE, new Position(4, 4), boardWidth, boardHeight);
		ChessPiece king1 = new KingPiece(Color.BLACK, new Position(2, 4), boardWidth, boardHeight);
		
		emptyBoard.addChessPieceToBoard(pawn1);
		emptyBoard.addChessPieceToBoard(pawn2);
		emptyBoard.addChessPieceToBoard(queen1);
		emptyBoard.addChessPieceToBoard(king1);
		
		emptyBoard.computeLegalMoves(pawn1);
		emptyBoard.computeLegalMoves(pawn2);
		emptyBoard.computeLegalMoves(queen1);
		emptyBoard.computeLegalMoves(king1);
		
		emptyBoard.computeLegalCaptures(pawn1);
		emptyBoard.computeLegalCaptures(pawn2);
		emptyBoard.computeLegalCaptures(queen1);
		emptyBoard.computeLegalCaptures(king1);
		
		assertEquals("white queen capture black pawn",
				emptyBoard.movePieceLegally(queen1, new Position(3, 3)),
				pawn1);
		assertEquals("black pawn captured - no longer in black piece list",
				emptyBoard.getGivenPlayerPieces(ChessPiece.Color.BLACK).indexOf(pawn1),
				-1);
		assertEquals("white pawn moves up two spaces",
				emptyBoard.movePieceLegally(pawn2, new Position(1, 6)),
				null);
		assertEquals("white pawn moves up one space",
				emptyBoard.movePieceLegally(pawn2, new Position(1, 7)),
				null);
		assertEquals("black king moves over one space",
				emptyBoard.movePieceLegally(king1, new Position(2, 3)),
				null);
		assertEquals("black king caputres white queen",
				emptyBoard.movePieceLegally(king1, new Position(3, 3)),
				queen1);
		assertEquals("white queen captured - no longer in white piece list",
				emptyBoard.getGivenPlayerPieces(ChessPiece.Color.WHITE).indexOf(queen1),
				-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMoveEmptySpacePiece() throws IllegalArgumentException
	{
		ChessGame emptyBoard = new Empty8x8Game();

		ChessPiece pawn1 = new PawnPiece(Color.BLACK, new Position(3, 3), boardWidth, boardHeight);
		ChessPiece pawn2 = new PawnPiece(Color.WHITE, new Position(1, 4), boardWidth, boardHeight);
		ChessPiece queen1 = new QueenPiece(Color.WHITE, new Position(4, 4), boardWidth, boardHeight);
		ChessPiece king1 = new KingPiece(Color.BLACK, new Position(2, 4), boardWidth, boardHeight);
		
		emptyBoard.addChessPieceToBoard(pawn1);
		emptyBoard.addChessPieceToBoard(pawn2);
		emptyBoard.addChessPieceToBoard(queen1);
		emptyBoard.addChessPieceToBoard(king1);
		
		emptyBoard.movePiece(new Position(3, 2), new Position(2, 3));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMoveWrongColorPiece() throws IllegalArgumentException
	{
		ChessGame emptyBoard = new Empty8x8Game();

		ChessPiece pawn1 = new PawnPiece(Color.BLACK, new Position(3, 3), boardWidth, boardHeight);
		ChessPiece pawn2 = new PawnPiece(Color.WHITE, new Position(1, 4), boardWidth, boardHeight);
		ChessPiece queen1 = new QueenPiece(Color.WHITE, new Position(4, 4), boardWidth, boardHeight);
		ChessPiece king1 = new KingPiece(Color.BLACK, new Position(2, 4), boardWidth, boardHeight);
		
		emptyBoard.addChessPieceToBoard(pawn1);
		emptyBoard.addChessPieceToBoard(pawn2);
		emptyBoard.addChessPieceToBoard(queen1);
		emptyBoard.addChessPieceToBoard(king1);
		
		emptyBoard.movePiece(new Position(3, 3), new Position(2, 3));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMakeIllegalMove() throws IllegalArgumentException
	{
		ChessGame emptyBoard = new Empty8x8Game();

		ChessPiece pawn1 = new PawnPiece(Color.BLACK, new Position(3, 5), boardWidth, boardHeight);
		ChessPiece pawn2 = new PawnPiece(Color.WHITE, new Position(1, 4), boardWidth, boardHeight);
		ChessPiece queen1 = new QueenPiece(Color.WHITE, new Position(4, 4), boardWidth, boardHeight);
		ChessPiece king1 = new KingPiece(Color.BLACK, new Position(2, 4), boardWidth, boardHeight);
		
		emptyBoard.addChessPieceToBoard(pawn1);
		emptyBoard.addChessPieceToBoard(pawn2);
		emptyBoard.addChessPieceToBoard(queen1);
		emptyBoard.addChessPieceToBoard(king1);
		
		emptyBoard.movePiece(new Position(3, 5), new Position(3, 3));
		emptyBoard.switchPlayerTurn();
		emptyBoard.movePiece(new Position(3, 3), new Position(3, 1));	// Pawn moves up two spaces twice
	}
	
	@Test
	public void testMakeMove()
	{
		ChessGame foolsGame = new StandardChessGame();
		
		foolsGame.movePiece(new Position(6, 1), new Position(6, 3));
		assertEquals("white pawn has been moved to (6, 3)",
				foolsGame.getChessBoard().get(new Position(6, 3)).toString(),
				"P");
		
		foolsGame.movePiece(new Position(4, 6), new Position(4, 4));
		assertEquals("black pawn has been moved to (4, 4)",
				foolsGame.getChessBoard().get(new Position(4, 4)).toString(),
				"p");
		
		foolsGame.movePiece(new Position(5, 1), new Position(5, 2));
		assertEquals("white pawn has been moved to (5, 2)",
				foolsGame.getChessBoard().get(new Position(5, 2)).toString(),
				"P");
		
		foolsGame.movePiece(new Position(3, 7), new Position(7, 3));
		assertEquals("black queen has been moved to (7, 3)",
				foolsGame.getChessBoard().get(new Position(7, 3)).toString(),
				"q");
		
		
		
		ChessGame scholarsGame = new StandardChessGame();
		
		scholarsGame.movePiece(new Position(4, 1), new Position(4, 3));
		assertEquals("white pawn has been moved to (4, 3)",
				scholarsGame.getChessBoard().get(new Position(4, 3)).toString(),
				"P");
		
		scholarsGame.movePiece(new Position(4, 6), new Position(4, 4));
		assertEquals("black pawn has been moved to (4, 4)",
				scholarsGame.getChessBoard().get(new Position(4, 4)).toString(),
				"p");
		
		scholarsGame.movePiece(new Position(5, 0), new Position(2, 3));
		assertEquals("white bishop has been moved to (2, 3)",
				scholarsGame.getChessBoard().get(new Position(2, 3)).toString(),
				"B");
		
		scholarsGame.movePiece(new Position(5, 7), new Position(2, 4));
		assertEquals("black bishop has been moved to (2, 4)",
				scholarsGame.getChessBoard().get(new Position(2, 4)).toString(),
				"b");
		
		scholarsGame.movePiece(new Position(3, 0), new Position(7, 4));
		assertEquals("white queen has been moved to (7, 4)",
				scholarsGame.getChessBoard().get(new Position(7, 4)).toString(),
				"Q");
		
		scholarsGame.movePiece(new Position(6, 7), new Position(5, 5));
		assertEquals("black knight has been moved to (5, 5)",
				scholarsGame.getChessBoard().get(new Position(5, 5)).toString(),
				"n");
		
		scholarsGame.movePiece(new Position(7, 4), new Position(5, 6));
		assertEquals("white queen has been moved to (5, 6), checkmate!",
				scholarsGame.getChessBoard().get(new Position(5, 6)).toString(),
				"Q");
	}
	
	@Test
	public void testMakeMoveAndCheckmate()
	{
		ChessGame foolsGame = new StandardChessGame();
		
		foolsGame.movePiece(new Position(6, 1), new Position(6, 3));
		foolsGame.movePiece(new Position(4, 6), new Position(4, 4));
		foolsGame.movePiece(new Position(5, 1), new Position(5, 2));
		foolsGame.movePiece(new Position(3, 7), new Position(7, 3));
		
		foolsGame.switchPlayerTurn();
		
		assertEquals("this is a fool's checkmate",
				foolsGame.isOpponentInCheckmate(),
				true);
		
		ChessGame scholarsGame = new StandardChessGame();
		
		scholarsGame.movePiece(new Position(4, 1), new Position(4, 3));
		scholarsGame.movePiece(new Position(4, 6), new Position(4, 4));
		scholarsGame.movePiece(new Position(5, 0), new Position(2, 3));
		scholarsGame.movePiece(new Position(5, 7), new Position(2, 4));
		scholarsGame.movePiece(new Position(3, 0), new Position(7, 4));
		scholarsGame.movePiece(new Position(6, 7), new Position(5, 5));
		scholarsGame.movePiece(new Position(7, 4), new Position(5, 6));
		
		scholarsGame.switchPlayerTurn();
		
		assertEquals("this is a scholar's checkmate",
				scholarsGame.isOpponentInCheckmate(),
				true);
		
		ChessGame notScholarsGame = new StandardChessGame();
		
		notScholarsGame.movePiece(new Position(4, 1), new Position(4, 3));
		notScholarsGame.movePiece(new Position(4, 6), new Position(4, 4));
		notScholarsGame.movePiece(new Position(5, 0), new Position(3, 2));
		notScholarsGame.movePiece(new Position(5, 7), new Position(2, 4));
		notScholarsGame.movePiece(new Position(3, 0), new Position(7, 4));
		notScholarsGame.movePiece(new Position(6, 7), new Position(5, 5));
		notScholarsGame.movePiece(new Position(7, 4), new Position(5, 6));
		
		notScholarsGame.switchPlayerTurn();
		
		assertEquals("this is not quite a scholar's checkmate",
				notScholarsGame.isOpponentInCheckmate(),
				false);
	}
	
}
