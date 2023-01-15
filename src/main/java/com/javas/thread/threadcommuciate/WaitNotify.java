package com.javas.thread.threadcommuciate;

public class WaitNotify {

	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {

		new Thread(() -> {
			synchronized (lock) {
				System.out.println("a执行一次");

				try {
					System.out.println("a执行二次");
					lock.wait(); //释放锁资源，丧失执行权
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("a执行三次");
			}
		}).start();

		Thread.sleep(2000);

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("b执行一次");

					System.out.println("b执行二次");
					lock.notify(); //不释放锁资源，继续执行完

					System.out.println("b执行三次");
				}
			}
		}).start();


	}


}
