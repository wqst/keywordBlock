package chessGame;
import java.applet.Applet;
import java.awt.*;

public class PrintBoard extends java.awt.Canvas{

	// some colors
		Color dunkel = new Color(0x999999);
		Color hell = new Color(0xFFFFCC);
		
		// the reference for the applet
		Applet parent;
		
		// the piece images
		Image[] pieces = new Image[18];
		
		public void Board(java.applet.Applet ref) {
			super();
			newgame();

			// load images
			MediaTracker controler = new MediaTracker(ref);

			pieces[1] = ref.getImage(ref.getCodeBase(), "images/white_pawn.gif");
			pieces[2] = ref.getImage(ref.getCodeBase(), "images/white_knight.gif");
			pieces[3] = ref.getImage(ref.getCodeBase(), "images/white_bishop.gif");
			pieces[4] = ref.getImage(ref.getCodeBase(), "images/white_rook.gif");
			pieces[5] = ref.getImage(ref.getCodeBase(), "images/white_queen.gif");
			pieces[6] = ref.getImage(ref.getCodeBase(), "images/white_king.gif");

			pieces[11] = ref.getImage(ref.getCodeBase(), "images/black_pawn.gif");
			pieces[12] = ref.getImage(ref.getCodeBase(), "images/black_knight.gif");
			pieces[13] = ref.getImage(ref.getCodeBase(), "images/black_bishop.gif");
			pieces[14] = ref.getImage(ref.getCodeBase(), "images/black_rook.gif");
			pieces[15] = ref.getImage(ref.getCodeBase(), "images/black_queen.gif");
			pieces[16] = ref.getImage(ref.getCodeBase(), "images/black_king.gif");

			for (int i = 1; i < 7; i++) {
				controler.addImage(pieces[i], 0);
				controler.addImage(pieces[i + 10], 0);
			}

			try {
				controler.waitForAll(); // wait until the images are loaded
			} catch (InterruptedException e) {
				System.out
						.println("Images not successfull loaded - Trying again ...");
				controler.checkID(0, true);
			}

			// set applet reference
			parent = ref;

		}
	
}
