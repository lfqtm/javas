package com.javas.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server2 {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(1000);
		ExecutorService threadPool = Executors.newFixedThreadPool(10);

		while (true) {
			Socket socket = serverSocket.accept();
			threadPool.submit(new SocketThread(socket));
		}

	}
}
