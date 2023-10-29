var bd;

function iniciar(){
	

	zonadatos=document.getElementById("zonadatos");
	var solicitud=indexedDB.open("Empleados");
	
	solicitud.onsuccess=function(e){
		
		bd=e.target.result;
		
				
	}
	
	solicitud.onupgradeneeded=function(e){
		
				bd=e.target.result;
		bd.createObjectStore("Empleado", {keyPath: "IdEmpleado"});
		
	}	
        
        solicitud.addEventListener("success", cargar, false);
	
}


function cargar(){
		var envio = $('#search').val();
		var envio1 = $('#campo').val();

		

if(!navigator.onLine ){
    document.getElementById("buscador_form").style= "display:none";
            zonadatos.innerHTML="";
	
            
            var transaccion=bd.transaction(["Empleado"],"readonly");

            var almacen=transaccion.objectStore("Empleado");

            var cursor=almacen.openCursor();
            var elements = [];
            
            almacen.openCursor().onsuccess = function (e) {

            var result = e.target.result;

            if (result === null) {
                return;
            }

            elements.push(result.value);
            result.continue();

        };
        transaccion.oncomplete = function () {

    var outerHTML = '<table class="table table-hover table-bordered">'+'<tr class="btn-success"><td>ID</td><td>Nombre</td><td>Apellido</td><td>Direccion</td><td>Telefono</td><td>Puesto</td><td>DPI</td><td>Fecha Nacimiento</td><td>Foto</td></tr>';

    for (var key in elements) {

        outerHTML += '<tr>\n\
                            <td>' + elements[key].IdEmpleado + '</td>\n\
                            <td>' + elements[key].Nombre + '</td>\n\
                            <td>' + elements[key].Apellido +    '</td>\n\
                            <td>' + elements[key].Direccion +    '</td>\n\
<td>' + elements[key].Telefono +    '</td>\n\
<td>' + elements[key].Puesto +    '</td>\n\
<td>' + elements[key].DPI +    '</td>\n\
<td>' + elements[key].FechaN +    '</td>\n\
<td> <img src=' + elements[key].Foto +    ' width=100 height=100></td>\n\
                        </tr>';

    }
    outerHTML += '</table>';

    
    document.querySelector("#resultados").innerHTML = outerHTML;

        
        }
            
	}else{
$('#resultados').html('<h2>  <img src="../Estilo/img/carga.gif" width="35" alt=""/> Buscando</h2>')
		$.ajax({
			type: 'POST',
			url: 'Visualizar_Empleado.jsp',
			data:('search='+envio+'&&'+'campo='+envio1),
			success: function(resp){
				if(resp!=""){
					$('#resultados').html(resp);
				}
			}
		})
                
                
                setTimeout(function() {    
                   
        
          setTimeout(function() {    
                     $("tbody tr").each(function (e1){
                    
                    var itemOrden = {};
                    
                    var tds = $(this).find("td");
                    
                    
                    var id=$(this).attr("data-idempleado");
                    
                    var nombre=tds.filter(":eq(0)").text();
	
                    var apellido=tds.filter(":eq(1)").text();

                    var direccion=tds.filter(":eq(2)").text();
                    
                    var telefono=tds.filter(":eq(3)").text();
                    
                    var puesto=tds.filter(":eq(4)").text();
                    
                    var dpi=tds.filter(":eq(5)").text();
                    
                    var fechaN=tds.filter(":eq(6)").text();
                    
                    var foto=$(this).attr("data-imagw");

                    var transaccion=bd.transaction(["Empleado"], "readwrite");

                    var almacen=transaccion.objectStore("Empleado");

                    var agregar=almacen.add({IdEmpleado: id, Nombre: nombre,Apellido: apellido, Direccion: direccion, Telefono: telefono, Puesto: puesto, DPI: dpi, FechaN: fechaN, Foto: foto});
                    
                    
                });

    
}, 1000);
        
    

}, 1500);}


	
                
                	
                    
	};


function retornarFecha()
{
  var fecha
  fecha=new Date();
  var cadena=fecha.getDate()+'/'+(fecha.getMonth()+1)+'/'+fecha.getYear();
  return cadena;
};	

function mostrarDatos(e){
	
	var cursor=e.target.result;
	
	if(cursor){
		
		zonadatos.innerHTML+="<p>" + cursor.value.IdEmpleado + " - " + cursor.value.Nombre + " - " + cursor.value.Apellido + "</p><br>";
		
		cursor.continue();
		
		
	}
	
	
	
}

window.addEventListener("load", iniciar, false);



