package com.taller1.spring_1.model;

import java.util.Date;

public class Personas {
	public int codp;
	public String ruci;
	public String nombre;
	public String ap;
	public String am;
	public int estado;
	public Date fnac;
	public String ecivil;
	public String genero;
	public String direc;
	public String celular;
	public String foto;
	public String login;
	public String token;
	public String clave;
		
	
	public String getRuci() {
		return ruci;
	}
	public void setRuci(String ruci) {
		this.ruci = ruci;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getAm() {
		return am;
	}
	public void setAm(String am) {
		this.am = am;
	}
	public int getCodp() {
		return codp;
	}
	public void setCodp(int codp) {
		this.codp = codp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp() {
		return ap;
	}
	public void setAp(String ap) {
		this.ap = ap;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Date getFnac() {
		return fnac;
	}
	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}
	public String getEcivil() {
		return ecivil;
	}
	public void setEcivil(String ecivil) {
		this.ecivil = ecivil;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDirec() {
		return direc;
	}
	public void setDirec(String direc) {
		this.direc = direc;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	//format datos
	public String getDatosPersona(){
		String xpersona=this.nombre;
		if (this.ap != null){
			xpersona=xpersona+" "+this.ap;
		}
		
		if (this.am != null){
			xpersona=xpersona+" "+this.am;
		}		
		return xpersona;
	}
	
}
