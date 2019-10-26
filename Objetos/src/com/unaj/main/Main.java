package com.unaj.main;

import java.util.Scanner;

import com.unaj.modelo.Persona;
import com.unaj.modelo.PersonaListado;

public class Main {
	
	public static void main(String[] args) {
		Menu();
		
	}
	
	public static void Menu() {
		
		Scanner teclado=new Scanner(System.in);
		int ope=0;
		
	      do {
	    	  System.out.println("Bienvenido");
		      System.out.println("seleccione operacion de su interes."); 
		      ope=teclado.nextInt();
			  switch (ope) {
				case 1:
					SeccionA();
					break;
				case 2:
					SeccionB();
					break;
				default:
					System.out.println("Ingrese una opcion correcta");
					break;
				}
	      }
		while(ope!=2);
	}
	
	
	private static void SeccionA() {
		
	}
	
	private static void SeccionB() {
		Scanner teclado=new Scanner(System.in);
		String ope="";
		
		PersonaListado per = new PersonaListado();
		
		for (int i = 0; per.getPersonalist().isEmpty(); i++) {
			Persona p = new Persona();
			System.out.println("Ingrese Nombre: ");
			p.setNombre(ope);
			System.out.println("Ingrese Edad: ");
			p.setEdad(Integer.parseInt(ope));
			System.out.println("Ingrese Dni: ");
			p.setDni(ope);
			per.addPersona(p);
		}
		
	}
}
