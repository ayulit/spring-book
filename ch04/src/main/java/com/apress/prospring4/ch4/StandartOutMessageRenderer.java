package com.apress.prospring4.ch4;


import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named("messageRendererJSR330")
@Singleton
public class StandartOutMessageRenderer implements MessageRenderer {

	@Inject
	@Named("messageProviderJSR330")
	private MessageProvider messageProvider = null;
	
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
