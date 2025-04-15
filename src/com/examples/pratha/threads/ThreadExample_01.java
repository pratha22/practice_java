package com.examples.pratha.threads;

public class ThreadExample_01 {
	
	
	

	public static void main(String[] args) throws InterruptedException {
		
		Runnable runnableObj = () -> {
			System.out.println("My first thread started ");
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getState());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(" sleep is over");
			
		};
		
		Thread myThread1 = new Thread(runnableObj, "01 Runnable");
		myThread1.setDaemon(true); // if set true.. this thread will run in background and main thread will exit.. so "sleep is over will not get printed on console
		myThread1.start();
		

		Thread myThread2 = new Thread(runnableObj, "01 Runnable");
		myThread2.setDaemon(true); // if set true.. this thread will run in background and main thread will exit.. so "sleep is over will not get printed on console
		myThread2.start();
		
		 
		//myThread.join();
		
		System.out.println("Main thread Ends");

	}

}
