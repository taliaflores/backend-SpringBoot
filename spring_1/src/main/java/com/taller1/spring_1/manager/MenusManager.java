package com.taller1.spring_1.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.taller1.spring_1.model.Alumnos;
import com.taller1.spring_1.model.Menus;
import com.taller1.spring_1.model.Procesos;
import com.taller1.spring_1.model.Roles;

//import taller3.tgrado.model.Roles;

@Service
public class MenusManager {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasourse2){
		jdbcTemplate = new JdbcTemplate(datasourse2); 
	}
	public List<Roles> listaRoles(String xlogin){
		
			String xsql="   select r.codr, r.nombre, r.estado    " 
					+"	from croles r ,userol u  "
					+"	where r.estado=1 and r.codr=u.codr and    "
					+"	      u.login=?  ";
		List est = this.jdbcTemplate.query(
		    xsql,
		    new RowMapper() {
		        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	Roles alu= new Roles();
		        	
		        	alu.setCodr(rs.getInt("codr"));
		        	alu.setNombre(rs.getString("nombre"));
		        	alu.setEstado(rs.getInt("estado"));
		        return alu;
		        }
		    },new Object[] {xlogin});
	return est;		
}

public List<Menus> listaMenus(int xcodr){
	
	String xsql="  select m.codm, m.nombre, m.estado  "
				+"	from cmenus m, rolme r   "
				+"	where m.codm=r.codm and r.codr=?  ";
	List est = this.jdbcTemplate.query(
	    xsql,
	    new RowMapper() {
	        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Menus alu= new Menus();
	        	alu.setCodm(rs.getInt("codm"));
	        	alu.setNombre(rs.getString("nombre"));
	        	alu.setEstado(rs.getInt("estado"));
	        return alu;
	        }
	    },new Object[] {xcodr});
	return est;		
}

public List<Procesos> listaProcesos(int idmenu){
	//System.out.println(" llegoo::"+idmenu);
	
	 
	   
		
	String xsql="  select p.codp,p.nombre,p.enlace,p.ayuda    "
				+"	from cprocesos p, mepro m     "
				+"	where p.codp=m.codp and m.codm=?   ";
	List est = this.jdbcTemplate.query(
	    xsql,
	    new RowMapper() {
	        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Procesos alu= new Procesos();
	        	alu.setCodp(rs.getInt("codp"));
	        	alu.setNombre(rs.getString("nombre"));
	        	alu.setEnlace(rs.getString("enlace"));
	        	alu.setAyuda(rs.getString("ayuda"));
	        return alu;
	        }
	    },new Object[] {idmenu});
	return est;		
}
	/*
//lista menus	
	public List<Menus> listaMenus(){
		String xsql = " select codm,nombre,estado  "
				+"  from  cmenus"
				+"  where estado=1 or estado=0 "
				+"  order by codm,nombre   ";

	
		List est = this.jdbcTemplate.query(
				xsql,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
						Menus alu = new Menus();
						alu.setCodm(rs.getInt("codm"));
						alu.setNombre(rs.getString("nombre"));
						alu.setEstado(rs.getInt("estado"));
						
						return alu;
					}	
				}, new Object[] {});
				
			return est;
	}
	
	public List<Procesos> listaProcesos(int idmenu){
		String xsql = " select p.codp, p.nombre,p.enlace,p.ayuda  "
				+"  from  cprocesos p, mepro m  "
				+"  where p.codp=m.codp and m.codm=?  ";
	
		List est = this.jdbcTemplate.query(
				xsql,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
						Procesos alu = new Procesos();
						alu.setCodp(rs.getInt("codp"));
						alu.setNombre(rs.getString("nombre"));
						alu.setEnlace(rs.getString("enlace"));
						alu.setAyuda(rs.getString("ayuda"));
						return alu;
					}	
				}, new Object[] {idmenu});
				
			return est;
	}
	*/
}