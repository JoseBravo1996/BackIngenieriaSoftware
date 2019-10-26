package com.unaj.sockets;

import java.util.HashMap;
import java.util.Map;

public class ArrayIndex<T> {

	Map<Integer, T> dictionary = new HashMap<Integer, T>();

    public void add(T element){
        this.dictionary.put(dictionary.size()+1, element);
    }
    public T get(Integer index){
        return this.dictionary.get(index);
    }
    public T pop(){
        return pop(dictionary.size());
    }
    public T pop(Integer index){
    	try {
	    T toRtn = this.get(index);
            this.dictionary.remove(index);
            return toRtn;
    	}catch(Exception e) {
    		return null;
    	}        
    }
    public boolean remove(Integer index){
        try{
            this.dictionary.remove(index);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public int getCantElements() {
    	return dictionary.size();
    }
}
