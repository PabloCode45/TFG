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
	<div class="item1">Leer a una persona espec�fica</div>
	<div class="item3">
			<form action="MainController" method="get" name=myform>
			<input type=text placeholder="Nombre..." name=nombre oninput="enableButton()"> <br> 
			<input type=text placeholder="Apellidos..." name=apellidos oninput="enableButton()"> <br> <br> 
				<input type="submit" id="Buscar" name=action value="BUSCAR" disabled="disabled">
				<br>
	</form>
	<script type="text/javascript">
	    function enableButton() {
	        document.getElementById("Buscar").disabled=false;
	        
	    }
	</script>
	</div>
	<div class="item5">
	<a href="MainController?action=GOBACK">Volver al men�</a>
	</div>
</div>
</body>
</html>