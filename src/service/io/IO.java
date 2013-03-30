package service.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import user.User;
import user.User.USER_STANDARDS;
import user.User.USER_TYPES;
import user.librarian.Librarian;
import user.student.Student;

public class IO {
	
	public static User retrieveUser(String name) {
		HashMap<String, String> map = retrieveHashMapFromFile(new File("file/usr/" + name + ".txt"));
		User user;
		if (map.get("type").equals(User.getType(USER_TYPES.LIBRARIAN))) {
			user = new Librarian(map);
		} else {
			user = new Student(map);
		}
		return user;
	}
	
	private static HashMap<String, String> retrieveHashMapFromFile(File file) {
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			BufferedReader r = new BufferedReader(new FileReader(file));
			String s = r.readLine();
			if (s != null) {
				do {
					Scanner token = new Scanner(s);
					token.useDelimiter(":");
					String firstToken, secondToken;
					// just a check for two tokens
					if (token.hasNext()) {
						firstToken = token.next();
						if (token.hasNext()) {
							secondToken = token.next();
							map.put(firstToken, secondToken);
							s = r.readLine();
						}
					} else {
						break;
					}
					token.close();
				} while (s != null);
				r.close();
			}
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void writeStudent(User user) {
		writeHashMapToFile(user.getMap(), user.getFile());
	}
	
	private static void writeHashMapToFile(HashMap<String, String> map, File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (String key : map.keySet()) {
				writer.write(key + ":" + map.get(key) + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean retrieveLoggedInUserType() {
		HashMap<String, String> map = IO.retrieveHashMapFromFile(new File("file/sys/log/log.txt"));
		if (map.get(User.getStandard(USER_STANDARDS.LOG_TYPE)) != null) {
			return map.get(User.getStandard(USER_STANDARDS.LOG_TYPE)).equals(User.getType(USER_TYPES.LIBRARIAN));
		}
		return false;
	}
	
	public static String retrieveLoggedInUserName() {
		HashMap<String, String> map = IO.retrieveHashMapFromFile(new File("file/sys/log/log.txt"));
		if (map.get(User.getStandard(USER_STANDARDS.LOG_ID)) != null) {
			return map.get(User.getStandard(USER_STANDARDS.LOG_ID));
		}
		return "";
	}
}
