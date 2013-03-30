package action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import main.Main;
import main.Main.PANELS;

public class BackButtonActionListener implements ActionListener {
	
	private String panelClass;
	
	public BackButtonActionListener(String panelClass) {
		this.panelClass = panelClass;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			BufferedReader r = new BufferedReader(new FileReader(new File("file/sys/pnl/pnl.txt")));
			String line = r.readLine();
			while (line != null) {
				Scanner s = new Scanner(line);
				s.useDelimiter(":");
				if (s.next().equals(panelClass)) {
					switch (s.next()) {
					case "LoggedInScreen":
						Main.setPanel(PANELS.LOGGED_IN);
						break;
					case "AccountScreen":
						Main.setPanel(PANELS.ACCOUNT);
						break;
					case "LibraryFunctionScreen":
						Main.setPanel(PANELS.LIBRARY_FUNC);
						break;
					}
				}
				s.close();
				line = r.readLine();
			}
			r.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public String getPanelClass() {
		return panelClass;
	}
	
	public void setPanelClass(String panelClass) {
		this.panelClass = panelClass;
	}
	
}
