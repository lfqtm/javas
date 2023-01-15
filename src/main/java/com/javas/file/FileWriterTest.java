package com.javas.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的名字：");
		String username = sc.nextLine();

		System.out.println("请输入你的密码：");
		String password = sc.nextLine();

		FileWriter fw = new FileWriter("./javas/abc.txt");
		fw.write(username);
		fw.flush();
		fw.write("\r\n");
		fw.write(password);
		fw.close(); //close前会flush

	}
}
