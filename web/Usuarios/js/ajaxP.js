function combo(x,a){
        
        $.ajax({
            type: 'POST',
            url: 'Lista_Grado.jsp',
            data:('campo='+x+'&selec='+a),
            success: function(resp){
                    if(resp!=""){
                            $('#grados').html(resp);
                    }
            }
        });
        
};

function clean(){
        $("#txtnumero").val("");
        $('#txtnumero').removeAttr("disabled");
        $("#txtmonto").val("");
        $("#txtcheque").val("");
        $("#txtbanco").val("");
        $("#txtfecha").val("");
        
        $("#dropconcepto").val(0);
        $("#droptipo").val(0);
        
        
        
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
                url: 'VisualizarA.jsp',
                data:('search='+envio+'&&'+'campo='+envio1),
                success: function(resp){
                    if(resp!=""){
                            $('#resultados').html(resp);
                    }
                }
        });
    });

    $('#txtfechanac').keyup(function(){
        var start = new Date($('#txtfechanac').val());
        var end   = new Date();
        var edad = end.getFullYear() - start.getFullYear();
        var m = end.getMonth() - start.getMonth();

        if (m < 0 || (m === 0 && end.getDate() <= start.getDate())) {
            edad--;
        }
        if(edad>0){
            $('#txtedad').val(edad);
        }
        
    });
    
    $('#document').ready(function(){
        var envio = $('#search').val();
        var envio1 = $('#campo').val();

        $('#resultados').html('<h2>  <img src="../img/carga.gif" width="35" alt=""/> Buscando</h2>');
        
        combo(0,0);
        $.ajax({
            type: 'POST',
            url: 'VisualizarA.jsp',
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
            
        var target,idAlumno;
        target = $(event.target);
        idAlumno = target.parents("tr").data('id');
        
        $('#txtalumno').val(idAlumno);
        $('#lbalumno').text(idAlumno);
        $('#resultados2').html('<h2>  <img src="../img/carga.gif" width="35" alt=""/> Buscando</h2>');

        $.ajax({
                type: 'POST',
                url: 'Historial.jsp',
                data:('search='+idAlumno),
                success: function(resp){
                    if(resp!=""){
                            $('#resultados2').html(resp);
                    }
                }
        });
        
        $('#nuevos').show();
        
    });

    $("body").on("click","#resultados2 a",function(event){
        event.preventDefault();
        
        var target,idAlumno,numero,monto,cheque,banco,fecha,concepto,tipo;
        
        target = $(event.target);
        concepto = target.parents("tr").data('id');
        tipo = target.parents("tr").data('id2');
        
        numero= target.parents("tr").find("td").eq(0).html();
        monto= target.parents("tr").find("td").eq(2).html();
        cheque= target.parents("tr").find("td").eq(4).html();
        banco= target.parents("tr").find("td").eq(5).html();
        fecha= target.parents("tr").find("td").eq(6).html();
        
        
        $("#txtnumero").val(numero);
        $("#txtmonto").val(monto);
        $("#txtcheque").val(cheque);
        $("#txtbanco").val(banco);
        var newdate = fecha.split("/").reverse().join("-");
        $("#txtfecha").val(newdate);
        
        $("#dropconcepto").val(concepto);
        $("#droptipo").val(tipo);
        
        $("#actualizar").hide();
        $("#actualizar1").show();
        $('#txtnumero').attr('disabled','disabled');
        
    });
    
    $("body").on("click","#resultados2 button",function(event){
        event.preventDefault();
        
        
        var target,idAlumno,numero,monto,cheque,banco,fecha,concepto,tipo;
        var fechas;
        target = $(event.target);
        concepto = target.parents("tr").find("td").eq(1).html();
        tipo = target.parents("tr").find("td").eq(3).html();
        
        numero= target.parents("tr").find("td").eq(0).html();
        monto= target.parents("tr").find("td").eq(2).html();
        cheque= target.parents("tr").find("td").eq(4).html();
        banco= target.parents("tr").find("td").eq(5).html();
        fecha= target.parents("tr").find("td").eq(6).html();
        
        
        $("#lbnumero").text(numero);
        $("#lbmonto").text(monto);
        $("#lbcheque").text(cheque);
        $("#lbbanco").text(banco);
        
        $("#lbfecha").text(fecha);
        
        $("#lbconcepto").text(concepto);
        $("#lbtipo").text(tipo);
        
    });


    
    $('#actualizar').click(function(){
        var accion= $('#actualizar').val();
        var dataAut=$('#formulario').serialize();
        
        $('#resultados1').html('<h4>  <img src="../img/carga.gif" width="15" alt=""/> Ejecutando Transacción</h4>')
        $.ajax({
            type: 'POST',
            url: '../Recibo',
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
        $('#txtnumero').removeAttr("disabled");
        var dataAut=$('#formulario').serialize();
        $('#resultados1').html('<h4>  <img src="../img/carga.gif" width="15" alt=""/> Ejecutando Transacción</h4>')
        $.ajax({
            type: 'POST',
            url: '../Recibo',
            data:(dataAut+'&&actualizar='+accion),
            success: function(resp){
                if(resp!=""){
                    $('#txtnumero').attr('disabled','disabled');
                    $('#resultados1').html(resp);
                    $('#foot').show();
                    $('#acept').show();
                    
                }
            }
        });
        
    });
    
    $('#actualizar2').click(function(){
        var accion= $('#actualizar2').val();
        
        var dataAut='txtnumero=' + $('#lbnumero').text();
        
        
        $('#resultados3').html('<h4>  <img src="../img/carga.gif" width="15" alt=""/> Ejecutando Transacción</h4>')
        $.ajax({
            type: 'POST',
            url: '../Recibo',
            data:(dataAut+'&&actualizar='+accion),
            success: function(resp){
                if(resp!=""){
                    
                    $('#resultados3').html(resp);
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
        var idAlumno;
        idAlumno= $('#txtalumno').val();
        $('#resultados2').html('<h2>  <img src="../img/carga.gif" width="35" alt=""/> Buscando</h2>');

        $.ajax({
                type: 'POST',
                url: 'Historial.jsp',
                data:('search='+idAlumno),
                success: function(resp){
                    if(resp!=""){
                            $('#resultados2').html(resp);
                    }
                }
        });
        
        
    });
    
    $('#acept2').click(function(){
        
        $('#foot2').hide();
        $('#acept2').hide();
        
        var idAlumno;
        idAlumno= $('#lbalumno').text();
        
        $('#resultados2').html('<h2>  <img src="../img/carga.gif" width="35" alt=""/> Buscando</h2>');

        $.ajax({
                type: 'POST',
                url: 'Historial.jsp',
                data:('search='+idAlumno),
                success: function(resp){
                    if(resp!=""){
                            $('#resultados2').html(resp);
                    }
                }
        });
        
        
    });

    $('#news').click(function(){
        clean();
        $("#actualizar").show();
        $("#actualizar1").hide();
    });

     
});

