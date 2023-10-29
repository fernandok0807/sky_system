

function clean(){
        $("#txtcodigo").val("");
        $("#txtnombres").val("");
        $("#txtdia").val("");
        $("#txtcorreo").val("");
        $("#txtsupervisor").val("0");
        $("#txttelefono").val("");
        
        $("#txtusuario").val("");
        $("#txtclave").val("");
        
}

$(function(){
    $('#search').focus();
    $('#buscador_form').submit(function(e){
        e.preventDefault();
    });

    $('#formulario').submit(function(e){
            e.preventDefault();
    });

    $('#search').keyup(function(){
        var envio = $('#search').val();
        var envio1 = $('#campo').val();

        $('#resultados').html('<h2>  <img src="../img/carga.gif" width="35" alt=""/> Buscando</h2>');

        $.ajax({
                type: 'POST',
                url: 'Visualizar_Tecnico.jsp',
                data:('search='+envio+'&&'+'campo='+envio1),
                success: function(resp){
                    if(resp!=""){
                            $('#resultados').html(resp);
                    }
                }
        });
    });

    
    $('#document').ready(function(){
        var envio = $('#search').val();
        var envio1 = $('#campo').val();

        $('#resultados').html('<h2>  <img src="../img/carga.gif" width="35" alt=""/> Buscando</h2>');
        
        
        $.ajax({
            type: 'POST',
            url: 'Visualizar_Tecnico.jsp',
            data:('search='+envio+'&&'+'campo='+envio1),
            success: function(resp){
                    if(resp!=""){
                            $('#resultados').html(resp);
                    }
            }
        });
    });
    
    $("body").on("click","#resultados a",function(event){
        event.preventDefault();
        $('#actualizar1').show();
        $('#actualizar').hide();
        var target,idAlumno,idCarrera,nombres,apellidos,direccion,matricula,extendida,fechanac,sangre,religion,cel,tel,mens;
        var columna1,columna2,columna3,columna4,columna5;
        target = $(event.target);
        idAlumno = target.parents("tr").data('id');
        idCarrera= target.parents("tr").data('idcarrera');
        
        idGrado= target.parents("tr").data('idgrado');
        
        columna1= target.parents("tr").find("td").eq(0).html();
        columna2= target.parents("tr").find("td").eq(1).html();
        columna3= target.parents("tr").find("td").eq(2).html();
        columna4= target.parents("tr").find("td").eq(3).html();
        columna5= target.parents("tr").find("td").eq(4).html();
        

        $("#txtcodigo").val(idAlumno);
        $("#txtnombres").val(columna1);
        $("#txttelefono").val(columna2);
        $("#txtcorreo").val(columna3);
        $("#txtusuario").val(columna4);
        $("#txtclave").val(columna5);
        
        $("#txtsupervisor").val(idCarrera);
        
      
        

    });

    $("body").on("click","#resultados button",function(event){
        event.preventDefault();
        var target,idAlumno,idCarrera,nombres,apellidos,direccion,matricula,extendida,fechanac,sangre,religion,cel,tel,mens;
        var nomp,telp,nomm,telm,nome,tele,idGrado,bus,vive,coor;
        target = $(event.target);
        idAlumno = target.parents("tr").data('id');
        idCarrera= target.parents("tr").data('idcarrera');
        idGrado= target.parents("tr").data('idgrado');
        nombres= target.parents("tr").find("td").eq(0).html();
        apellidos= target.parents("tr").find("td").eq(1).html();
        direccion= target.parents("tr").find("td").eq(2).html();
        matricula= target.parents("tr").find("td").eq(3).html();
        coor= target.parents("tr").find("td").eq(4).html();
        
        
        $("#lbcodigo").text(idAlumno);
        $("#lbnombres").text(nombres);
        $("#lbtelefono").text(apellidos);
        $("#lbcorreo").text(direccion);
        $("#lbdia").text(matricula);
        $("#lbsupervisor").text(coor);
        
        
        
    });

    $('#actualizar').click(function(){
        var accion= $('#actualizar').val();
        var dataAut=$('#formulario').serialize();
        
        
        $('#resultados1').html('<h4>  <img src="../img/carga.gif" width="15" alt=""/> Ejecutando Transacción</h4>')
        $.ajax({
            type: 'POST',
            url: '../Tecnico',
            data:(dataAut+'&&actualizar='+accion),
            success: function(resp){
                if(resp!=""){
                    $('#resultados1').html(resp);
                    $('#foot').show();
                    $('#acept').show();
                    
                }
            }
        });
        
    });
    
    $('#actualizar1').click(function(){
        var accion= $('#actualizar1').val();
        $('#txtcodigo').removeAttr("disabled");
        var dataAut=$('#formulario').serialize();
        
     
        $('#resultados1').html('<h4>  <img src="../img/carga.gif" width="15" alt=""/> Ejecutando Transacción</h4>')
        $.ajax({
            type: 'POST',
            url: '../Tecnico',
            data:(dataAut+'&&actualizar='+accion),
            success: function(resp){
                if(resp!=""){
                    $('#txtcodigo').attr('disabled','disabled');
                    $('#resultados1').html(resp);
                    $('#foot').show();
                    $('#acept').show();
                    
                }
            }
        });
        
    });
    
    $('#actualizar2').click(function(){
        var accion= $('#actualizar2').val();
        
        var dataAut='txtcodigo=' + $('#lbcodigo').text();
        
        
        $('#resultados2').html('<h4>  <img src="../img/carga.gif" width="15" alt=""/> Ejecutando Transacción</h4>')
        $.ajax({
            type: 'POST',
            url: '../Tecnico',
            data:(dataAut+'&&actualizar='+accion),
            success: function(resp){
                if(resp!=""){
                    $('#txtcodigo').attr('disabled','disabled');
                    $('#resultados2').html(resp);
                    $('#foot2').show();
                    $('#acept2').show();
                    
                }
            }
        });
        
    });

    $('#acept').click(function(){
        
        $('#foot').hide();
        $('#acept').hide();
        
        var envio = $('#search').val();
        var envio1 = $('#campo').val();

        $('#resultados').html('<h2>  <img src="../img/carga.gif" width="35" alt=""/> Buscando</h2>');

        $.ajax({
                type: 'POST',
                url: 'Visualizar_Tecnico.jsp',
                data:('search='+envio+'&&'+'campo='+envio1),
                success: function(resp){
                    if(resp!=""){
                            $('#resultados').html(resp);
                    }
                }
        });
        
    });
    
       $('#acept2').click(function(){
        
        $('#foot2').hide();
        $('#acept2').hide();
        
        var envio = $('#search').val();
        var envio1 = $('#campo').val();

        $('#resultados').html('<h2>  <img src="../img/carga.gif" width="35" alt=""/> Buscando</h2>');

        $.ajax({
                type: 'POST',
                url: 'Visualizar_Tecnico.jsp',
                data:('search='+envio+'&&'+'campo='+envio1),
                success: function(resp){
                    if(resp!=""){
                            $('#resultados').html(resp);
                    }
                }
        });
        
    });

    $('#news').click(function(){
        clean();
        $('#actualizar1').hide();
        $('#actualizar').show();
    });

     
});

