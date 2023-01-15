package com.javas.thread.threadpool;

import java.util.concurrent.*;

public class ThreadPool2 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		ExecutorService pool = Executors.newFixedThreadPool(5);

		Future<Integer> fu = pool.submit(new Calc(100));
		Integer result = fu.get();
		System.out.println("result = " + result);

		pool.shutdown();
	}
}

class Calc implements Callable<Integer> {
	private int n;
	static int sum;

	public Calc(int n) {
		this.n = n;
	}

	@Override
	public Integer call() throws Exception {
		for (int i = 0; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
}
