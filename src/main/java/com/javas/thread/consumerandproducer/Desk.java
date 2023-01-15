package com.javas.thread.consumerandproducer;

/**
 * 共享资源
 */
public class Desk {
	//剩余个数
	public static int count = 10;
	//桌子上还有面包吗？
	public static boolean flag = false;
	//锁对象
	public static final Object LOCK = new Object();
}
