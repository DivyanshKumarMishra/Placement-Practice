package com.divyansh.collections.ComparablesAndComparators;

public class AnonymousClassesAndLambdaExpressions {

	@FunctionalInterface
	static interface Phone{
		
		public void Ring();
	}
	
	//naive approach of creating a class
	static class SmartPhone implements Phone{

		@Override
		public void Ring() {
			System.out.println("This is a smartphone ringing");
		}
	}
	
	public static void main(String[] args) {
		
		Phone ph1 = new SmartPhone();
		ph1.Ring();
		
		//Use of Anonymous Class		
		Phone ph2 = new Phone() {
			public void Ring() {
				System.out.println("This is a smartphone ringing");
			}
		};
		ph2.Ring();
		
		//Use of lambda expression
		Phone ph3 = () -> {System.out.println("This is a smartphone ringing");};
		ph3.Ring();
	}	
}
