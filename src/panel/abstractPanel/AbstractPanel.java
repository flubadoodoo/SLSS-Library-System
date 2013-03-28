package panel.abstractPanel;

import font.MFont;
import guiElements.MLabel;

import java.awt.Container;

import main.Main;

import org.jdesktop.swingx.JXPanel;

@SuppressWarnings("serial")
public abstract class AbstractPanel extends JXPanel {
	
	MLabel panelNameLabel;
	String panelNameString;
	
	/* Constructor of AbstractPanel.
	 * Sets some properties that all the panels in this program have.
	 * */
	public AbstractPanel(String panelName) {
		setLayout(null); // set the layout manager to null, we will define absolute coordinates for components
		setDoubleBuffered(true); // turn double buffering on
		panelNameString = panelName;
		initialize(); // initialize the components
	}
	
	// a method to initialize the panel's components
	public Container initialize() {
		removeAll();
		panelNameLabel = new MLabel(panelNameString, 0, 0, this, true);
		panelNameLabel.setLocation(Main.getDisplayWidth() / 2 - MFont.getLabelWidth(panelNameLabel) / 2, 10);
		return null;
	}
	
}
