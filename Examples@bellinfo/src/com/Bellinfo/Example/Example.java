package com.Bellinfo.Example;


public class Example {
	String name ="Dinesh";
	
	
	void Example1 (String name) {
		this.name = name;
		System.out.println(name);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example e = new Example();
		e.Example1("Kasula");
	}

}
