package com.javas.socket.tcp;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class SocketThread implements Runnable {
	private Socket socket;
	BufferedOutputStream bw;

	public SocketThread(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {

		try {
			// 获取网络中的字节输入流  在封装成高效的字节输入流对象
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

			// 创建本地的字节输出流 , 封装成高效的字节输出流
			 bw = new BufferedOutputStream(new FileOutputStream("F:\\1.javase\\img\\" + UUID.randomUUID() + ".jpg"));

			byte[] bys = new byte[1024];
			int len;
			while ((len = bis.read(bys)) != -1) {
				bw.write(bys);
				bw.flush();
			}
			// 获取网络中的字节输出流 , 封装成高效的字符输出流
			BufferedWriter socketBw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			socketBw.write("谢谢你");
			socketBw.newLine();// 必须有换行 , 因为readLine读到换行结束
			socketBw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//关闭本地流
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
