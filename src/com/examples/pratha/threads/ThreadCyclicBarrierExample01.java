package com.examples.pratha.threads;

import java.lang.reflect.Method;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadCyclicBarrierExample01 {
	static CyclicBarrier cb = new CyclicBarrier(3);


	public static void main(String[] args) {
		
		
		
		Thread th1 = new Thread( () -> {
			method1();
		});

		Thread th2 = new Thread( () -> { method1();
		});

		Thread th3 = new Thread( () -> { method1();
		});

		Thread th4 = new Thread( () -> { method1();
		});
		
		th1.start();
		th2.start();
		th3.start();
	//	th4.start();

		
		
	}

	private static void method1() {
		System.out.println( Thread.currentThread().getName() + " is Performing task");
		System.out.println("*********************");

		

		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println( Thread.currentThread().getName() + " is Performed task");

		
	}

}
