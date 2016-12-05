package com.apress.prospring.ch3;

// for rendering message
public interface MessageRenderer {
	
	void render();
	
	// MessageProvider depends on MessageRenderer
	void setMessageProvider(MessageProvider provider); // JavaBean style
	MessageProvider getMessageProvider(); 
}
