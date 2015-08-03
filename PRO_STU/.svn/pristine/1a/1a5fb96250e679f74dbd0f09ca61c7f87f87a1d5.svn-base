package chessTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chessGame.*;
import chessGame.ChessPiece.Color;

import org.junit.Test;

public class ChessPieceTests {

	int boardWidth = 8;	// Using standard board size 8x8 to create pieces
	int boardHeight = 8;
	
	@Test
	public void testIsValidPiecePosition()
	{
		QueenPiece queen1 = new QueenPiece(Color.WHITE, new Position(4, 4), boardWidth, boardHeight);
		
		assertEquals("(7, 7) is on board", queen1.isValidPosition(new Position(7, 7)), true);
		assertEquals("(8, 7) is not on board", queen1.isValidPosition(new Position(8, 7)), false);
		assertEquals("(0, 10) is not on board", queen1.isValidPosition(new Position(0, 10)), false);
		assertEquals("queen1 is on board", queen1.isValidPosition(queen1.getPosition()), true);
	}
	
	@Test
	public void testHorizontalVerticalSlide() 
	{
		Position[][] testPosn = new Position[boardWidth][boardHeight];
		
		for (int i = 0; i < boardWidth; i++)
			for (int j = 0; j < boardHeight; j++)
				testPosn[i][j] = new Position(i, j);
		
		QueenPiece queen1 = new QueenPiece(Color.WHITE, testPosn[4][4], boardWidth, boardHeight);
		
		Position[] verticalUpArray1 = {testPosn[4][5], testPosn[4][6], testPosn[4][7]};
		Position[] verticalDownArray1 = {testPosn[4][3], testPosn[4][2], testPosn[4][1], testPosn[4][0]};
		Position[] horizontalLeftArray1 = {testPosn[3][4], testPosn[2][4], testPosn[1][4], testPosn[0][4]};
		Position[] horizontalRightArray1 = {testPosn[5][4], testPosn[6][4], testPosn[7][4]};
		
		List<Position> verticalUpList1 = new ArrayList<Position>(Arrays.asList(verticalUpArray1));
		List<Position> verticalDownList1 = new ArrayList<Position>(Arrays.asList(verticalDownArray1));
		List<Position> horizontalLeftList1 = new ArrayList<Position>(Arrays.asList(horizontalLeftArray1));
		List<Position> horizontalRightList1 = new ArrayList<Position>(Arrays.asList(horizontalRightArray1));
		
		assertEquals("test positions.equals()", new Position(0, 1), testPosn[0][1]);
		
		assertEquals("these are all the steps up from queen(4, 4)", 
				queen1.computePossibleSteps(queen1.getPosition(), new Position(0, 1), new ArrayList<Position>()),
				verticalUpList1);
		assertEquals("these are all the steps down from queen(4, 4)", 
				queen1.computePossibleSteps(queen1.getPosition(), new Position(0, -1), new ArrayList<Position>()),
				verticalDownList1);
		assertEquals("these are all the steps left from queen(4, 4)", 
				queen1.computePossibleSteps(queen1.getPosition(), new Position(-1 , 0), new ArrayList<Position>()),
				horizontalLeftList1);
		assertEquals("these are all the steps right from queen(4, 4)", 
				queen1.computePossibleSteps(queen1.getPosition(), new Position(1 , 0), new ArrayList<Position>()),
				horizontalRightList1);
		
		List<List<Position>> straightMovesArray1 = new ArrayList<List<Position>>();
		straightMovesArray1.add(verticalUpList1);
		straightMovesArray1.add(horizontalRightList1);
		straightMovesArray1.add(verticalDownList1);
		straightMovesArray1.add(horizontalLeftList1);
		
		assertEquals("these are all the horizontal/vertical steps from queen(4, 4)",
				queen1.computeHorizontalVerticalMoves(),
				straightMovesArray1);
	}
	
