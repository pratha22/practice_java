package com.examples.pratha.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadExecutorService01 {

	public static void main(String[] args) {
		
		//method01();
		//method02();
		//method03();
		method04();

	}

	private static void method04() {
		
		ExecutorService exeSrvice1 = Executors.newCachedThreadPool();
		
		Future<Integer> result =  exeSrvice1.submit(() -> 10 +12);
		
		
		ExecutorService exeSrvice2 = Executors.newFixedThreadPool(3);
		
		ScheduledExecutorService exeSrvice3 = Executors.newScheduledThreadPool(3);

		

		
	}

	/* Schedule */
	private static void method03() {
		 ScheduledExecutorService scheduledService = Executors.newSingleThreadScheduledExecutor();
		 Callable<Integer> sumCall = () -> {
				int a = 7, b=3;
				return a+b;
			};
		ScheduledFuture<Integer> result =	scheduledService.schedule(sumCall, 0, TimeUnit.MICROSECONDS);
		/*try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(result);


		try {
			System.out.println(result.get());
			System.out.println(result);

		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* use Callable interface */
	private static void method02() {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Callable<Integer> sumCall = () -> {
			int a = 7, b=3;
			return a+b;
		};
		
		Future<Integer> result = service.submit(sumCall);
		
		try {
			System.out.println(result.get(10, TimeUnit.MILLISECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/*Use Runnable interface */
	public static void method01() {
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(() -> System.out.println("Thread " + Thread.currentThread().getName())

		);
		service.execute(new Thread(() -> {
			System.out.println("Thread " + Thread.currentThread().getName());
		}));
		service.execute(new Thread(() -> {
			System.out.println("Thread " + Thread.currentThread().getName());
		}));

		// service.shutdown();

		Future<?> result = service.submit(() -> {
			System.out.println("Thread submit " + Thread.currentThread().getName());
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		try {
			var value = result.get(10, TimeUnit.MILLISECONDS);
			if (value == null) {
				System.out.println("task is completed !");
			} else {
				System.out.println("task is not completed..."); /// this will never get executed.
			}
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Task not complete ... in catch");
			e.printStackTrace();
		}
	}

}
