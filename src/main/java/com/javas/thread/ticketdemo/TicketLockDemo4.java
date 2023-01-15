package com.javas.thread.ticketdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketLockDemo4 {
	public static void main(String[] args) {
		Ticket4 ticket4 = new Ticket4();
		new Thread(ticket4, "窗口1").start();
		new Thread(ticket4, "窗口2").start();
		new Thread(ticket4, "窗口3").start();
	}
}

class Ticket4 implements Runnable {

	private int ticketNums = 100;
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {

		while (true) {
			try {
				lock.lock();
//			lock.lock(); //这样写锁一直会被占用，使用try-catch-finally
				if (ticketNums > 0)
					System.out.println(Thread.currentThread().getName() + "卖出了1张票，剩余" + --ticketNums);
				else
					break;
//			lock.unlock();
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}

	}
}
