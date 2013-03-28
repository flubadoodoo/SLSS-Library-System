package action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jdesktop.swingx.JXLoginPane;
import org.jdesktop.swingx.JXLoginPane.JXLoginFrame;

import service.login.MyLoginService;

public class LoginActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		JXLoginPane loginPane = new JXLoginPane(new MyLoginService());
		loginPane.setBannerText("SLLS Login");
		JXLoginFrame loginFrame = new JXLoginFrame(loginPane);
		loginFrame.setVisible(true);
	}
	
}
