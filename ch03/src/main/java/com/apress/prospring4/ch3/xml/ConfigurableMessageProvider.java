package com.apress.prospring4.ch3.xml;

import com.apress.prospring.ch3.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {

	private String message;
	
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
