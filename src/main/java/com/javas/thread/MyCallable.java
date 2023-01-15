package com.javas.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable {

	public static void main(String[] args) {
		MyCallables myCallables = new MyCallables();
		FutureTask<String> task = new FutureTask<>(myCallables); //桥梁
		Thread thread = new Thread(task, "新线程");
		thread.start();

		try {
			String s = task.get(); //获取线程返回值 阻塞作用
			System.out.println("s = " + s);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 101; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}

}

class MyCallables implements Callable<String> {

	@Override
	public String call() throws Exception {
		String name = Thread.currentThread().getName();
		for (int i = 1; i < 101; i++) {
			System.out.println(name + " : " + i);
		}
		return name + "结束！";
	}
}
