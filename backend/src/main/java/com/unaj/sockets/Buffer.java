/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unaj.sockets;

/**
 *
 * @author Taglio
 */
public class Buffer
{
    private ArrayIndexed<String> mensajesToSend = new ArrayIndexed<String>();
    private ArrayIndexed<String> mensajesRecibed = new ArrayIndexed<String>();
  
    @SuppressWarnings("unused")
	private String name;
    
    public Buffer(String name){
        this.name = name;
    }
    public boolean sendMensaje(String msj)
    {
        try
        {
            this.mensajesToSend.add(msj);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public void pushRecibed(String msj){
        this.mensajesRecibed.add(msj);
    }
    public void pushToSend(String msj){
        this.mensajesToSend.add(msj);
    }
    public String popToSend(){
        return this.mensajesToSend.pop();
        //return this.pop(0,this.mensajesToSend);
    }
    public String popRecibed(){
        return this.mensajesRecibed.pop();
        //return this.pop(0,this.mensajesRecibed);
    }
    /*private String pop(Integer index,ArrayList<String> toPop){
        try{
            String toRtn = toPop.get(index);
            toPop.remove(index);
            return toRtn;
        }catch(Exception e){
            return "-1";
        }
    }*/
}

