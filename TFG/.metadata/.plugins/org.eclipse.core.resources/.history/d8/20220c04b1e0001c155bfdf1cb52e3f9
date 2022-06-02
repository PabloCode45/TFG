package com.ayesa.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.ayesa.dtos.PersonaDTO;

public class PersonaCRUDRepository implements CRUDrepository<PersonaDTO>{
	private static List<PersonaDTO> personas = new LinkedList<>();

	@Override
	public boolean Create(PersonaDTO personaDTO) {
		Statement st;	
		st = Conexion();
		
		try {
			if(ReadOne(personaDTO).isEmpty()) {
				st.executeUpdate("INSERT INTO PERSONA (NOMBRE, APELLIDOS) VALUES ('"+personaDTO.getNombre()+"','"+personaDTO.getApellidos()+"')");
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {e.printStackTrace();return false;}
	}

	@Override
	public List<PersonaDTO> ReadAll() {
		Statement st;
		ResultSet rs;		
		st = Conexion();
		
		try {
			rs = st.executeQuery("SELECT IDPERSONA, NOMBRE, APELLIDOS FROM PERSONA");
			
			return rellenarLista(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<PersonaDTO> ReadOne(PersonaDTO personaDTO) throws SQLException{
		if(personaDTO== null) throw new SQLException();
	Statement st;
	ResultSet rs = null;		
	st = Conexion();
	String query="";
	
	personas = new LinkedList<>();
	
	
		if(personaDTO.getNombre().isEmpty()) {
			 query="WHERE APELLIDOS='"+personaDTO.getApellidos()+"'";
			
		}else if(personaDTO.getApellidos().isEmpty()) {
			query="WHERE NOMBRE='"+personaDTO.getNombre()+"'";
			
		}else {
			query="WHERE NOMBRE='"+personaDTO.getNombre()+"' AND APELLIDOS='"+personaDTO.getApellidos()+"'";
				
		}

		return rellenarLista(rs = st.executeQuery("SELECT IDPERSONA, NOMBRE, APELLIDOS FROM PERSONA " + query));
		
	}

	@Override
	public boolean Update(PersonaDTO personaDTO, PersonaDTO personaDTO2) {
		Statement st;
		st = Conexion();
		try {
			if(!(ReadOne(personaDTO).isEmpty())) {
				st.executeUpdate("UPDATE PERSONA SET NOMBRE='"+personaDTO2.getNombre()+"', APELLIDOS='"+personaDTO2.getApellidos()+"' WHERE NOMBRE='"+personaDTO.getNombre()+"' AND APELLIDOS='"+personaDTO.getApellidos()+"'");
				return true;
			}else {
				return false;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean Delete(PersonaDTO personaDTO) {
		Statement st;
		st = Conexion();
		
		try {
			if(!(ReadOne(personaDTO).isEmpty())) {
			st.executeUpdate("DELETE FROM PERSONA WHERE NOMBRE='"+personaDTO.getNombre()+"' AND APELLIDOS='"+personaDTO.getApellidos()+"'");
			return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private Statement Conexion() {
		try {
			InitialContext ctx = new InitialContext();
			Connection con = null;
			Statement st = null;
			BasicDataSource ds = (BasicDataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
			
			con = ds.getConnection();
			
			st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			
			return st;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	private List<PersonaDTO> rellenarLista(ResultSet rs) {
		personas=new LinkedList<>();
		try {
		while(rs.next()) {
			PersonaDTO personaDTO = new PersonaDTO(0, null, null);
			personaDTO.setId(rs.getInt(1));
			personaDTO.setNombre(rs.getString(2));
			personaDTO.setApellidos(rs.getString(3));
			
			personas.add(personaDTO);
			
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personas;
		
	}

}