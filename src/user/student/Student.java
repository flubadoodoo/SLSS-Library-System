package user.student;

import java.util.HashMap;

import library.books.Book;
import service.io.IO;
import user.User;

public class Student extends User {
	
	public Student(HashMap<String, String> map) {
		super(map);
	}
	
	public Student(String id, String name, Book[] books) {
		super();
		getMap().put("id", id);
		getMap().put("name", name);
		//		map.put("books", books);
	}
	
	public static Student getStudent(String name) {
		User user = IO.retrieveUser(name);
		if (user instanceof Student) {
			return (Student) user;
		}
		return null;
	}
	
}
