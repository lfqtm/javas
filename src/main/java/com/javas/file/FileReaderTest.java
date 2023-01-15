package com.javas.file;


import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("F:\\idea\\javas\\src\\main\\resources\\read.txt");

//		int ch;
//		while ((ch = fr.read()) != -1) {
//			System.out.print((char) ch);
//		}
//		fr.close();

		char[] chs = new char[1024];
		int len;
		while ((len = fr.read(chs)) != -1) {
			System.out.println(new String(chs, 0, len));
		}
		fr.close();


	}
}
