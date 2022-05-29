<%@page import="java.util.*"%>
<%@page import="com.ayesa.dtos.PersonaDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.item1 { grid-area: header; }
.item2 { grid-area: menu; }
.item3 { grid-area: main; }
.item4 { grid-area: right; }
.item5 { grid-area: footer; }

.grid-container {
  display: grid;
  grid-template-areas:
    'header header header header header header'
    'main main main main main main'
    'footer footer footer footer footer footer';
  gap: 10px;
  background-color: #2196F3;
  padding: 10px;
}

.grid-container > div {
  background-color: rgba(255, 255, 255, 0.8);
  text-align: center;
  padding: 20px 0;
  font-size: 30px;
}
</style>
</head>
<body>
<div class="grid-container">
	<div class="item1">Resultados de la lectura</div>
	<div class="item3">
		<%
		List<PersonaDTO> p = (LinkedList<PersonaDTO>) request.getAttribute("personas");
		if(p.isEmpty()){
			out.print("No hay datos");
		}
		for (int i = 0; p != null && i < p.size(); i++) {
			out.print(p.get(i).getId());
			out.print("<br>");
			out.print(p.get(i).getNombre() + " " + p.get(i).getApellidos());
			out.print("<br>");
			out.println("-----------------------------------------------");
			out.print("<br>");
		}
	%>
	</div>
	<div class="item5">
	<a href="MainController?action=GOBACK">Volver al menú</a>
	</div>
</div>
</body>
</html>