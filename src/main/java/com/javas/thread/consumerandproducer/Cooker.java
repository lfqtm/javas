package com.javas.thread.consumerandproducer;

public class Cooker implements Runnable {
	@Override
	public void run() {

		while (true) {
			if (Desk.count == 0) {
				break;
			}
		}

	}
}
