package com.divyansh.collections.ComparablesAndComparators;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Student2{
	
	private int marks;
	private String name;
	
	public int getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "Student [marks=" + marks + ", name=" + name + "]";
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student2(int marks, String name) {
		super();
		this.marks = marks;
		this.name = name;
	}
	
	public static void main(String[] args) {
		
		 LinkedList<Student> students = new LinkedList<Student>();
		 
		 students.add(new Student(67, "Divyansh Mishra"));
		 students.add(new Student(89, "Sakshi Verma"));
		 students.add(new Student(73, "Aman Gupta"));
		 students.add(new Student(45, "Dipankar"));
		 students.add(new Student(56, "Vipul"));
		 
		//naive approach of passing object of Comparator
		 Collections.sort(students, new SortByNameThenMarks());
		 
		 for(Student s:students) {
			 System.out.println(s);
		 }
		 
		 System.out.println("---------------------------------------");
		 
		//use of Anonymous class
		 Collections.sort(students, new Comparator<Student>() {
				
				public int compare(Student o1, Student o2) {
					if(o1.name.compareTo(o2.name)==0) {
						return o1.marks - o2.marks;
					}
					else return o1.name.compareTo(o2.name);
				}
			});
		 
		 for(Student s:students) {
			 System.out.println(s);
		 }
		 
		 System.out.println("---------------------------------------");
		 
		 //use of lambda expression 
		 Collections.sort(students,(o1,o2)->{
				if(o1.name.compareTo(o2.name)==0) {
					return o1.marks - o2.marks;
				}
				else return o1.name.compareTo(o2.name);
			});
		 
		 for(Student s:students) {
			 System.out.println(s);
		 }
	}
}

class SortByNameThenMarks implements Comparator<Student>{
	
	public int compare(Student o1, Student o2) {
		if(o1.name.compareTo(o2.name)==0) {
			return o1.marks - o2.marks;
		}
		else return o1.name.compareTo(o2.name);
	}
}
