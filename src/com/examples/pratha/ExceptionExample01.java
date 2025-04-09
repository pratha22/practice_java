package com.examples.pratha;

class CustomException extends Exception{
	
	int num;
	

	public CustomException(int num) {
		this.num = num;
	}

	
	 public String toString() {
		 return Integer.toString(num);
	 }
}


public class ExceptionExample01{
	
	static void calculate (int n )throws CustomException {
		throw  new CustomException(n);
	}

	public static void main(String[] args) {
		try {
			calculate(42);
			}catch(CustomException e) {
				System.out.println("Catch22");
		}
	}

}
