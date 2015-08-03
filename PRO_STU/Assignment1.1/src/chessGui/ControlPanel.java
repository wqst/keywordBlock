package chessGui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

/**
 * Base class for all other button control panels
 * 
 *
 */

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
	public static final int PANEL_SIZE = ChessView.BOARD_SQUARE_SIZE;
	public static final Dimension BUTTON_DIMENSION = new Dimension(PANEL_SIZE * 2, PANEL_SIZE / 2);
	public static final Dimension LABEL_DIMENSION = new Dimension(PANEL_SIZE * 4, PANEL_SIZE / 2);
	
	/**
	 * Constructor
	 */
	public ControlPanel()
	{
		super();
		setLayout(new GridBagLayout());
	}
	
	/**
	 * Add given component to panel
	 * @param component the component to be added
	 * @param dimension the size of the component
	 * @param x the x position in the grid layout
	 * @param y the y position in the grid layout
	 * @param width the number of columns this component occupies
	 * @param height the number of rows this component occupies
	 */
	protected void addComponentToBoard(Component component, Dimension dimension, int x, int y, int width, int height)
	{
		component.setPreferredSize(dimension);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		add(component, constraints);
	}
}
