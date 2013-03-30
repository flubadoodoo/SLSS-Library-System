package action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;
import main.Main.PANELS;

public class LibraryStudentsActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		Main.setPanel(PANELS.LIB_STUDENTS);
	}
	
}
