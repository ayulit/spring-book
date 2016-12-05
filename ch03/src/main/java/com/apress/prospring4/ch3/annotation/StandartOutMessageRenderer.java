package com.apress.prospring4.ch3.annotation;

import org.springframework.stereotype.Service;
import com.apress.prospring.ch3.MessageRenderer;
import com.apress.prospring.ch3.MessageProvider;

@Service("messageRenderer")
public class StandartOutMessageRenderer implements MessageRenderer {

	private MessageProvider messageProvider;
	
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException(
					"You must set the property messageProvider of class:"
			        + StandartOutMessageRenderer.class.getName());
		}
		
		System.out.println(messageProvider.getMessage());

	}

	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;
	}

	public MessageProvider getMessageProvider() {
		// TODO Auto-generated method stub
		return this.messageProvider;
	}

}
