package com.examples.pratha.threads;


/* 
 * Important Conceptual Note:
Synchronization is object-level. So synchronized methods lock the object they’re invoked on.

In your code:

obj_01 and obj_02 are two different objects.

So th1 and th2 don’t block each other, even if the methods are synchronized — because they lock different monitors.

If you want to demonstrate thread blocking due to synchronization, you should have both threads call synchronized methods on the same object, like this:
 * 
 * 
 * ThreadSynchronizedExample01 sharedObj = new ThreadSynchronizedExample01();

Thread th1 = new Thread(() -> sharedObj.callSynchMethod(), "th1");
Thread th2 = new Thread(() -> sharedObj.callSynchMethod_02(), "th2");

 * */
public class ThreadSynchronizedExample01 {

	public static void main(String[] args) {
		ThreadSynchronizedExample01 obj_01 = new ThreadSynchronizedExample01 ();
		ThreadSynchronizedExample01 obj_02 = new ThreadSynchronizedExample01 ();

		
		Thread th1 = new Thread( () -> {
			obj_01.callSynchMethod();
			//callNonSyncMethod();
			}, "th1"		
				);

		Thread th2 = new Thread( () -> {
			obj_02.callSynchMethod();

			obj_02.callSynchMethod_02();
			//callNonSyncMethod();
			//callSynchMethod();
			}, "th2"	
				);

		Thread th3 = new Thread( () -> {
			obj_01.callSynchMethod();
			}, "th3"	
				);
		
		th1.start();
		th2.start();
		//th3.start();


	}

	private static void callNonSyncMethod() {
		for(int i=1; i <=2; i++) {
			System.out.println(" In NonSync "+ Thread.currentThread().getName()+ ": "+i);

		}		
	}

	private synchronized  void callSynchMethod() {
		
		
		for(int i=1; i <=3; i++) {
			System.out.println(" In Synch "+ Thread.currentThread().getName()+ ": "+i + ": " + this.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	}
	
	private synchronized  void callSynchMethod_02() {
		
		for(int i=1; i <=3; i++) {
			System.out.println(" In Synch 02 "+ Thread.currentThread().getName()+ ": "+i);

		}
	}

}


