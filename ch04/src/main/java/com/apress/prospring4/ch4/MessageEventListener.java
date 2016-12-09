package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationListener;

/**
 * 	Class listener of event
 * */
public class MessageEventListener implements ApplicationListener<MessageEvent> {

	// single method of ApplicationListener IF
	public void onApplicationEvent(MessageEvent event) {
		
		MessageEvent msgEvt = (MessageEvent) event;
		System.out.println("Recieved: " + msgEvt.getMessage());		
	}

}
