package com.javas.file;

import sun.nio.cs.ext.GBK;

import java.io.*;

//转换流
public class InputStreamReaderTest {

	private static final String GBK = "GBK";
	private static final String UTF_8 = "UTF-8";


	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\1.javase" +
			"\\day11【缓冲流、转换流、序列化流、装饰者模式、commons-io工具包】\\01_笔记\\gbk文件.txt"), GBK);

		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("F:\\1.javase" +
			"\\day11【缓冲流、转换流、序列化流、装饰者模式、commons-io工具包】\\01_笔记\\utf8文件.txt"), UTF_8);
		System.out.println(isr.getEncoding());

		char[] chs = new char[1024];
		int len;
		while ((len = isr.read(chs)) != -1) { //gbk读入
			osw.write(new String(chs, 0, len));
		}

		isr.close();
		osw.close();

	}
}