	@Test
	public void testDiagonalSlide()
	{
		Position[][] testPosn = new Position[boardWidth][boardHeight];
		
		for (int i = 0; i < boardWidth; i++)
			for (int j = 0; j < boardHeight; j++)
				testPosn[i][j] = new Position(i, j);

		RookPiece rook1 = new RookPiece(Color.BLACK, testPosn[4][4], boardWidth, boardHeight);
		
		Position[] diagonalUpRightArray1 = {testPosn[5][5], testPosn[6][6], testPosn[7][7]};
		Position[] diagonalUpLeftArray1 = {testPosn[3][5], testPosn[2][6], testPosn[1][7]};
		Position[] diagonalDownRightArray1 = {testPosn[5][3], testPosn[6][2], testPosn[7][1]};
		Position[] diagonalDownLeftArray1 = {testPosn[3][3], testPosn[2][2], testPosn[1][1], testPosn[0][0]};
			
		List<Position> diagonalUpRightList1 = new ArrayList<Position>(Arrays.asList(diagonalUpRightArray1));
		List<Position> diagonalUpLeftList1 = new ArrayList<Position>(Arrays.asList(diagonalUpLeftArray1));
		List<Position> diagonalDownRightList1 = new ArrayList<Position>(Arrays.asList(diagonalDownRightArray1));
		List<Position> diagonalDownLeftList1 = new ArrayList<Position>(Arrays.asList(diagonalDownLeftArray1));
				
		List<List<Position>> diagonalMovesArray1 = new ArrayList<List<Position>>();
		diagonalMovesArray1.add(diagonalUpRightList1);
		diagonalMovesArray1.add(diagonalDownLeftList1);
		diagonalMovesArray1.add(diagonalUpLeftList1);
		diagonalMovesArray1.add(diagonalDownRightList1);
				
		assertEquals("these are all the diagonal steps from rook(4, 4)",
				rook1.computeDiagonalMoves(),
				diagonalMovesArray1);
	}
	
	@Test
	public void testAddSingleMoveSet()
	{
		QueenPiece queen1 = new QueenPiece(Color.WHITE, new Position(4, 4), boardWidth, boardHeight);
		RookPiece rook1 = new RookPiece(Color.BLACK, new Position(4, 4), boardWidth, boardHeight);
		
		assertEquals("can move up 0 right 1 in queen(4, 4)", 
				queen1.addSingleMoveSet(new ArrayList<List<Position>>(), new Position(0, 1)),
				true);
		assertEquals("can move up 2 left 1 in rook(4, 4)", 
				rook1.addSingleMoveSet(new ArrayList<List<Position>>(), new Position(2, -1)),
				true);
		assertEquals("cannot move up 4 right 4 in rook(4, 4)", 
				rook1.addSingleMoveSet(new ArrayList<List<Position>>(), new Position(4, 4)),
				false);
	}
	
