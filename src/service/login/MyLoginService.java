package service.login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import main.Main;

import org.jdesktop.swingx.auth.LoginService;

import service.io.IO;

public class MyLoginService extends LoginService {
	
	public MyLoginService() {
		
	}
	
	public boolean authenticate(String name, char[] pass, String server) {
		String password = new String(pass);
		File file = new File("file/usr/" + name + ".txt");
		if (file.isFile()) {
			HashMap<String, String> map = IO.retrieveHashMapFromFile(file);
			if (map.get("password").equals(password)) {
				try {
					PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(new File("file/sys/log/log.txt"))));
					w.println("log:" + map.get("id"));
					w.println("logtype:" + map.get("type"));
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Main.setPanel(Main.PANELS.LOGGED_IN);
				return true;
			}
		}
		return false;
	}
}
