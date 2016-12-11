package com.apress.prospring4.ch4;

import javax.inject.Inject;
import javax.inject.Named;

@Named("messageProviderJSR330")
public class ConfigurableMessageProvider implements MessageProvider {

	private String message = "Default message";
	
	public ConfigurableMessageProvider() {
		
	}

	@Inject
	@Named("messageJSR330")
	public ConfigurableMessageProvider(String message) {
		this.message = message;		
	}
	
	public void setMessage(String message) {
		this.message = message;	
	}
	
	public String getMessage() {
		return message;
	}

}
