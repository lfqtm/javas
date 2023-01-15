package com.javas.thread.ticketdemo;

public class TicketDemo3 {
	public static void main(String[] args) {
//		Ticket3 ticket1 = new Ticket3();
//		Ticket3 ticket2 = new Ticket3();
		Ticket3 ticket3 = new Ticket3();
//		new Thread(ticket1, "窗口1").start();
//		new Thread(ticket2, "窗口2").start();
		new Thread(ticket3, "窗口3").start();
	}
}

class Ticket3 implements Runnable {

	private int ticketNums = 100;

	@Override
	public void run() {
		while (true) {
			if (method()) break;

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	//非static方法，锁对象为this
	//如果main方法中 new Thread(x, "窗口1").start() 的x为不同的对象，就还是会出现线程安全问题
	private synchronized boolean method() {
		if (ticketNums > 0)
			System.out.println(Thread.currentThread().getName() + "卖出了1张票，剩余" + --ticketNums);
		else
			return true;
		return false;
	}
}
