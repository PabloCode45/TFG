package com.ayesa.controller;

import java.io.IOException;
import java.io.Serializable;

import com.ayesa.dtos.PersonaDTO;
import com.ayesa.service.personaservice.impl.PersonaServiceImpl;

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
public class MainController extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private String creacion = "/creacion.jsp";
	private String name="nombre";
	private String surname="apellidos";
	private PersonaServiceImpl personaServiceImpl = new PersonaServiceImpl();
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		if(action.equals("CREATE")) {			
			response.sendRedirect(request.getContextPath() + "/crear.jsp");
			
		}else if(action.equals("READALL")) {			
			request.setAttribute("personas", personaServiceImpl.buscarPersonas());
			request.getRequestDispatcher("/lectura.jsp").forward(request, response);
			
		}else if(action.equals("READONE")) {			
			response.sendRedirect(request.getContextPath() + "/lecturaEspecifica.jsp");
			
		}else if(action.equals("UPDATE")) {
			response.sendRedirect(request.getContextPath() + "/actualizar.jsp");
			
		}else if(action.equals("DELETE")) {
			response.sendRedirect(request.getContextPath() + "/borrar.jsp");
			
		}else if(action.equals("GOBACK")) {			
			response.sendRedirect(request.getContextPath() + "/index.html");
			
		}else if(action.equals("CREAR")) {
			setCreacion(request, personaServiceImpl.crearPersona(crearPersonaDTO(request.getParameter(name), request.getParameter(surname))));
			request.getRequestDispatcher(creacion).forward(request, response);
			
		}else if(action.equals("BUSCAR")) {
			request.setAttribute("personas", personaServiceImpl.buscarPersona(crearPersonaDTO( request.getParameter(name), request.getParameter(surname))));
			request.getRequestDispatcher("/lectura.jsp").forward(request, response);
			
		}else if(action.equals("ACTUALIZAR")) {
			setCreacion(request, personaServiceImpl.actualizarPersona(crearPersonaDTO( request.getParameter(name), request.getParameter(surname)),crearPersonaDTO(request.getParameter("nombreNuevo"), request.getParameter("apellidosNuevo"))));
			request.getRequestDispatcher(creacion).forward(request, response);

		}else if(action.equals("BORRAR")) {
			setCreacion(request, personaServiceImpl.borrarPersona(crearPersonaDTO( request.getParameter(name), request.getParameter(surname))));
			request.getRequestDispatcher(creacion).forward(request, response);
			}

			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void setCreacion(HttpServletRequest request, String t) {
		request.setAttribute("creacion", t);
	}
	
	protected PersonaDTO crearPersonaDTO(String nombre, String apellidos) {
		return new PersonaDTO(0, nombre, apellidos);
		
	}
}