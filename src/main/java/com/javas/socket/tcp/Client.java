package com.javas.socket.tcp;

import java.io.*;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 10000);

		//本地文件读入内存
		//使用高效的字节输入流
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\1.javase\\2.png"));

		//使用高效的网络字节输出流
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

		//从bis中读入字节再发送到服务端
		byte[] bys = new byte[1024];
		int len;
		while ((len = bis.read(bys)) != -1) {
			bos.write(bys);
			bos.flush();
		}
		//发送结束标记
		socket.shutdownOutput();

		//============等待服务端反馈===========
		//网络的字节输出流转化为高效的字符输出流
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(br.readLine());

		//关闭资源
		bis.close();
		bos.close();
		br.close();
		socket.close();

	}
}
