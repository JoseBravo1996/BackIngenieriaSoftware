<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jquery-3.4.1.min.js">
</script>
<script type="text/javascript">
$(document).ready(function() {
 var uriWS="ws://localhost:8080/ProyectoSocket/mensaje";
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
