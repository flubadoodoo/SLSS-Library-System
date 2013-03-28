package panel.account;

import java.awt.Container;

import panel.abstractPanel.AbstractInnerPanel;

@SuppressWarnings("serial")
public class BooksScreen extends AbstractInnerPanel {
	
	public BooksScreen(String panelName) {
		super(panelName);
	}
	
	public Container initialize() {
		super.initialize();
		return this;
	}
	
}