	@Test
	public void testKingPiece()
	{
		Position[][] testPosn = new Position[boardWidth][boardHeight];
		
		for (int i = 0; i < boardWidth; i++)
			for (int j = 0; j < boardHeight; j++)
				testPosn[i][j] = new Position(i, j);
		
		ChessPiece king1 = new KingPiece(Color.WHITE, new Position(3, 0), boardWidth, boardHeight);
		ChessPiece king2 = new KingPiece(Color.BLACK, new Position(0, 0), boardWidth, boardHeight);
		
		List<List<Position>> kingMoves1 = new ArrayList<List<Position>>();
		List<List<Position>> kingMoves2 = new ArrayList<List<Position>>();
		
		List<Position> temp = new ArrayList<Position>();
		temp.add(testPosn[4][0]);
		kingMoves1.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[2][0]);
		kingMoves1.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[3][1]);
		kingMoves1.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[4][1]);
		kingMoves1.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[2][1]);
		kingMoves1.add(temp);
		
		temp = new ArrayList<Position>();
		temp.add(testPosn[1][0]);
		kingMoves2.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[0][1]);
		kingMoves2.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[1][1]);
		kingMoves2.add(temp);
		
		assertEquals("king(4, 0) moves in the square around itself", 
				king1.computePossibleMoveSpaces(),
				kingMoves1);
		
		assertEquals("king(4, 0) captures in the square around itself", 
				king1.computePossibleCaptureSpaces(),
				kingMoves1);
		
		assertEquals("King(0, 0) captures in the corner around itself",
				king2.computePossibleCaptureSpaces(),
				kingMoves2);
	}
	
	@Test
	public void testQueenPiece()
	{	
		ChessPiece queen1 = new QueenPiece(Color.WHITE, new Position(0, 0), boardWidth, boardHeight);
		ChessPiece queen2 = new QueenPiece(Color.BLACK, new Position(4, 2), boardWidth, boardHeight);
		
		List<List<Position>> queenMoves1 = queen1.computeDiagonalMoves();
		queenMoves1.addAll(queen1.computeHorizontalVerticalMoves());
		
		List<List<Position>> queenMoves2 = queen2.computeDiagonalMoves();
		queenMoves2.addAll(queen2.computeHorizontalVerticalMoves());
		
		assertEquals("queen(0, 0) moves along any straight line", 
				queen1.computePossibleMoveSpaces(),
				queenMoves1);
		
		assertEquals("queen(0, 0) captures along any straight line", 
				queen1.computePossibleCaptureSpaces(),
				queenMoves1);
		
		assertEquals("queen(3, 4) captures along the same line as it moves", 
				queen2.computePossibleCaptureSpaces(),
				queenMoves2);
	}
	
	@Test
	public void testBishopPiece()
	{
		ChessPiece bishop1 = new BishopPiece(Color.WHITE, new Position(7, 7), boardWidth, boardHeight);
		ChessPiece bishop2 = new BishopPiece(Color.BLACK, new Position(0, 1), boardWidth, boardHeight);
		
		assertEquals("bishop(7, 7) moves along only one diagonal line", 
				bishop1.computePossibleMoveSpaces(),
				bishop1.computeDiagonalMoves());
		
		assertEquals("bishop(0, 1) captures along any straight line", 
				bishop2.computePossibleCaptureSpaces(),
				bishop2.computeDiagonalMoves());
		
		assertEquals("bishop(0, 1) captures along the same line as it moves", 
				bishop2.computePossibleMoveSpaces(),
				bishop2.computeDiagonalMoves());
	}

	@Test
	public void testKnightPiece()
	{
		Position[][] testPosn = new Position[boardWidth][boardHeight];
		
		for (int i = 0; i < boardWidth; i++)
			for (int j = 0; j < boardHeight; j++)
				testPosn[i][j] = new Position(i, j);
		
		ChessPiece knight1 = new KnightPiece(Color.WHITE, new Position(7, 0), boardWidth, boardHeight);
		ChessPiece knight2 = new KnightPiece(Color.BLACK, new Position(5, 1), boardWidth, boardHeight);
		
		List<List<Position>> knightMoves1 = new ArrayList<List<Position>>();
		List<List<Position>> knightMoves2 = new ArrayList<List<Position>>();
		
		List<Position> temp = new ArrayList<Position>();
		temp.add(testPosn[6][2]);
		knightMoves1.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[5][1]);
		knightMoves1.add(temp);
		
		temp = new ArrayList<Position>();
		temp.add(testPosn[7][2]);
		knightMoves2.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[6][3]);
		knightMoves2.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[7][0]);
		knightMoves2.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[4][3]);
		knightMoves2.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[3][2]);
		knightMoves2.add(temp);
		temp = new ArrayList<Position>();
		temp.add(testPosn[3][0]);
		knightMoves2.add(temp);
		
		assertEquals("knight(7, 0) can only move two ways", 
				knight1.computePossibleMoveSpaces(),
				knightMoves1);
		
		assertEquals("knight(5, 1) can only move 6 ways", 
				knight2.computePossibleCaptureSpaces(),
				knightMoves2);
		
		assertEquals("knight(5, 1) captures in the same way it moves",
				knight2.computePossibleCaptureSpaces(),
				knightMoves2);
	}
	
	@Test
	public void testRookPiece()
	{
		ChessPiece rook1 = new RookPiece(Color.WHITE, new Position(5, 0), boardWidth, boardHeight);
		ChessPiece rook2 = new RookPiece(Color.BLACK, new Position(7, 3), boardWidth, boardHeight);
		
		assertEquals("rook(5, 0) can move along 3 ways", 
				rook1.computePossibleMoveSpaces(),
				rook1.computeHorizontalVerticalMoves());
		
		assertEquals("rook(6, 3) can move along all 4 ways", 
				rook1.computePossibleCaptureSpaces(),
				rook1.computeHorizontalVerticalMoves());
		
		assertEquals("rook(6, 3) captures along the same line as it moves", 
				rook2.computePossibleMoveSpaces(),
				rook2.computeHorizontalVerticalMoves());
	}
	
	@Test
	public void testArchBishopPiece()
	{
		ChessPiece arch1 = new ArchBishopPiece(Color.WHITE, new Position(7, 7), boardWidth, boardHeight);
		ChessPiece arch2 = new ArchBishopPiece(Color.BLACK, new Position(7, 3), boardWidth, boardHeight);
		
		assertEquals("arch(7, 7) can move along 6 ways", 
				arch1.computePossibleMoveSpaces().size(),
				6);
		
		assertEquals("arch(6, 3) can move along all 8 ways", 
				arch2.computePossibleCaptureSpaces().size(),
				8);
		
		assertEquals("arch(6, 3) captures along the same line as it moves", 
				arch2.computePossibleMoveSpaces(),
				arch2.computePossibleCaptureSpaces());
	}
	
	@Test
	public void testFerzPiece()
	{
		ChessPiece ferz1 = new FerzPiece(Color.WHITE, new Position(6, 7), boardWidth, boardHeight);
		ChessPiece ferz2 = new FerzPiece(Color.BLACK, new Position(7, 6), boardWidth, boardHeight);
		
		assertEquals("arch(6, 7) can move along 2 ways", 
				ferz1.computePossibleMoveSpaces().size(),
				2);
		
		assertEquals("arch(7, 6) can move along all 2 ways", 
				ferz2.computePossibleCaptureSpaces().size(),
				2);
		
		assertEquals("arch(7, 6) captures along the same line as it moves", 
				ferz2.computePossibleMoveSpaces(),
				ferz2.computePossibleCaptureSpaces());
	}
	
	@Test
	public void testPawnPiece()
	{
		ChessPiece pawn1 = new PawnPiece(Color.WHITE, new Position(0, 4), boardWidth, boardHeight);
		ChessPiece pawn2 = new PawnPiece(Color.BLACK, new Position(6, 4), boardWidth, boardHeight);
		
		List<List<Position>> pawnMoves1 = new ArrayList<List<Position>>();
		List<Position> temp = new ArrayList<Position>();
		temp.add(new Position(0, 5));
		temp.add(new Position(0, 6));
		pawnMoves1.add(temp);
		
		List<List<Position>> pawnMoves2 = new ArrayList<List<Position>>();
		temp = new ArrayList<Position>();
		temp.add(new Position(6, 3));
		temp.add(new Position(6, 2));
		pawnMoves2.add(temp);
		
		List<List<Position>> pawnCaptures1 = new ArrayList<List<Position>>();
		temp = new ArrayList<Position>();
		temp.add(new Position(1, 5));
		pawnCaptures1.add(temp);

		List<List<Position>> pawnCaptures2 = new ArrayList<List<Position>>();
		temp = new ArrayList<Position>();
		temp.add(new Position(7, 3));
		pawnCaptures2.add(temp);
		temp = new ArrayList<Position>();
		temp.add(new Position(5, 3));
		pawnCaptures2.add(temp);
		
		assertEquals("white pawn(0, 4) can move either one or two steps", 
				pawn1.computePossibleMoveSpaces(),
				pawnMoves1);
		
		assertEquals("black pawn(6, 4) can move either one or two steps", 
				pawn2.computePossibleMoveSpaces(),
				pawnMoves2);
		
		assertEquals("white pawn(0, 4) can only capture one space", 
				pawn1.computePossibleCaptureSpaces(),
				pawnCaptures1);
		
		assertEquals("black pawn(6, 4) can capture both diagonal spaces", 
				pawn2.computePossibleCaptureSpaces(),
				pawnCaptures2);
	}
}
