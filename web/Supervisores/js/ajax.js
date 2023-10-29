

function clean(){
        $("#txtcodigo").val("");
        $("#txtnombres").val("");
        $("#txtapellidos").val("");
        $("#txtcorreo").val("");
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
                url: 'Visualizar_Supervisor.jsp',
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
            url: 'Visualizar_Supervisor.jsp',
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
        var target,id;
        var columna1,columna2,columna3,columna4,columna5,columna6;
        target = $(event.target);
        id = target.parents("tr").data('id');
        
        
        columna1= target.parents("tr").find("td").eq(0).html();
        columna2= target.parents("tr").find("td").eq(1).html();
        columna3= target.parents("tr").find("td").eq(2).html();
        columna4= target.parents("tr").find("td").eq(3).html();
        
        columna5= target.parents("tr").find("td").eq(4).html();
        columna6= target.parents("tr").find("td").eq(5).html();
        

        $("#txtcodigo").val(id);
        $("#txtnombres").val(columna1);
        $("#txtapellidos").val(columna2);
        $("#txttelefono").val(columna3);
        $("#txtcorreo").val(columna4);
        
        $("#txtusuario").val(columna5);
        $("#txtclave").val(columna6);
        
        
      
        

    });

    $("body").on("click","#resultados button",function(event){
        event.preventDefault();
        var target,id;
        var columna1,columna2,columna3,columna4,columna5,columna6;
        target = $(event.target);
        id = target.parents("tr").data('id');
        
        
        columna1= target.parents("tr").find("td").eq(0).html();
        columna2= target.parents("tr").find("td").eq(1).html();
        columna3= target.parents("tr").find("td").eq(2).html();
        columna4= target.parents("tr").find("td").eq(3).html();
        
        columna5= target.parents("tr").find("td").eq(4).html();
        columna6= target.parents("tr").find("td").eq(5).html();
        

        $("#lbcodigo").text(id);
        $("#lbnombres").text(columna1);
        $("#lbapellidos").text(columna2);
        $("#lbtelefono").text(columna3);
        $("#lbcorreo").text(columna4);
        
        
        
    });

    $('#actualizar').click(function(){
        var accion= $('#actualizar').val();
        var dataAut=$('#formulario').serialize();
        
        $('#resultados1').html('<h4>  <img src="../img/carga.gif" width="15" alt=""/> Ejecutando Transacción</h4>')
        $.ajax({
            type: 'POST',
            url: '../Supervisor',
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
            url: '../Supervisor',
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
            url: '../Supervisor',
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
                url: 'Visualizar_Supervisor.jsp',
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
                url: 'Visualizar_Supervisor.jsp',
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

