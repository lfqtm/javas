package com.javas.file;


import java.io.*;

//使用buffer和writer进行copy任务
public class Copy2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("F:\\idea\\javas\\src\\main\\resources\\read.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\idea\\javas\\src\\main\\resources\\copy2.txt"));

		char[] chs = new char[1024];
		int len;
		while ((len = br.read(chs)) != -1) {
			bw.write(new String(chs, 0, len));
		}

		br.close();
		bw.close();


	}
}
