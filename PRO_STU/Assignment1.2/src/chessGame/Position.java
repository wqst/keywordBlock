package chessGame;

/**
 * Represents the 2D position of a chess piece on the game board.
 */
public class Position {
	private int x;	/**< The x-coordinate. */
	private int y;	/**< The y-coordinate. */
	
	/**
	 * Constructor
	 */
	public Position(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * Constructor
	 * @param s string to be converted to position
	 */
	public Position(String s)
	{
		String[] tuple = s.split(" ");
		this.setX(Integer.parseInt(tuple[0]));
		this.setY(Integer.parseInt(tuple[1]));
	}
	
	/**
	 * Computes the vector sum of this position and another.
	 * @param that the other position
	 * @return the sum of the positions
	 */
	public Position addPositions(Position that)
	{
		return new Position(this.getX() + that.getX(), this.getY() + that.getY());
	}
	
	/**
	 * Converts the given position to a string.
	 * @return the string representation
	 */
	public String toString()
	{
		return "(" + getX() + ", " + getY() + ")";
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object that)
	{
		if (that instanceof Position)
			return this.getX() == ((Position)that).getX() && this.getY() == ((Position)that).getY();
		return false;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
