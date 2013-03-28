package panel.welcome;

import guiElements.MButton;

import java.awt.Container;

import panel.abstractPanel.AbstractPanel;
import action_listener.LoginActionListener;
import action_listener.SignUpActionListener;

@SuppressWarnings("serial")
public class WelcomeScreen extends AbstractPanel {
	
	MButton loginButton; // the login button
	MButton signUpButton; // the sign up button
	
	public WelcomeScreen(String panelName) {
		super(panelName); // call the super class's constructor
	}
	
	public Container initialize() {
		super.initialize();
		// initialize the login button
		loginButton = new MButton("login", 10, 10, this, new LoginActionListener());
		
		// initialize the sign up button
		signUpButton = new MButton("sign up", 10, 50, this, new SignUpActionListener());
		
		return this;
	}
	
}
