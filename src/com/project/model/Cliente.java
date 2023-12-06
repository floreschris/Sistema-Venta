package com.project.model;

public class Cliente {

	private int id_cliente;
	private String nombre;
	private int edad;

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Cliente(int id_cliente, String nombre, int edad) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.edad = edad;
	}

}
