package com.javas.file;

import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Stream;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		Properties pps = new Properties();
		pps.put("username", "zhangshan");
		pps.put("sex", "male");
		pps.setProperty("age", "18");

		Set<String> set = pps.stringPropertyNames();
		for (String s : set) {
			System.out.println(s +" = " + pps.getProperty(s));
		}

//		FileOutputStream fis = new FileOutputStream("F:\\idea\\javas\\src\\student.properties");
//		pps.store(new BufferedOutputStream(fis), null);

//		FileInputStream fis = new FileInputStream("F:\\idea\\javas\\src\\student.properties");
//		pps.load(new BufferedInputStream(fis));
//		String username = pps.getProperty("username");
//		System.out.println("username = " + username);

		ResourceBundle bundle = ResourceBundle.getBundle("user");
		String name = bundle.getString("name");
		System.out.println("name = " + name);


	}
}
