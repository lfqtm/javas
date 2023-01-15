package com.javas.thread.ticketdemo;

public class TicketDemo2 {
	public static void main(String[] args) {
		Ticket2 ticket2 = new Ticket2();

		new Thread(ticket2, "窗口1").start();
		new Thread(ticket2, "窗口2").start();
		new Thread(ticket2, "窗口3").start();


	}

}


class Ticket2 implements Runnable {

	private int ticketNums = 100;
	private static final Object obj = new Object();

	@Override
	public void run() {
		while (true) {

			//同步代码块，锁对象要求是任意对象
//			synchronized (Ticket2.class) {
			synchronized (obj) {
				if (ticketNums > 0) {
					ticketNums--;
					System.out.println(Thread.currentThread().getName() + "卖出了一张票，剩余" + ticketNums + "~");
				} else
					break;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		}
	}
}
