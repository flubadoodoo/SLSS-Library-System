package panel.library_func;

import guiElements.MButton;

import java.awt.Container;

import panel.abstractPanel.AbstractInnerPanel;
import action_listener.LibraryBooksActionListener;
import action_listener.LibraryStudentsActionListener;

@SuppressWarnings("serial")
public class LibraryFunctionScreen extends AbstractInnerPanel {
	
	MButton libBooks;
	MButton libStudents;
	
	public LibraryFunctionScreen(String panelName) {
		super(panelName);
	}
	
	public Container initialize() {
		super.initialize();
		libBooks = new MButton("library books", 10, 50, this, new LibraryBooksActionListener());
		libStudents = new MButton("library students", 10, 90, this, new LibraryStudentsActionListener());
		return this;
	}
	
}
