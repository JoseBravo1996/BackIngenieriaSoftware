/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unaj.sockets;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taglio
 */
public class ReadSocket extends Thread{
    private String nameThread;
    @SuppressWarnings("unused")
	private SocketConexion sockCon;
    private Buffer bufferGral;
    private SocketChannel channel;
    private Boolean demon=false;
    private int lenghtBuffer;

    public ReadSocket(String nameThread,SocketConexion sockCon,Buffer bufferGral,Integer lenghtBuffer) throws IOException
    {
        this.nameThread=nameThread;
        this.sockCon=sockCon;
        this.bufferGral=bufferGral;
        this.channel = sockCon.getChannel();
        this.lenghtBuffer = lenghtBuffer;
        startDemon();
        System.out.println("Thread Reader "+this.nameThread+" ->Started");
    }

    @Override public void run()
    {
        ByteBuffer buffer = ByteBuffer.allocate(this.lenghtBuffer);
   
        while (this.demon) 
        {
            try {
                this.channel.read(buffer);
            } catch (IOException ex) {
                Logger.getLogger(ReadSocket.class.getName()).log(Level.SEVERE, null, ex);
            }

            buffer.flip();
            String toBufferGral="";
            while (buffer.hasRemaining()) 
            {
                char charMsj=(char) buffer.get();
                System.out.print(charMsj);
                toBufferGral+=charMsj;
            }
            this.bufferGral.pushRecibed(toBufferGral);
            System.out.println();
            buffer.clear();
        }
    }
    public void stopDemon()
    {
        this.demon=false;
    }
    public void startDemon() throws IOException
    {
        this.demon=true;
        //this.demon();
    }
}

