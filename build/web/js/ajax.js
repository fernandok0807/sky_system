var bd;
$(function(){
   

    
    var flag = null;
            $('#encender').click(function(){
            var video = document.querySelector("#camara"),canvas=document.querySelector("#contenedor"),boton = document.querySelector("#capturar");
             document.querySelector("#camara").style = "display:block";
            window.URL = window.URL || window.webkitURL;
            navigator.getUserMedia = navigator.getUserMedia || navigator.webkitUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia; 
            
            if(navigator.getUserMedia){
                navigator.getUserMedia({video:true}, function(cam){
                video.src=window.URL.createObjectURL(cam);
                flag=cam;
                }, 
                function(err) {
                    console.log("Ocurrió el siguiente error: " + err);
                });              
            }
            else{
                alert("No Soporta el Navegador");
            }
            
            video.addEventListener('loadedmetadata',function(){
                canvas.width=video.videoWidth;
                canvas.height = video.videoHeight;},false);
          
        });
        
        
         $('#capturar').click(function(){
                document.querySelector("#contenedor").getContext('2d').drawImage(document.querySelector("#camara"),0,0);
                var imgData = document.querySelector("#contenedor").toDataURL('image/png');
                document.getElementById('txtbase').value= imgData;
                document.querySelector("#imagen").setAttribute('src',imgData);
                document.querySelector("#imagen").style = "display:block";
                document.querySelector("#camara").src='';
                document.querySelector("#camara").pause();
                document.querySelector("#camara").style = "display:none";
                document.querySelector("#imagen2").style = "display:block";
                flag.getVideoTracks()[0].stop();
                $("#myModal").modal('hide');
                
            }); 
            


            $('#carga').click(function(){
    
                
                
                document.getElementById('archivo').value="C:\\wamp\\www\\fotoEmpleado\\imagenes\\"+document.getElementById('foto').value+ ".png";
                document.querySelector("#imagen").setAttribute('src', "http://192.168.43.223:8080/fotoEmpleado/imagenes/"+document.getElementById('foto').value+".png");
                document.querySelector("#imagen").style = "display:block";
                $("#myModal2").modal('hide');
                
                
            });

                



   
   $('#capturar2').click(function(){
                document.querySelector("#contenedor").getContext('2d').drawImage(document.querySelector("#camara"),0,0);
                document.querySelector("#camara").src='';
                document.querySelector("#camara").pause();
                document.querySelector("#camara").style = "display:none";
                flag.getVideoTracks()[0].stop();
                $("#myModal").modal('hide');
                
            }); 
    
    
	$('#search').focus()
	$('#buscador_form').submit(function(e){
		e.preventDefault();
	})

	$('#search').keyup(function(){
		var envio = $('#search').val();
		var envio1 = $('#campo').val();

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
	})
     
})



function retornarFecha()
{
  var fecha
  fecha=new Date();
  var cadena=fecha.getDate()+'/'+(fecha.getMonth()+1)+'/'+fecha.getYear();
  return cadena;
}	