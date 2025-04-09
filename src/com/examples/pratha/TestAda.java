package com.examples.pratha;

public class TestAda {
	
    public static void main(String[] args) {
    	
    	String[] arr = new String[] {"200", "301", "500"};
    	process(10, arr);

    }
	
	
	
	@SuppressWarnings("removal")
	public static void process(int num, String[] inputArrays) {
		int total = 0;
		if(num % 2 == 0) {
			for(int i =0; i < inputArrays.length; i++) {
				
				if (Integer.parseInt(inputArrays[i]) % 2 != 0 ) {
					
					 total = new Integer(inputArrays[i]) + total;
				}
				
			}
		}else {
			
			for(int i =0; i < inputArrays.length; i++) {
				
				if (Integer.parseInt(inputArrays[i]) % 2 == 0 ) {
					
					 total = new Integer(inputArrays[i]) + total;
				}
							
		}
		
	}
		
		System.out.println(total);

}
}
