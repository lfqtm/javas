package com.javas.file;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("F:\\idea\\javas\\cba.txt");
		byte[] bt = new byte[1024];
		int len;
		while ((len = fis.read(bt)) != -1) {
			System.out.print(new String(bt, 0, len));
		}


	}
}
