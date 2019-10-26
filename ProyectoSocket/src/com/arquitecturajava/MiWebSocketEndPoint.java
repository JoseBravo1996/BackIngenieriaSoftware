package com.arquitecturajava;

import java.io.IOException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

public final class MiWebSocketEndPoint extends Endpoint {

	@Override
	public void onOpen(Session session, EndpointConfig configuracion) {
		final Session misesion = session;
		Thread hilo = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						misesion.getBasicRemote().sendText("datos de la bolsa");
						Thread.sleep(5000);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		hilo.start();
	}
}