package com.apress.prospring4.ch2;

import java.io.FileInputStream;
import java.util.Properties;


public class MessageSupportFactory {
	
	private static MessageSupportFactory instance;
	
	private Properties props;
	
	// interfaces
	private MessageRenderer renderer;
	private MessageProvider provider;
	
	// constructor
	private MessageSupportFactory() {
		props = new Properties();
		
		try {
			// properties file
			props.load(new FileInputStream("msf.properties"));
			
			String rendererClass = props.getProperty("renderer.class");
			String providerClass = props.getProperty("provider.class");
			
			renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
			provider = (MessageProvider) Class.forName(providerClass).newInstance();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static {
		instance = new MessageSupportFactory();
	}
	
	public static MessageSupportFactory getInstance() {
		return instance;
	}
	
	public MessageRenderer getMessageRenderer() {
		return renderer;
	}
	
	public MessageProvider getMessageProvider() {
		return provider;
	}
	
}
