package com.unaj.sockets;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


class Client implements Runnable {
	   private SocketChannel channel;

	   public Client(SocketChannel channel) {
	      this.channel = channel;
	   }

	   @Override
	   public void run() {
	      System.out.println("client connected");
	      ByteBuffer buffer = ByteBuffer.allocate(100);
	      try {
	         // read bytes into buffer
	         while (channel.read(buffer) > -1) {

	            // buffer position to 0 and limit to actual position.
	            buffer.flip();

	            // get all bytes
	            while (buffer.hasRemaining()) {
	               System.out.print((char) buffer.get());
	            }
	            System.out.println();

	            // clear buffer.
	            buffer.clear();
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         Util.close(channel);
	         System.out.println("Channel closed");
	      }
	   }

	}