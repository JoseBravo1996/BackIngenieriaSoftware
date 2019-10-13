package com.unaj.sockets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Taglio
 */
public class ArrayIndexed<T> {
    
    Map<Integer, T> dictionary = new HashMap<Integer, T>();
    private Integer cantElements=0;
    
    public ArrayIndexed(){
        this.cantElements=0;
    }
    public void add(T element){
        this.dictionary.put(this.cantElements, element);
        this.cantElements++;
    }
    public T get(Integer index){
        return this.dictionary.get(index);
    }
    public T pop(){
        return pop(0);
    }
    public T pop(Integer index){
        T toRtn = this.get(index);
        this.dictionary.remove(index);
        return toRtn;
    }
    public boolean remove(Integer index){
        try{
            this.dictionary.remove(index);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}