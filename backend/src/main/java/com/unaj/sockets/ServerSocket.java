package com.unaj.sockets;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocket {
	   public static void main(String[] args) {

	      try (ServerSocketChannel server = ServerSocketChannel.open()) {
	    	 InetAddress address = InetAddress.getLocalHost();
	         server.bind(new InetSocketAddress(address.getHostAddress().toString(), 5557));
	         while (true) {
	            SocketChannel client = server.accept();
	            new Thread(new Client(client)).start();
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
}
