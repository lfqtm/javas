package com.javas.thread;

public class MyThread {


	public static void main(String[] args) throws InterruptedException {
		MyThreads myThreads = new MyThreads();
		myThreads.start();

		myThreads.join(); //阻塞，等待该线程死亡
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}

}

class MyThreads extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(getName() + " : " + i);
		}
	}
}
