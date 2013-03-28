package panel.abstractPanel;

import guiElements.MButton;

import java.awt.Container;

import action_listener.BackButtonActionListener;
import action_listener.HomeActionListener;

@SuppressWarnings("serial")
public class AbstractInnerPanel extends AbstractPanel {
	
	MButton backButton;
	MButton homeButton;
	
	public AbstractInnerPanel(String panelName) {
		super(panelName);
	}
	
	public Container initialize() {
		super.initialize();
		backButton = new MButton("back", 10, 10, this, new BackButtonActionListener(this.getClass().getSimpleName()));
		homeButton = new MButton("home", 85, 10, this, new HomeActionListener());
		return this;
	}
	
}
