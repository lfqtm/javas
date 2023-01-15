package com.javas.thread.threadcommuciate;

public class WaitNotify2 {

	static boolean flag = true;

	public static void main(String[] args) {
		final Object LOCK = new Object();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (LOCK) {
						if (flag) {
							System.out.println("我");
							flag = !flag;
							LOCK.notify();
						} else {
							try {
								LOCK.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}

			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (LOCK) {
						if (flag) {
							try {
								LOCK.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else {
							System.out.println("帅");
							flag = !flag;
							LOCK.notify();
						}
					}
				}

			}
		}).start();


	}
}
