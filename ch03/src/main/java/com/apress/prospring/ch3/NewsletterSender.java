package com.apress.prospring.ch3;

public interface NewsletterSender {
	// JavaBean prop #1
	void setSmtpServer(String smtpServer);
	String getSmtpServer();
	
	// JavaBean prop #2
	void setFromAddress(String fromAddress);
	String getFromAddress();
	
	// Props: SmtpServer & FromAddress are NOT dependencies!
	// It's config details!
	
	void send(); // only business-method
}
