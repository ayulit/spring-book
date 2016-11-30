package com.apress.prospring4.ch2;

public class HelloWorldDecoupledWithFactory {

	public static void main(String[] args) {
		
		// Using factory
		MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
		MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
		
		mr.setMessageProvider(mp);
		mr.render();

		/*
		 * Problems:
		 * 1. vast amount of code for connecting of all parts in one app,
		 *    keeping components weakly connected
		 * 2. Manual realization of MessageRenderer with instance of MessageProvider
		 * 
		 * We need to replace class MessageSupportFactory with Spring interface called ApplicationContext
		 * */
		
		
	}

}
