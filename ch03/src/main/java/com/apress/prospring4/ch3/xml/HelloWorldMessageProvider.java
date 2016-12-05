package com.apress.prospring4.ch3.xml;

import com.apress.prospring.ch3.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
	
	public String getMessage() {
		return "Hello World!";
	}

}
