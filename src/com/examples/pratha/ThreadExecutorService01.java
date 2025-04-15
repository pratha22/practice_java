package com.examples.pratha;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadExecutorService01 {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute( 
				()-> System.out.println("Thread "+ Thread.currentThread().getName())
					
		);
		service.execute(new Thread( ()-> 
		{
			System.out.println("Thread "+ Thread.currentThread().getName());
		}));
		service.execute( new Thread( ()-> {
			System.out.println("Thread "+ Thread.currentThread().getName());
		}));
		
		//service.shutdown();
		
		
		 Future<?> result =  service.submit(
				() -> {
					System.out.println("Thread submit "+ Thread.currentThread().getName());
					for(int i = 0; i<10; i++) {
						System.out.println(i);
						try {
							Thread.sleep(8);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				);
		 
		 try {
			var value = result.get(10, TimeUnit.MILLISECONDS);
			if (value == null) {
				System.out.println("task is completed !");
			}else {
				System.out.println("task is not completed...");
			}
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
              System.out.println("Task not complete ... in catch");
       			e.printStackTrace();
		}
		
	}

}
