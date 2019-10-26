import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/mensaje")
public class MiWebSocket {
	
@OnMessage
public String mensaje(String mensaje) {
return "hola desde el servidor el mensaje es :" +mensaje;
}
}
