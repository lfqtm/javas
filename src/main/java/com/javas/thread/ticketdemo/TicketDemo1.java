package com.javas.thread.ticketdemo;

public class TicketDemo1 {

	public static void main(String[] args) {

		Ticket ticket = new Ticket();

		new Thread(ticket, "窗口1").start();
		new Thread(ticket, "窗口2").start();
		new Thread(ticket, "窗口3").start();

	}


}

class Ticket implements Runnable {

	private int ticketNums = 100;

	@Override
	public void run() {
		for (;;) {
			if (ticketNums > 0) {
				ticketNums--;
				System.out.println(Thread.currentThread().getName() + "卖出了一张票，还剩余" + ticketNums + "张票！");
			} else {
				break;
			}

			//提高重复概率
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
