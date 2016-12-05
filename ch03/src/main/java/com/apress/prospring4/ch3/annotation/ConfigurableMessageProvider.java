package com.apress.prospring4.ch3.annotation;

import com.apress.prospring.ch3.MessageProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {

	private String message;
	
	@Autowired
	public ConfigurableMessageProvider(@Value("Configurable message annot")
			String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
