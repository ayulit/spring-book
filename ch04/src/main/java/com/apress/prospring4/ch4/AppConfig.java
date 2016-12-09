package com.apress.prospring4.ch4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *		Simple JavaBean component for config instead of XML
 **/

@Configuration
//@ImportResource(value="classpath:META-INF/spring/app-context-xml.xml") // for import from XML
@PropertySource(value="classpath:message.properties") // for property load
@ComponentScan(basePackages={"com.apress.prospring4.ch4"}) // for scanning for annotations
@EnableTransactionManagement // Spring transaction management tool will be used (see chapter 09)
public class AppConfig {
	@Autowired
	Environment env;
	
	@Bean // = <bean> 
	@Lazy(value=true) // create bean only when requested
	public MessageProvider messageProvider(){
		return new ConfigurableMessageProvider(env.getProperty("message"));
	}
	@Bean // = <bean>
	@Scope(value="prototype") // область действия бина
	@DependsOn(value="messageProvider") // so we point, that 'messageProvider' bean should be created FIRST!
	public MessageRenderer messageRenderer() {
		MessageRenderer renderer = new StandartOutMessageRenderer();
		
		renderer.setMessageProvider(messageProvider());
		
		return renderer;
	}

}
