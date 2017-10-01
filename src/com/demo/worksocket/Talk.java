package com.demo.worksocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Timer;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/talk")
public class Talk {

	@OnMessage
    public void echoTextMessage(Session session, String msg, boolean last) {
      
        Tesker t=new Tesker(session);
       
        Timer task=new Timer();
        task.schedule(t, 1000, 1000);
    }

    @OnMessage
    public void echoBinaryMessage(Session session, ByteBuffer bb,
            boolean last) {
        try {
            if (session.isOpen()) {
                session.getBasicRemote().sendBinary(bb, last);
            }
        } catch (IOException e) {
            try {
                session.close();
            } catch (IOException e1) {
                // Ignore
            }
        }
    }
	
}
