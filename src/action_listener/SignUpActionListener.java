package action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jdesktop.swingx.JXLoginPane;
import org.jdesktop.swingx.JXLoginPane.JXLoginFrame;

import service.signup.MySignUpService;

public class SignUpActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		JXLoginPane signUpPane = new JXLoginPane(new MySignUpService());
		signUpPane.setBannerText("SLSSLS Sign Up");
		JXLoginFrame signUpFrame = new JXLoginFrame(signUpPane);
		signUpFrame.setVisible(true);
	}
	
}
