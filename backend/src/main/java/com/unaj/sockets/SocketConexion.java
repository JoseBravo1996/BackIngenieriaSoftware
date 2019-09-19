/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unaj.sockets;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

/**
 *
 * @author Taglio
 */
public class SocketConexion {
    
    private Buffer buffer=null;
    private SocketChannel channel=null;
    private Integer port=0;
    private String host="localhost";
    private Boolean conected = false;
    private String name="";
    private WriteSocket wcon=null;
    private ReadSocket rcon=null;

    /**
     *
     * @param name
     */
    public SocketConexion(String name,String host,Integer port)
    {
        this.host=host;
        this.port=port;
        this.name=name;
        this.buffer = new Buffer("buffer_"+this.name);
            
        try{
            this.channel = SocketChannel.open(new InetSocketAddress(this.host, this.port));
        }catch (UnknownHostException ex){
            System.out.println("Servidor no encontrado: " + ex.getMessage());
        }catch (IOException ex){
            System.out.println("I/O error: " + ex.getMessage());
        }finally{
            this.conected= isConnected();
            if(this.conected){
                ReadSocket();
                WriteSocket();
            }
        }
    }
    public Buffer getBuffer(){
        return this.buffer;
    }
    private boolean ReadSocket(){
        try{
            this.rcon = new ReadSocket("demon_read_"+this.name,this,this.buffer,10);
            this.rcon.start();
            return true;
        }catch( Exception ex){
            return false;
        }  
    }
    private Boolean WriteSocket()
    {
        try{
            this.wcon = new WriteSocket("demon_write_"+this.name,this,this.buffer,50);
            this.wcon.start();
            return true;
        }catch( Exception ex){
            return false;
        }        
    }
    public SocketChannel getChannel()
    {
        return this.channel;
    }
    public Boolean isConnected()
    {
        Boolean status = this.channel.isConnected();
        this.conected= status;
        return status;
    }
    public Boolean SendMensaje(String msj)
    {
        try{
            this.buffer.pushToSend(msj);
            return true;
        }catch (Exception ex) {
            System.out.println("Error in Thread: " + ex.getMessage());
            return false;
        }
    }
}