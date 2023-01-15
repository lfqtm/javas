package com.javas.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool1 {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

		threadPool.submit(new Student("小明"));
		threadPool.submit(new Student("小花"));
		threadPool.submit(new Student("小金"));
		threadPool.submit(new Student("小黑"));
		threadPool.submit(new Student("小兰"));

//		threadPool.shutdown();
	}
}

class Student implements Runnable {
	private String name;

	public Student(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在教" + name + "号学员游泳");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
