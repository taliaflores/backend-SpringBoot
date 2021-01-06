package com.taller1.spring_1.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import taller3.tgrado.manager.MenusManager;


public class Menus {
	
	
	
	public int codm;
	public String nombre;
	public int estado;
	public List<Procesos> opciones = new ArrayList<Procesos>();
	
	public List<Procesos> getOpciones() {
		return opciones;
	}
	public void setOpciones(List<Procesos> opciones) {
		this.opciones = opciones;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodm() {
		return codm;
	}
	public void setCodm(int codm) {
		this.codm = codm;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
