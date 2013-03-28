package panel.welcome;

import font.MFont;
import guiElements.MButton;
import guiElements.MLabel;

import java.awt.Container;
import java.io.File;
import java.util.HashMap;

import main.Main;
import panel.abstractPanel.AbstractPanel;
import service.io.IO;
import action_listener.AccountActionListener;
import action_listener.LibraryFunctionsListener;
import action_listener.LogOutActionListener;

@SuppressWarnings("serial")
public class LoggedInScreen extends AbstractPanel {
	
	MLabel userNameGreetingLabel; // a label to welcome the logged in user
	
	MButton logOutButton; // the log out button
	MButton myAccountButton; // the my account button
	MButton libraryFunctions; // the library functions button (librarian specific)
	
	public LoggedInScreen(String panelName) {
		super(panelName); // call the super class's constructor
	}
	
	public Container initialize() {
		super.initialize();
		String loggedInUser = "welcome " + getLoggedInUserName() + "!";
		userNameGreetingLabel = new MLabel(loggedInUser, 0, 0, this, false);
		userNameGreetingLabel.setLocation(Main.getDisplayWidth() - 10 - MFont.getLabelWidth(userNameGreetingLabel), 10);
		
		logOutButton = new MButton("log out", 10, 10, this, new LogOutActionListener());
		myAccountButton = new MButton("my Account", 10, 50, this, new AccountActionListener());
		
		if (librarianLoggedIn()) {
			libraryFunctions = new MButton("library functions", 10, 90, this, new LibraryFunctionsListener());
		}
		
		return this;
	}
	
	private boolean librarianLoggedIn() {
		HashMap<String, String> map = IO.retrieveHashMapFromFile(new File("file/sys/log/log.txt"));
		String type = map.get("logtype");
		if (type != null) {
			return type.equals("librarian");
		} else {
			return false;
		}
	}
	
	private String getLoggedInUserName() {
		HashMap<String, String> map = IO.retrieveHashMapFromFile(new File("file/sys/log/log.txt"));
		if (map.get("log") != null) {
			return map.get("log");
		}
		return "";
	}
	
}
