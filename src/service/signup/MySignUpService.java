package service.signup;

import java.io.File;
import java.util.HashMap;

import org.jdesktop.swingx.auth.LoginService;

import service.io.IO;

public class MySignUpService extends LoginService {
	
	public boolean authenticate(String name, char[] pass, String server) throws Exception {
		String password = new String(pass);
		File file = new File("file/usr/" + name + ".txt");
		if (file.createNewFile()) {
			HashMap<String, String> map = new HashMap<>();
			map.put("id", name);
			map.put("password", password);
			map.put("name", map.get("id"));
			if (name.charAt(0) == 's' || name.charAt(0) == 'S') {
				map.put("type", "librarian");
			} else {
				map.put("type", "student");
			}
			IO.writeHashMapToFile(map, file);
			return true;
		} else {
			return false;
		}
	}
	
}
