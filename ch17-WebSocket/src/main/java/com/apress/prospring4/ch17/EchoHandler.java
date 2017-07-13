package com.apress.prospring4.ch17;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

/** Subclass of standard class TextWeÜSocketíandler
 *  for dealing with String messages */
public class EchoHandler extends TextWebSocketHandler {

    /* Just echo for this time: resending message back as it is */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException {
        session.sendMessage(new TextMessage(textMessage.getPayload()));        
    }

}
