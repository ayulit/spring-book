package com.apress.prospring4.ch4;

// for rendering message
public interface MessageRenderer {
	void render();
	// MessageProvider depends on MessageRenderer
	void setMessageProvider(MessageProvider provider); // JavaBean style
	MessageProvider getMessageProvider(); 
}
