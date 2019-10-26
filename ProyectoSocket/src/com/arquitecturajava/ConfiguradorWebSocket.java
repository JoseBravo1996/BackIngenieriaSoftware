package com.arquitecturajava;

import java.util.HashSet;
import java.util.Set;
import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class ConfiguradorWebSocket implements ServerApplicationConfig {

	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> arg0) {
		return null;
	}

	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		return new HashSet<ServerEndpointConfig>() {
			{
				add(ServerEndpointConfig.Builder.create(MiWebSocketEndPoint.class, "/miwebsocket").build());
			}
		};
	}
}
