package com.javas.file;

import java.io.*;

public class BufferReaderTest {
	public static void main(String[] args) throws IOException {
		// 创建高效的字符输出流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\idea\\javas\\src\\main\\resources\\bf1.txt"));
		// void newLine​()：写一个行分隔符，会根据操作系统的不同,写入不同的行分隔符
		bw.write("远桥之下泛莲舟");
		bw.newLine();
		bw.newLine();
		bw.write("岱岩石上松溪流");
		bw.newLine();
		bw.write("万仞翠山梨亭在");
		bw.newLine();
		bw.write("莫闻空谷声悠悠");
		bw.flush();
		bw.close();

		BufferedReader br = new BufferedReader(new FileReader("F:\\idea\\javas\\src\\main\\resources\\bf1.txt"));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		br.close();
	}
}
