package com.examples.pratha;

import java.io.IOException;

public class ThreadExample02 {

	public static void main(String[] args) {
		
		Thread th1 = new Thread( () -> {
			for(int i = 0; i <10; i+=2 ) {
				System.out.println("Even :"+i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() +" is interupted ");	
					e.printStackTrace();
					//System.exit(++i);
					return;
				}
			}
		}); 
		
		Thread th2 = new Thread( () -> {
			for(int i=1; i<10; i+=2) {
				System.out.println("Odd :"+i);
			}
		});
		
		th1.start();
		th2.start();
	//	th1.interrupt();
		System.out.println(th1.getName() +" is interupted : "+ th1.isInterrupted());
		System.out.println(th2.getName() +" is interupted : "+ th2.isInterrupted());
		
		
		/*for(int i=1; i<100; i+=2) {
			System.out.println("Test :"+i);
		} */
		
		

	}

}
