package com.apress.prospring.ch3;

// Singleton pattern
public class Singleton {
	private static Singleton instance;
	
	static {
		instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return instance;
	}

}
