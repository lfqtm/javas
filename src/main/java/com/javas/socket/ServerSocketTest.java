package com.javas.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(10086);
		Socket socket = serverSocket.accept();

		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(br.readLine());

		br.close();
		socket.close();
		serverSocket.close();


	}
}
