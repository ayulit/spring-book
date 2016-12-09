package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationEvent;

/**
 * 	Class of event
 * */
public class MessageEvent extends ApplicationEvent {

	private String msg;

	/**
	 * Constructor 
	 *
	 * @source - link for event source
	 * @msg    - some message, I think
	 */
	public MessageEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}
	
	// for print
	public String getMessage() {
		return msg;
	}

}
