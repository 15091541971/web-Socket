package com.demo.worksocket;

import java.io.IOException;
import java.util.TimerTask;

import javax.websocket.Session;

public class Tesker extends TimerTask{
    
    Session session;
    
	

	public Tesker(Session session) {
		super();
		
		this.session = session;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
            if (session.isOpen()) {
                session.getBasicRemote().sendText("fd", true);
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
