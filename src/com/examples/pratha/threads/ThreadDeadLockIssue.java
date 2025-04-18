package com.examples.pratha.threads;


class Account {
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	private int balance = 0;
	
	public Account( int balance) {
		this.balance = balance;
	}
	
	public int withdraw(int amt) {
		return this.balance -= amt;
	}
	
	public int deposit(int amt) {
		return this.balance += amt;
	}
	
	public boolean transfer(Account toAccount, int amt) {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + ": transferring.....");

			synchronized (toAccount) {
				this.balance = this.withdraw(amt);
				toAccount.balance = toAccount.deposit(amt);
				System.out.println(Thread.currentThread().getName() + ": transferred.....");
			}
		}
		return true;
	}
	
	
	public boolean transfer_optimized(Account toAccount, int amt) { /// solved dead loack issue by maintaining lock oredr always
		
		Account accFirst = this.hashCode() < toAccount.hashCode() ? this : toAccount;
		Account accSecond = this.hashCode() < toAccount.hashCode() ? toAccount : this;
		
		synchronized (accFirst) {
			System.out.println(Thread.currentThread().getName() + ": transferring.....");

			synchronized (accSecond) {
				this.balance = this.withdraw(amt);
				toAccount.balance = toAccount.deposit(amt);
				System.out.println(Thread.currentThread().getName() + ": transferred.....");
			}
		}
		return true;
	}
	
	 public boolean transfer_01(Account target, int amount) {
	        synchronized (this) {
	            System.out.println(Thread.currentThread().getName() + " locked " + this);
	            try { Thread.sleep(100); } catch (InterruptedException e) {}

	            synchronized (target) {
	                System.out.println(Thread.currentThread().getName() + " locked " + target);
	                this.withdraw(amount);
	                target.deposit(amount);
	                System.out.println(Thread.currentThread().getName() + " transferred $" + amount);
	            }
	        }
	       return true; 
	    }
}

public class ThreadDeadLockIssue {
	

	public static void main(String[] args) {
		
		Account A = new Account(100);
		Account B = new Account(100);
		
		System.out.println("A hashcode "+ A.hashCode());
		System.out.println("B hashcode "+ B.hashCode());

		
		Thread th01 = new Thread (()-> {
			boolean status = A.transfer_optimized(B, 50);
			if(status) {
				System.out.println(Thread.currentThread().getName()+" : A balance : "+ A.getBalance());
				System.out.println(Thread.currentThread().getName()+" : B balance : "+ B.getBalance());

			}
		});
		
		Thread th02 = new Thread (()-> {
			boolean status = B.transfer_optimized(A, 20);
			if(status) {
				System.out.println(Thread.currentThread().getName()+" : A balance : "+ A.getBalance());
				System.out.println(Thread.currentThread().getName()+" : B balance : "+ B.getBalance());

			}
		});

        th01.start();
        th02.start();
	}

}
