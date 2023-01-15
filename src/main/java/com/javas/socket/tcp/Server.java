package com.javas.socket.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(10000);

		while (true) {
			Socket socket = serverSocket.accept();

			//把网络的字节输入流转化为高效的字节输入流
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
			//创建本地的高效字节输出流
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\1.javase\\img\\" + UUID.randomUUID() + ".png"));

			byte[] bys = new byte[1024];
			int len;
			while ((len = bis.read(bys)) != -1) {
				bos.write(bys);
				bos.flush();
			}

			bos.close(); //本地流关闭

			// ===============反馈===============
			//将网络字节输出流转化为高效的字符输出流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("感谢，很好看！");
			bw.newLine(); //必须加
			bw.flush();

		}

	}
}
