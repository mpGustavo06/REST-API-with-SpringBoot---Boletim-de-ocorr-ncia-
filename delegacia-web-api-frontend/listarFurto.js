var listarProcessos = function() {
    $.ajax({
        url: "http://localhost:8080/api/boletins",
        type: 'GET',
        async: true,
        contentType: 'application/json',
        success: function(boletins) {
			$("#loading").hide();
            limparTabela();
            $.each(boletins, function(index, bo) {   
					var novaLinha =
                    '<tr>' +
                    '<th class="org-left row">' + bo.identificador + '</th>' +
                    '<td style="text-align: center">' + bo.dataOcorrido + '</td>' +
                    '<td style="text-align: center">' + bo.periodoOcorrido + '</td>' +
                    '<td style="text-align: center">' + bo.localOcorrido.cidade + '</td>' +
                    '<td style="text-align: center">' + bo.localOcorrido.estado + '</td>' +
                    '<td style="text-align: center">' + bo.veiculoFurtado.marca + '</td>' +
                    '<td style="text-align: center">' + bo.veiculoFurtado.tipoVeiculo + '</td>' +
                    '<td style="text-align: center">' + bo.veiculoFurtado.emplacamento.codigo + '</td>' +
                    '<td style="text-align: center">' + bo.veiculoFurtado.cor +'</td>' +
                    '</tr>';
                $("#theftTable tr:last").after(novaLinha);
            });
        },
        error: function() {

        }
    });
};

var limparTabela = function() {
    $("#theftTable").find("tr:gt(0)").remove();
}

var consultar = function(urlContato) {
    sessionStorage.setItem("urlContato", urlContato);
    window.location.href = "consulta.html";
}

$(document).ready(function() {
    listarProcessos();    
});