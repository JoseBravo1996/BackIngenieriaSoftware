/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unaj.sockets;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 *
 * @author Taglio
 */
public class PruebaSocket {
	
	
    public static void main(String[] args) throws IOException {
    	
    	ServerSocket server = new ServerSocket();
    	
    	InetAddress address = InetAddress.getLocalHost();
    	
        SocketConexion sc = new SocketConexion("SC1",address.getHostAddress().toString(),5557);
        sc.SendMensaje("ADD_Arduino tn1 10.20.1.21 23*consolaEOF");

        /*SocketChannel channel = SocketChannel.open(new InetSocketAddress("25.3.149.30", 8000));
        ////ESCRIBIR
        
        String[] lines = new String[] { "ADD_Arduino tn1 10.20.1.21 23*consolaEOF" };
        ByteBuffer buffer = ByteBuffer.allocate(100);

        for (String line : lines) {
           buffer.put(line.getBytes());
           buffer.flip();
            while (buffer.hasRemaining()) {
               channel.write(buffer);
            }
            buffer.clear();
        }             
        ///LEER
        
        ByteBuffer buffer2 = ByteBuffer.allocate(10);
        
        while (channel.read(buffer2) > -1) {
            buffer2.flip();
            while (buffer2.hasRemaining()) {
               System.out.print((char) buffer2.get());
            }
            System.out.println();

            buffer2.clear(); 
        }  */
    }
    
}
