package com.examples.pratha;

class A {
	 Object show() {
		System.out.println("class A ");
		return "A";
	}
}


class B extends A {
	 String show() {
		System.out.println("class B ");
		return  "B";
	}
}

public class Test {
	
	public static void main(String[] args) {
		
		A a = new B();
		System.out.println(a.show());

	}

}
