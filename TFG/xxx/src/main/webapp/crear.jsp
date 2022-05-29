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
	<div class="item1">Crear personas</div>
	<div class="item3">
		<form action="MainController" method="get" name=myform id="myform">
			<section id="sectionText">
					<input type=text placeholder="Nombre..." name=nombre onkeyup="enableButton(this)"><br>
					<input type=text placeholder="Apellidos..." name=apellidos onkeyup="enableButton(this)">
			</section>
			<br>
			<input type="submit" id="Crear" name=action value="CREAR" disabled="disabled">
		</form>	
	</div>  
	<div class="item5">
		<a href="MainController?action=GOBACK">Volver al menú</a>
	</div>
</div>
	<script type="text/javascript">
	    function enableButton() {
			/* if(texto.value.trim().length>0){
				document.getElementById("Crear").disabled=false;
			}else{
				document.getElementById("Crear").disabled=true;	
			}
	         */	         
	         let elements=sectionText.childNodes;
	         let tamaño=0;
	         
	         for(let i=0;i<elements.length;i++){
	        	if(elements[i].type=="text"){
		        	if(elements[i].value.trim().length>0){
						tamaño++;
			        }
	         	}
		     }
	         if(tamaño==2){
	        	 document.getElementById("Crear").disabled=false;
				}else{
					document.getElementById("Crear").disabled=true;	
				}
	    }
	</script>
</body>
</html>