package com.examples.pratha.threads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAtomicExample01 {

	private static int counterInt = 0;
	private static AtomicInteger counterAtomic = new AtomicInteger(0);
	
	static AtomicBoolean boolAtomic = new AtomicBoolean(!true);

	public static void main(String[] args) {
	

		System.out.println(boolAtomic.get());
		
		Thread th1 = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				counterInt++;
				counterAtomic.incrementAndGet();
			}

		});

		Thread th2 = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				counterInt++;
				counterAtomic.incrementAndGet();
			}

		});

		th1.start();
		th2.start();
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" counterInt : " + counterInt); // everytime will get diff result
		System.out.println(" counterAtomic : " + counterAtomic); // everytime will get same exact result 

	}

}
