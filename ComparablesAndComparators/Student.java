package com.divyansh.collections.ComparablesAndComparators;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

//naive approach
public class Student implements Comparable<Student>{
	
	int marks;
	String name;
	
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

	public Student(int marks, String name) {
		super();
		this.marks = marks;
		this.name = name;
	}
	
	public int compareTo(Student obj) {
		if(this.name.compareTo(obj.name)==0) {
			return this.marks - obj.marks;
		}
		else return this.name.compareTo(obj.name);
	}
	
	public static void main(String[] args) {
		
		 LinkedList<Student> students = new LinkedList<Student>();
		 
		 students.add(new Student(67, "Divyansh Mishra"));
		 students.add(new Student(89, "Sakshi Verma"));
		 students.add(new Student(73, "Aman Gupta"));
		 students.add(new Student(45, "Dipankar"));
		 students.add(new Student(56, "Vipul"));
		 
		 Collections.sort(students);
		 
		 for(Student s:students) {
			 System.out.println(s);
		 }
	}
}