<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-1.11.0.js">
</script>
<script type="text/javascript">
$(document).ready(function() {
 var uriWS="ws://localhost:8080/WebSocketHolaMundo/mensaje";
 var miWebsocket= new WebSocket(uriWS);
 console.log (miWebsocket);
 miWebsocket.onopen=function(evento) {
 console.log("abierto");
 miWebsocket.send("hola");
 }
 miWebsocket.onmessage=function(evento) {
 console.log(evento.data);
 }
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
Java WebSockets
www.arquitecturajava.com
<title>Insert title here</title>
</head>
<body>
</body>
</html>
