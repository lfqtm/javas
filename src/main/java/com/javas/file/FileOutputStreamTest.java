package com.javas.file;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("./abc.txt", true);

		fileOutputStream.write(97);
		fileOutputStream.write(98);
		fileOutputStream.write(99);

		fileOutputStream.write("我很nb".getBytes());
		fileOutputStream.write("\r\n".getBytes());

		for (int i = 0; i < 10; i++) {
			fileOutputStream.write("hello".getBytes());
			fileOutputStream.write("\r\n".getBytes());
		}

		fileOutputStream.close();

	}
}
