package com.apress.prospring4.ch4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *		Simple JavaBean component for config instead of XML
 **/

@Configuration
public class AppConfig {
	
	@Bean // = <bean> 
	public MessageProvider messageProvider(){
		return new ConfigurableMessageProvider();
	}
	@Bean // = <bean>
	public MessageRenderer messageRenderer() {
		MessageRenderer renderer = new StandartOutMessageRenderer();
		
		renderer.setMessageProvider(messageProvider());
		
		return renderer;
	}

}
