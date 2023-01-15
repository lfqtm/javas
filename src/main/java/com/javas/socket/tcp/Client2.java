package com.javas.socket.tcp;

import java.io.*;
import java.net.Socket;

public class Client2 {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 1000);

		//本地文件读入内存
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\1.javase\\3.jpg"));
		//网络输出流
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

		byte[] bys = new byte[1024];
		int len;
		while ((len = bis.read(bys)) != -1) {
			bos.write(bys);
			bos.flush();
		}

		socket.shutdownOutput();

		//===等待服务端反馈===

		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(br.readLine());

		bis.close();
		bos.close();
		br.close();
		socket.close();


	}
}
