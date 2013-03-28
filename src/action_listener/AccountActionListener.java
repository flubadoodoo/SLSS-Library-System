package action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;

public class AccountActionListener implements ActionListener {
	
	public AccountActionListener() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Main.setPanel(Main.PANELS.ACCOUNT);
	}
	
}
