var cadastrar = function () {
    var boletim = {
        identificador: $("#identificador").val(),
        localOcorrido: {
            rua: $("#rua").val(),
            numero: $("#numero").val(),
            bairro: $("#bairro").val(),
            cidade: $("#cidade").val(),
            estado: $("#estado").val()
        },
        veiculoFurtado: {
            emplacamento: {
                codigo: $("#placa").val(),
                estado: $("#estadoPlaca").val(),
                cidade: $("#cidadePlaca").val()
            },
            anoFabricacao: $("#ano").val(),
            cor: $("#cor").val(),
            marca: $("#marca").val(),
            tipoVeiculo: $("#tipo").val()
        },
        envolvidos: {
            nome: $("#nome").val(),
            email: $("#email").val(),
            telefone: $("#telefone").val()
        },
        crime: $("#crime").val(),
        dataOcorrido: $("#data").val(),
        periodoOcorrido: $("#periodo").val()
    }

    $.ajax({
        url: "http://localhost:8080/api/boletins",
        type: "PUT",
        async: true,
        contentType: "application/json",
        data: JSON.stringify(boletim),
        success: function (boletimCadastrado) {
            $("#message").empty();
            $("#message").append("Alteração realizada! <br> Identificador: " + boletimCadastrado.identificador);
        },
        error: function (xhr, status, erro) {
            $("#message").empty();
            $("#message").append(xhr.responseText)
        }
    });
};

var processarDados = function () {
    const params = new URLSearchParams(window.location.search);

    document.getElementById('identificador').value = params.get('identificador');
    document.getElementById('rua').value = params.get('rua');
    document.getElementById('numero').value = params.get('numero');
    document.getElementById('bairro').value = params.get('bairro');
    document.getElementById('cidade').value = params.get('cidade');
    document.getElementById('estado').value = params.get('estado');
    document.getElementById('placa').value = params.get('placa');
    document.getElementById('cidadePlaca').value = params.get('cidadePlaca');
    document.getElementById('estadoPlaca').value = params.get('estadoPlaca');
    document.getElementById('ano').value = params.get('ano');
    document.getElementById('cor').value = params.get('cor');
    document.getElementById('marca').value = params.get('marca');
    document.getElementById('tipo').value = params.get('tipo');
    document.getElementById('crime').value = params.get('crime');
    document.getElementById('data').value = params.get('dataOcorrido');
    document.getElementById('periodo').value = params.get('periodoOcorrido');
};

$(document).ready(function () {
    processarDados();

    $("#btnAlterar").click(function () {
        cadastrar("http://localhost:8080/api/boletins");
    });
}); 