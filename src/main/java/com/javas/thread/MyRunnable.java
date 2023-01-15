package com.javas.thread;

public class MyRunnable {

	public static void main(String[] args) {
		Thread thread = new Thread(new MyRunnables());
		thread.start();

		for (int i = 1; i < 101; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
}

class MyRunnables implements Runnable {

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for (int i = 1; i < 101; i++) {
			System.out.println(name + " : " + i);
		}
	}
}
