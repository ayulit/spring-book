package com.apress.prospring4.ch2;

public class HelloWorldDecoupled {

	public static void main(String[] args) {
		
		// Problem: changes in realisation of ifs mean code moifify! Fabric class needed
		MessageRenderer mr = new StandartOutMessageRenderer();
		MessageProvider mp = new HelloWorldMessageProvider();
		
		mr.setMessageProvider(mp);
		mr.render();
	}

}
