package panel.account;

import guiElements.MButton;

import java.awt.Container;

import panel.abstractPanel.AbstractInnerPanel;
import action_listener.BooksActionListener;
import action_listener.FinesActionListener;

@SuppressWarnings("serial")
public class AccountScreen extends AbstractInnerPanel {
	
	public AccountScreen(String panelName) {
		super(panelName);
	}
	
	MButton myBooksButton;
	MButton myFinesButton;
	
	public Container initialize() {
		super.initialize();
		myBooksButton = new MButton("my books", 10, 50, this, new BooksActionListener());
		myFinesButton = new MButton("my fines", 10, 90, this, new FinesActionListener());
		return this;
	}
}
