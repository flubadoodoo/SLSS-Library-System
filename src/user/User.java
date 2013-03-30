package user;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import service.io.IO;
import user.librarian.Librarian;
import user.student.Student;

public abstract class User {
	
	private HashMap<String, String> map;
	
	public static enum USER_STANDARDS {
		NAME, ID, TYPE, PASSWORD, LOG_TYPE, LOG_ID
	};
	
	public static enum USER_ATTRIBUTE {
		NAME, ID, TYPE, PASSWORD
	};
	
	public static enum USER_TYPES {
		STUDENT, LIBRARIAN
	};
	
	public User() {
		map = new HashMap<String, String>();
	}
	
	public User(HashMap<String, String> map) {
		this.map = map;
	}
	
	public String get(USER_ATTRIBUTE request) {
		switch (request) {
		case ID:
			return map.get("id");
		case NAME:
			return map.get("name");
		case TYPE:
			return map.get("type");
		case PASSWORD:
			return map.get("password");
		default:
			return "";
		}
	}
	
	public static String getStandard(USER_STANDARDS request) {
		switch (request) {
		case ID:
			return "id";
		case LOG_ID:
			return "logname";
		case LOG_TYPE:
			return "logtype";
		case NAME:
			return "name";
		case PASSWORD:
			return "password";
		case TYPE:
			return "type";
		default:
			return "void";
		}
	}
	
	public static String getType(USER_TYPES request) {
		switch (request) {
		case LIBRARIAN:
			return "librarian";
		case STUDENT:
			return "student";
		default:
			return "";
		}
	}
	
	public File getFile() {
		return new File("file/usr/" + getName() + ".txt");
	}
	
	public String toString() {
		return getMap().get("name");
	}
	
	public String getName() {
		return map.get("name");
	}
	
	public String getID() {
		return map.get("id");
	}
	
	public static boolean initializeUser(String name, String password) {
		File file = new File("file/usr/" + name + ".txt");
		try {
			if (file.createNewFile()) {
				HashMap<String, String> map = new HashMap<>();
				map.put("id", name);
				map.put("password", password);
				map.put("name", map.get("id"));
				User user;
				if (name.charAt(0) == 's' || name.charAt(0) == 'S') {
					map.put("type", "librarian");
					user = new Librarian(map);
				} else {
					map.put("type", "student");
					user = new Student(map);
				}
				IO.writeStudent(user);
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public HashMap<String, String> getMap() {
		return map;
	}
	
	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	
}
