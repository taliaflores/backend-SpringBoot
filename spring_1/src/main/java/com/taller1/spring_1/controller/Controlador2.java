package com.taller1.spring_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;*/
import org.springframework.web.bind.annotation.RestController;

import com.taller1.spring_1.manager.MateriasManger;
import com.taller1.spring_1.model.Materias;


@RestController
public class Controlador2 {
	
	@Autowired
	MateriasManger materiasManager;
	
	/*@RequestMapping("/ejemploTaller1")
	public String primerMetodo(){
		return "HOLA MUNDO - TALLER 1 - GESTION 2020";
	}
*/
	@GetMapping("/api/listaMaterias")
	public List<Materias> listaMaterias(Model model){
	
		List<Materias> lisMa = this.materiasManager.listaMaterias();
		System.out.println("Listar Materias");
		return lisMa;
	}
	@PostMapping("/api/addMaterias")
	public int guardandoMaterias (@RequestBody Materias ma){
		try {
			int  rest1 = this.materiasManager.setAddMaterias(ma.sigla,ma.nombre, ma.nivel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 2;
	}
	@DeleteMapping("/api/delMateria/{sigla}")
	public int eliminarMaterias(@PathVariable("sigla") String xsigla){
		int  rest = this.materiasManager.setDelMaterias(xsigla);
		return 3;
	}
	@PutMapping("/api/modMaterias")
	public Materias modificarAlumnos (@RequestBody Materias ma){
		System.out.println("Proceso de Modificacion de la materia........... -> "+ma.getNombre());
			int  rest1 = this.materiasManager.setModMaterias(ma.sigla, ma.nombre, ma.nivel);
		return ma;
	}
}
