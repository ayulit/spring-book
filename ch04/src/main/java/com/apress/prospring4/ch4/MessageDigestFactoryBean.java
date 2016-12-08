package com.apress.prospring4.ch4;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

// Factory
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {

	private String algorithmName = "MD5"; // default value
	
	private MessageDigest messageDigest = null;

	// for extracting object, created by the FactoryBean
	public MessageDigest getObject() throws Exception {		
		return messageDigest;
	}
	
	// for type return
	public Class<MessageDigest> getObjectType() {
		return MessageDigest.class;
	}
	
	// it is needed
	public boolean isSingleton() {		
		return true;
	}

	// factory creates object w/o new() during bean "digester" initialize
	public void afterPropertiesSet() throws Exception {		
		messageDigest = MessageDigest.getInstance(algorithmName);		
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	
}
