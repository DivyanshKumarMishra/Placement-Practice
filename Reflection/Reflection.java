package com.divyansh.Reflection;

import java.lang.Class;
import java.lang.reflect.*;

class Person{
	
	private String name;
	private int age;
	
	public Person() {
		
	}
	
	private Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	private String greet(String name) {
		if(name == null || name.isEmpty()) {
			return "Hello Stranger";
		}
		else {
			return "Hello " + name;
		}
	}
}

public class Reflection {
	
	int[] phone = new int[10];

	public static void main(String[]  args) {
		
		Person obj = new Person();
		Reflection r = new Reflection();

		
		try{
			Class cls = obj.getClass();
			System.out.println("Class name is: " + cls.getClass());
			
			System.out.println("\n\n----------Displaying Methods of class and superclass----------");
			Method[] method1 = cls.getMethods();
			for(Method m: method1) {
				System.out.print(m.getName()+ " ");
			}
			System.out.println("\n\n----------Displaying Construtors of class and superclass----------");
			Constructor[] constructor1 = cls.getConstructors();
			for(Constructor c: constructor1) {
				System.out.print(c.getName()+ " ");
			}
			System.out.println("\n\n----------Displaying Fields of class and superclass----------");
			Field[] field1 = cls.getFields();
			for(Field f: field1) {
				System.out.print(f.getName()+ " ");
			}
			System.out.println("\n\n----------Displaying Methods of class----------");
			Method[] method2 = cls.getDeclaredMethods();
			for(Method m: method2) {
				System.out.print(m.getName()+ " ");
			}
			System.out.println("\n\n----------Displaying Construtors of class----------");
			Constructor[] constructor2 = cls.getDeclaredConstructors();
			for(Constructor c: constructor2) {
				System.out.print(c.getName()+ " ");
			}
			System.out.println("\n\n----------Displaying Fields of class----------");
			Field[] field2 = cls.getDeclaredFields();
			for(Field f: field2) {
				System.out.print(f.getName()+ " ");
			}
			
			System.out.println("\n\n----------Acccessing Private Methods of class----------");
			Method method = cls.getDeclaredMethod("greet", String.class);
			method.setAccessible(true);
			String result1 = (String) method.invoke(obj,"Divyansh");
			System.out.println(result1);
			
			System.out.println("\n\n----------Acccessing Private Methods of class----------");
			Field field = cls.getDeclaredField("age");
			field.setAccessible(true);
			field.set(obj,20);
			int result2 = field.getInt(obj);
			System.out.println("Age of person is:" + result2);
			
			System.out.println("\n\n----------Dynamially creating instance of class----------");
			Constructor con = cls.getDeclaredConstructor(String.class,int.class);
			con.setAccessible(true);
			Person p = (Person) con.newInstance("Divyansh",23);
			System.out.println(p.getName() +" " + p.getAge());
			
			System.out.println("\n\n----------checking if array exists in class----------");
			Class c = r.getClass();
			Field[] f = c.getDeclaredFields();
			for(Field fld : f) {
				Class type = fld.getType();
				if(type.isArray())
					System.out.println("Array present");
			}
			
			System.out.println("\n\n----------Dynamially creating an array in class----------");
			int[] phone = (int[]) Array.newInstance(int.class,10);
			Array.setInt(phone,0,8);
			Array.setInt(phone,1,0);
			Array.setInt(phone,2,0);
			Array.setInt(phone,3,4);
			Array.setInt(phone,4,2);
			Array.setInt(phone,5,0);
			Array.setInt(phone,6,3);
			Array.setInt(phone,7,4);
			Array.setInt(phone,8,3);
			Array.setInt(phone,9,5);
			for(int n: phone) {
				System.out.print(n);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
