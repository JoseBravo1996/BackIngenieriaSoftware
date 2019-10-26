package com.unaj.modelo;

import java.util.ArrayList;

public class PersonaListado {
	
	private ArrayList<Persona> personalist;
	
	public PersonaListado() {
		this.personalist = new ArrayList<Persona>();
	}

	public void addPersona(Persona p) {
		this.personalist.add(p);
	}

	public ArrayList<Persona> getPersonalist() {
		return this.personalist;
	}
	
	
	
	

}
