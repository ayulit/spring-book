package com.apress.prospring4.ch2;

// problem: component responsible for rendering, also responsible for getting message 
public class HelloWorldWithCommandLine {

	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println(args[0]);
		} else {
			System.out.println("Hello World!");
		}

	}

}
