package testSuit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import chessGame.ConditionCheck;
import chessGame.MoveExecute;
import chessGame.MoveValidCheck;
import chessGame.MyGame;


/*
 * 48 test cases totally
 */
public class ChessTest {

	@Before
	public void testSetup() {
		MyGame newGame = new MyGame();
		newGame.initBoard();
	}
	
	/*
	 * -------------------------------------------------
	 * Move test for pawn
	 */
	@Test
	public void validPawnMove1() throws Exception {
		assertTrue( MoveValidCheck.isValidMove(71, 61) );
	}

	@Test
	public void validPawnMove2() throws Exception {
		assertTrue( MoveValidCheck.isValidMove(72, 62) );
	}

	@Test
	public void validPawnMove3() throws Exception {
		assertTrue( MoveValidCheck.isValidMove(73, 63) );
	}

	@Test
	public void validPawnMove4() throws Exception {
		assertTrue( MoveValidCheck.isValidMove(74, 64) );
	}

	@Test
	public void validPawnMove5() throws Exception {
		assertTrue( MoveValidCheck.isValidMove(75, 65) );
	}

	@Test
	public void validPawnMove6() throws Exception {
		assertTrue( MoveValidCheck.isValidMove(76, 66) );
	}
	
	@Test
	/*
	 * Out of edge
	 */
	public void invalidPawnMove1() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(71, 60) );
	}

	@Test
	/*
	 * invalid move to diagonal
	 */
	public void invalidPawnMove2() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(71, 62) );
	}
	
	/*
	 * ---------------------------------------------------
	 * Move test for Knight
	 */
	@Test
	public void validKnightMove1() throws Exception {
		assertTrue( MoveValidCheck.isValidMove(87, 66) );
	}
	
	@Test
	public void validKnightMove2() throws Exception {
		assertTrue( MoveValidCheck.isValidMove(87, 68) );
	}
	
	@Test
	public void validKnightMove3() throws Exception {
		assertTrue( MoveValidCheck.isValidMove(87, 66) );
	}
	
	@Test
	public void invalidKnightMove1() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(87, 95) );
	}
	
	@Test
	public void invalidKnightMove2() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(87, 99) );
	}
	
	@Test
	public void invalidKnightMove3() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(87, 75) );
	}
	
	@Test
	public void invalidKnightMove4() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(87, 79) );
	}
	
	/*
	 * ---------------------------------------------------
	 * Move test for bishop
	 */
	@Test
	public void validBishopMove1() throws Exception {
		MoveExecute.executeMove(72, 62);
		assertTrue( MoveValidCheck.isValidMove(83, 72) );
	}
	
	@Test
	public void validBishopMove2() throws Exception {
		MoveExecute.executeMove(72, 62);
		assertTrue( MoveValidCheck.isValidMove(83, 61) );
	}
	
	@Test
	public void validBishopMove3() throws Exception {
		MoveExecute.executeMove(74, 64);
		assertTrue( MoveValidCheck.isValidMove(83, 74) );
	}
	
	@Test
	public void validBishopMove4() throws Exception {
		MoveExecute.executeMove(74, 64);
		assertTrue( MoveValidCheck.isValidMove(83, 47) );
	}
	
	@Test
	public void invalidBishopMove1() throws Exception {
		MoveExecute.executeMove(74, 64);
		assertFalse( MoveValidCheck.isValidMove(83, 29) );
	}
	
	@Test
	public void invalidBishopMove2() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(83, 29) );
	}
	
	@Test
	public void invalidBishopMove3() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(83, 73) );
	}
	
	/*
	 * ------------------------------------------------------------
	 * Move test for queen
	 */
	@Test
	public void validQueenMove1() throws Exception {
		MoveExecute.executeMove(73, 63);
		assertTrue( MoveValidCheck.isValidMove(84, 73) );
	}
	
	@Test
	public void validQueenMove2() throws Exception {
		MoveExecute.executeMove(73, 63);
		assertTrue( MoveValidCheck.isValidMove(84, 51) );
	}
	
	@Test
	public void validQueenMove3() throws Exception {
		MoveExecute.executeMove(75, 65);
		assertTrue( MoveValidCheck.isValidMove(84, 75) );
	}
	
	@Test
	public void validQueenMove4() throws Exception {
		MoveExecute.executeMove(75, 65);
		assertTrue( MoveValidCheck.isValidMove(84, 48) );
	}
	
	@Test
	public void invalidQueenMove1() throws Exception {
		MoveExecute.executeMove(75, 65);
		assertFalse( MoveValidCheck.isValidMove(84, 39) );
	}
	
	@Test
	public void invalidQueenMove2() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(84, 29) );
	}
	
	@Test
	public void invalidQueenMove3() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(84, 73) );
	}
	
	/*
	 * -------------------------------------------------------
	 * Move test for rook
	 */
	@Test
	public void validRookMove1() throws Exception {
		MoveExecute.executeMove(71, 31);
		assertTrue( MoveValidCheck.isValidMove(81, 41) );
	}
	
	@Test
	public void validRookMove2() throws Exception {
		MoveExecute.executeMove(71, 31);
		assertTrue( MoveValidCheck.isValidMove(81, 51) );
	}
	
	@Test
	public void validRookMove3() throws Exception {
		MoveExecute.executeMove(71, 31);
		assertTrue( MoveValidCheck.isValidMove(81, 61) );
	}
	
	@Test
	public void validRookMove4() throws Exception {
		MoveExecute.executeMove(71, 31);
		assertTrue(MoveValidCheck.isValidMove(81, 71) );
	}
	
	@Test
	public void invalidRookMove1() throws Exception {
		MoveExecute.executeMove(71, 31);
		assertFalse( MoveValidCheck.isValidMove(81, 31) );
	}
	
	@Test
	public void invalidRookMove2() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(81, 71) );
	}
	
	@Test
	public void invalidRookMove3() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(81, 80) );
	}
	
	/*
	 * -------------------------------------------------------
	 * Move test for king
	 */
	@Test
	public void validKingMove1() throws Exception {
		MoveExecute.executeMove(75, 65);
		assertTrue( MoveValidCheck.isValidMove(85, 75) );
	}
	
	@Test
	public void validKingMove2() throws Exception {
		MoveExecute.executeMove(74, 64);
		assertTrue( MoveValidCheck.isValidMove(85, 74) );
	}
	
	@Test
	public void validKingMove3() throws Exception {
		MoveExecute.executeMove(76, 66);
		assertTrue( MoveValidCheck.isValidMove(85, 76) );
	}
	
	@Test
	public void invalidKingMove1() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(85, 75) );
	}
	
	@Test
	public void invalidKingMove2() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(85, 84) );
	}
	
	@Test
	public void invalidKingMove3() throws Exception {
		assertFalse( MoveValidCheck.isValidMove(85, 86) );
	}
	
	/*
	 * Test kill enemy
	 */
	@Test
	public void validKillPawn() throws Exception {
		MoveExecute.executeMove(72, 32);
		MoveExecute.executeMove(32, 23);
	}
	
	@Test
	public void validKillKnight() throws Exception {
		MoveExecute.executeMove(82, 33);
		 MoveExecute.executeMove(33, 12);
	}
	
	/*
	 * ------------------------------------------------------
	 * Test for King checked
	 */
	@Test
	public void PawnCheckKing() throws Exception {
		MoveExecute.executeMove(74, 64);
		MoveExecute.executeMove(24, 74);
		assertTrue( ConditionCheck.isChecked() );
	}
	
	@Test
	public void RookCheckKing() throws Exception {
		MoveExecute.executeMove(11, 35);
		MoveExecute.executeMove(75, 66);
		assertTrue( ConditionCheck.isChecked() );
	}
	
	@Test
	public void KnightCheckKing() throws Exception {
		MoveExecute.executeMove(17, 66);
		assertTrue( ConditionCheck.isChecked() );
		
	}
	
	@Test
	public void BishopCheckKing() throws Exception {
		MoveExecute.executeMove(16, 67);
		MoveExecute.executeMove(76, 66);
		assertTrue( ConditionCheck.isChecked() );
	}
	
	@Test
	public void QueenCheckKing() throws Exception {
		MoveExecute.executeMove(14, 41);
		MoveExecute.executeMove(74, 64);
		assertTrue( ConditionCheck.isChecked() );
	}
	
	@Test
	public void KingCheckKing() throws Exception {
		MoveExecute.executeMove(75, 65);
		MoveExecute.executeMove(15, 75);
		assertTrue( ConditionCheck.isChecked() );
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
