package com.javas.thread.threadcommuciate;

public class Wait {
	public static void main(String[] args) {

		Object lock = new Object();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("线程执行第一次..");

					try {
						System.out.println("线程执行第二次..");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("线程执行第三次..");
				}


			}
		}).start();



	}
}
