/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unaj.sockets;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
//import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taglio
 */
public class WriteSocket extends Thread{
    private String nameThread;
    @SuppressWarnings("unused")
	private SocketConexion sockCon;
    private Buffer bufferGral;
    private SocketChannel channel;
    private Boolean demon=false;
    private int lenghtBuffer;
    //private ArrayList<String> mensajes = new ArrayList<String>();

    public WriteSocket(String nameThread,SocketConexion sockCon,Buffer bufferGral,Integer lenghtBuffer) throws IOException
    {
        this.nameThread=nameThread;
        this.sockCon=sockCon;
        this.bufferGral=bufferGral;
        this.channel = sockCon.getChannel();
        this.lenghtBuffer = lenghtBuffer;
        startDemon();
        System.out.println("Thread Writer "+this.nameThread+" ->Started");
    }
    @Override public void run()
    {
        ByteBuffer buffer = ByteBuffer.allocate(this.lenghtBuffer);

        while(this.demon) {
            String msj=this.bufferGral.popToSend();
            if(msj!=null)
            {
                buffer.put(msj.getBytes());
                buffer.flip();

                while (buffer.hasRemaining()) {
                    try {
                        this.channel.write(buffer);
                    } catch (IOException ex) {
                        Logger.getLogger(WriteSocket.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                buffer.clear();
            }
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
