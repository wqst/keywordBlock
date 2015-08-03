package chessGui;

import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Initializes all image icons
 */
public final class ChessImageIcons {
	public static final ImageIcon BLACK_BISHOP = imageIcon("/blackBishop.png");
	public static final ImageIcon BLACK_KING = imageIcon("/blackKing.png");
	public static final ImageIcon BLACK_KNIGHT = imageIcon("/blackKnight.png");
	public static final ImageIcon BLACK_PAWN = imageIcon("/blackPawn.png");
	public static final ImageIcon BLACK_QUEEN = imageIcon("/blackQueen.png");
	public static final ImageIcon BLACK_ROOK = imageIcon("/blackRook.png");
	public static final ImageIcon WHITE_BISHOP = imageIcon("/whiteBishop.png");
	public static final ImageIcon WHITE_KING = imageIcon("/whiteKing.png");
	public static final ImageIcon WHITE_KNIGHT = imageIcon("/whiteKnight.png");
	public static final ImageIcon WHITE_PAWN = imageIcon("/whitePawn.png");
	public static final ImageIcon WHITE_QUEEN = imageIcon("/whiteQueen.png");
	public static final ImageIcon WHITE_ROOK = imageIcon("/whiteRook.png");
	
	public static final ImageIcon BLACK_ARCHBISHOP = imageIcon("/blackArchbishop.png");
	public static final ImageIcon BLACK_FERZ = imageIcon("/blackFerz.png");
	public static final ImageIcon WHITE_ARCHBISHOP = imageIcon("/whiteArchbishop.png");
	public static final ImageIcon WHITE_FERZ = imageIcon("/whiteFerz.png");
	
	public static final Color DARK_SQUARE_COLOR = new Color(209, 139, 71);
	public static final Color LIGHT_SQUARE_COLOR = new Color(255, 206, 158);

	/**
	 * Get the image icon from file associated with each piece, or an empty one for no such resource
	 * @param path the path to the image
	 * @return image icon from path or a blank icon if bath is invalid
	 */
	private static ImageIcon imageIcon(String path) {
		URL resource = ChessImageIcons.class.getResource(path);
		
		if (resource == null)
		{
			System.out.println("Created blank icon for representation of " + path);
			return new ImageIcon();
		}
		
		System.out.println("Created a new icon representing " + path);
		return new ImageIcon(resource);
	}
}
