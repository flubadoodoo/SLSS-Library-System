package action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;

public class LogOutActionListener implements ActionListener {
	
	public LogOutActionListener() {
	}
	
	public void actionPerformed(ActionEvent e) {
		Main.setPanel(Main.PANELS.WELCOME);
	}
	
}
