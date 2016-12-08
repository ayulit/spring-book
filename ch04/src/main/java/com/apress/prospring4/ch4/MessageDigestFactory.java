package com.apress.prospring4.ch4;

import java.security.MessageDigest;

// Factory
public class MessageDigestFactory {

	private String algorithmName = "MD5"; // default value

	public MessageDigest createInstance() throws Exception {
		return MessageDigest.getInstance(algorithmName);
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	
}
