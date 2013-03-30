package service.login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import main.Main;
import main.Main.PANELS;

import org.jdesktop.swingx.auth.LoginService;

import service.io.IO;
import user.User;
import user.User.USER_ATTRIBUTE;
import user.User.USER_STANDARDS;

public class MyLoginService extends LoginService {
	
	public MyLoginService() {
		
	}
	
	public boolean authenticate(String name, char[] pass, String server) {
		String password = new String(pass);
		if ((new File("file/usr/" + name + ".txt")).isFile()) {
			User user = IO.retrieveUser(name);
			if (user.get(USER_ATTRIBUTE.PASSWORD).equals(password)) {
				try {
					PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(new File("file/sys/log/log.txt"))));
					w.println(User.getStandard(USER_STANDARDS.LOG_ID) + ":" + user.get(USER_ATTRIBUTE.ID));
					w.println(User.getStandard(USER_STANDARDS.LOG_TYPE) + ":" + user.get(USER_ATTRIBUTE.TYPE));
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				Main.setPanel(PANELS.LOGGED_IN);
				return true;
			}
		}
		return false;
	}
}
