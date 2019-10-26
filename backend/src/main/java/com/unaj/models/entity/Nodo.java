package com.unaj.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.unaj.sockets.RequestAdm;

@Entity
@Table(name = "nodo")

public class Nodo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nodo;
	private String ip;
	private int port;
	private boolean status;

	
}
