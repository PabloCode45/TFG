package com.ayesa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ayesa.dtos.PersonaDTO;
import com.ayesa.model.*;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/xxx")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		if(action.equals("CREATE")) {
			System.out.println("Crear");
			
			response.sendRedirect(request.getContextPath() + "/crear.jsp");
			
		}else if(action.equals("READALL")) {
			System.out.println("Leer todo");
			
			PersonaCRUDRepository personaCRUDRepository = new PersonaCRUDRepository();
			
			request.setAttribute("personas", personaCRUDRepository.ReadAll());
			request.getRequestDispatcher("/lectura.jsp").forward(request, response);
			
		}else if(action.equals("READONE")) {
			System.out.println("Leer uno");
			
			response.sendRedirect(request.getContextPath() + "/lecturaEspecifica.jsp");
			
		}else if(action.equals("UPDATE")) {
			System.out.println("Actualizar");
			response.sendRedirect(request.getContextPath() + "/actualizar.jsp");
			
		}else if(action.equals("DELETE")) {
			System.out.println("Borrar");
			response.sendRedirect(request.getContextPath() + "/borrar.jsp");
			
		}else if(action.equals("BUSCAR")) {
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			PersonaCRUDRepository personaCRUDRepository = new PersonaCRUDRepository();
			PersonaDTO personaDTO = new PersonaDTO(0, nombre, apellidos);
			
			try {
				request.setAttribute("personas", personaCRUDRepository.ReadOne(personaDTO));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/lectura.jsp").forward(request, response);
			
		}else if(action.equals("GOBACK")) {			
			response.sendRedirect(request.getContextPath() + "/index.html");
			
		}else if(action.equals("CREAR")) {
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			PersonaDTO personaDTO = new PersonaDTO(0, nombre, apellidos);
			PersonaCRUDRepository personaCRUDRepository = new PersonaCRUDRepository();
			
			if(personaCRUDRepository.Create(personaDTO)) {
				request.setAttribute("creacion", "Operación realizada con exito");
			}else {
				request.setAttribute("creacion", "Error - Persona ya existente o fallo SQL");
			}
			request.getRequestDispatcher("/creacion.jsp").forward(request, response);
			
		}else if(action.equals("ACTUALIZAR")) {
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String nombreNuevo = request.getParameter("nombreNuevo");
			String apellidosNuevo = request.getParameter("apellidosNuevo");
			PersonaDTO personaDTO = new PersonaDTO(0, nombre, apellidos);
			PersonaDTO personaDTO2 = new PersonaDTO(0, nombreNuevo, apellidosNuevo);
			PersonaCRUDRepository personaCRUDRepository = new PersonaCRUDRepository();
			
			if(personaCRUDRepository.Update(personaDTO, personaDTO2)) {
				request.setAttribute("creacion", "Operación realizada con exito");
			}else {
				request.setAttribute("creacion", "Error - Persona no existente o fallo SQL");
			}
			request.getRequestDispatcher("/creacion.jsp").forward(request, response);
		}else if(action.equals("BORRAR")) {
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			PersonaDTO personaDTO = new PersonaDTO(0, nombre, apellidos);
			PersonaCRUDRepository personaCRUDRepository = new PersonaCRUDRepository();
			
			if(personaCRUDRepository.Delete	(personaDTO)) {
				request.setAttribute("creacion", "Operación realizada con exito");
			}else {
				request.setAttribute("creacion", "Error - Persona no existente o fallo SQL");
			}
			request.getRequestDispatcher("/creacion.jsp").forward(request, response);
		}

			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}