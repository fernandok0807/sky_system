$(function(){
    $('#search').focus();
    $('#buscador_form').submit(function(e){
        e.preventDefault();
    });

    $('#formulario').submit(function(e){
            e.preventDefault();
    });
    
    $('#formulario2').submit(function(e){
            e.preventDefault();
    });

    $('#search').keyup(function(){
        var envio = $('#search').val();
        var envio1 = $('#campo').val();

        $('#resultados').html('<h2>  <img src="../img/carga.gif" width="35" alt=""/> Buscando</h2>');

        $.ajax({
                type: 'POST',
                url: 'Visualizar_Visitas.jsp',
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
            url: 'Visualizar_Visitas.jsp',
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
        
        var target,id,idtecnico, idcliente,ccorreo;
        var columna1,columna2,columna3,columna4,columna5;
        target = $(event.target);
        
        id = target.parents("tr").data('id');
        idtecnico= target.parents("tr").data('idtecnico');
        idcliente= target.parents("tr").data('idcliente');
        ccorreo = target.parents("tr").data('ccliente');
        
        
        columna1= target.parents("tr").find("td").eq(0).html();
        columna2= target.parents("tr").find("td").eq(1).html();
        columna3= target.parents("tr").find("td").eq(2).html();
        columna4= target.parents("tr").find("td").eq(3).html();
        columna5= target.parents("tr").find("td").eq(4).html();
        
        
        $("#txtcodigo").val(id);
        $("#txttecnico").val(idtecnico);
        $("#txtcliente").val(idcliente);
        $("#txtingreso").val(columna2);
        $("#txtegreso").val(columna3);
        $("#txtcoordenada").val(columna5);
        
        $("#txtcorreo").val(ccorreo);
        
        
        
        
      

    });

    $("body").on("click","#resultados button",function(event){
        
        event.preventDefault();
        $('#actualizar1').show();
        $('#actualizar').hide();
        
        
        var target,id,idtecnico, idcliente;
        var columna1,columna2,columna3,columna4,columna5;
        target = $(event.target);
        
        id = target.parents("tr").data('id');
        idtecnico= target.parents("tr").data('idtecnico');
        idcliente= target.parents("tr").data('idcliente');
        
        
        
        columna1= target.parents("tr").find("td").eq(0).html();
        columna2= target.parents("tr").find("td").eq(1).html();
        columna3= target.parents("tr").find("td").eq(2).html();
        columna4= target.parents("tr").find("td").eq(3).html();
        columna5= target.parents("tr").find("td").eq(4).html();
        

        $("#txtcodigo2").val(id);
        $("#txttecnico2").val(idtecnico);
        $("#txtcliente2").val(idcliente);
        $("#txtingreso2").val(columna2);
        $("#txtegreso2").val(columna3);
        $("#txtcoordenada2").val(columna5);
        
        
        
        $("#lbcliente").text(columna1);
        $("#lbinicio").text(columna2);
        $("#lbfin").text(columna3);
        $("#lbcoordenada").text(columna5);
        
        
        
    });

    $('#actualizar').click(function(){
        var accion= $('#actualizar').val();
        var dataAut=$('#formulario').serialize();
        
        alert(dataAut);
        $('#resultados1').html('<h4>  <img src="../img/carga.gif" width="15" alt=""/> Ejecutando Transacción</h4>')
        $.ajax({
            type: 'POST',
            url: '../Visita',
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
            url: '../Visita',
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
        
        //var dataAut='txtcodigo=' + $('#lbcodigo').text();
        var dataAut=$('#formulario2').serialize();
        //alert(dataAut);
        
        $('#resultados2').html('<h4>  <img src="../img/carga.gif" width="15" alt=""/> Ejecutando Transacción</h4>')
        $.ajax({
            type: 'POST',
            url: '../Visita',
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
        $("#txtreporte").val("");
        $('#resultados').html('<h2>  <img src="../img/carga.gif" width="35" alt=""/> Buscando</h2>');

        $.ajax({
                type: 'POST',
                url: 'Visualizar_Visitas.jsp',
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
                url: 'Visualizar_Visitas.jsp',
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

