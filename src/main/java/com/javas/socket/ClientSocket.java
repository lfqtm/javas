package com.javas.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSocket {
	public static void main(String[] args) throws IOException {
		// 创建socket客户端
		Socket socket = new Socket("127.0.0.1", 10086);
		// 获取网络字节输出流
		OutputStream os = socket.getOutputStream();
		// 字节输出流转换为字符输出流
		OutputStreamWriter osw = new OutputStreamWriter(os);
		// 字符输出流转化为高效的字符输出流
		BufferedWriter bw = new BufferedWriter(osw);

		bw.write("hello?");
		bw.newLine();
		bw.flush();

//		socket.shutdownOutput();
		os.close();
		osw.close();
		bw.close();
		socket.close();


	}
}
