package com.taller1.spring_1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller1.spring_1.manager.AlumnosManager;
import com.taller1.spring_1.manager.MenusManager;

import com.taller1.spring_1.model.Alumnos;
import com.taller1.spring_1.model.Menus;
import com.taller1.spring_1.model.Procesos;
import com.taller1.spring_1.model.Roles;

@RestController
public class ControladorMenus {

	@Autowired
	MenusManager menusManager;
	
	@GetMapping("/api/listaRoles/{login}")
	public List<Roles> listaDeRoles(Model model, @PathVariable("login") String login, HttpSession session) 	{
///		String xsession=(String) session.getAttribute("xusuario");
		List<Roles> lisAlus=null;
///		if (xsession != null) { 
			lisAlus = this.menusManager.listaRoles(login);
///		}else{
///			System.out.println("LA SESSION YA FUE CERRADA..");
///		}
	    return lisAlus;
	}
	
	@GetMapping("/api/listaMenus/{id}")
	public List<Menus> listaDeMenus(Model model, @PathVariable("id") String id) 	{
		System.out.println("Llego :"+id);
		if (id == null) {id="0";}
		List<Menus> lisAlus = this.menusManager.listaMenus(Integer.parseInt(id));
		for(Menus men : lisAlus) {
			  List<Procesos> lisAlus2 = this.menusManager.listaProcesos(men.codm);
			  men.setOpciones(lisAlus2);
		}
	    return lisAlus;
	}	
	
	/*@Autowired
	AlumnosManager alumnosManager;
	
	@RequestMapping("/ejemploTaller1")
	public String primerMetodo(){
		return "HOLA MUNDO - TALLER 1 - GESTION 2020";
	}

	@GetMapping("/api/listaAlumnos/{xestado}")
	public List<Alumnos> listaAlumnos(Model model, @PathVariable("xestado") String xestado){
		int  xest = Integer.parseInt(xestado);
		List<Alumnos> lisAlu = this.alumnosManager.listaAlumnos(xest);
		return lisAlu;
	}
	
	

	@GetMapping("/api/menus")
	public List<Menus> listaMenus(Model model){
		
		List<Menus> lis = this.alumnosManager.listaMenus();
		return lis;
	}
	
	@GetMapping("/api/menusopc")
	public List<Menus> listaMenuspro(Model model){
		
		List<Menus> lisMen = this.alumnosManager.listaMenus();
	
		for (Menus men : lisMen) {
			List<Procesos> lis2 = this.alumnosManager.listaProcesos(men.codm);
			men.setOpciones(lis2);
		}
		return lisMen;
	}
	
	
/*Prueba que lega bien los datos del post man 	
	@PostMapping("/api/guardarAlumnos/")
	public int guardandoAlumnos (@RequestBody Alumnos alu){
		try {
			System.out.println("Llego :: "+alu.ru);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	@PostMapping("/api/guardarAlumnos")
	public int guardandoAlumnos (@RequestBody Alumnos alu){
		try {
			//int  rest1 = this.alumnosManager.setAddAlumnos(alu.ru,alu.nombre, alu.ap, alu.am,alu.estado);
			
			int  rest1 = this.alumnosManager.setAddAlumnos(alu.ru,alu.nombre, alu.ap, alu.am,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 2;
	}
	
	@DeleteMapping("/api/delete/{ru}")
	public int eliminarAlumnos(@PathVariable("ru") int xru){
		int  rest = this.alumnosManager.setDelAlumnos(xru);
		return 3;
	}
	
	@PutMapping("/api/modAlumnos")
	public Alumnos modificarAlumnos (@RequestBody Alumnos alu){
		System.out.println("Proceso de Modificacion............de  -> "+alu.getNombre());
			int  rest1 = this.alumnosManager.setModAlumnos(alu.ru, alu.nombre, alu.ap, alu.am);
		return alu;
	}
	@PutMapping("/api/modEstado/{ru}")
	public int modificarAlumnos (@PathVariable("ru") int xru){
		System.out.println("Proceso de Eliminacion Logica............de  -> ");
	
			int  rest1 = this.alumnosManager.setEliminacionLogica(xru);
		return 4;
	}*/
}
