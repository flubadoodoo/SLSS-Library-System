package service.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class IO {
	
	public static HashMap<String, String> retrieveHashMapFromFile(File file) {
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
	
	public static void writeHashMapToFile(HashMap<String, String> map, File file) {
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
}
