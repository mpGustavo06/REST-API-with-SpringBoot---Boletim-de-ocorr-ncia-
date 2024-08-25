$(document).ready(function () {
    listarProcessos();
    listarProcessosFiltro();
});

var listarProcessos = function () {
    $.ajax({
        url: "http://localhost:8080/api/boletins",
        type: 'GET',
        async: true,
        contentType: 'application/json',
        success: function (boletins) {
            $("#message").empty();
            $("#loading").hide();
            limparTabela();
            $.each(boletins, function (index, bo) {
                var novaLinha =
                    '<tr>' +
                    '<th class="tableResult">' + bo.identificador + '</th>' +
                    '<td class="tableResult">' + bo.dataOcorrido + '</td>' +
                    '<td class="tableResult">' + bo.periodoOcorrido + '</td>' +
                    '<td class="tableResult">' + bo.localOcorrido.cidade + '</td>' +
                    '<td class="tableResult">' + bo.localOcorrido.estado + '</td>' +
                    '<td class="tableResult">' + bo.veiculoFurtado.marca + '</td>' +
                    '<td class="tableResult">' + bo.veiculoFurtado.tipoVeiculo + '</td>' +
                    '<td class="tableResult">' + bo.veiculoFurtado.emplacamento.codigo + '</td>' +
                    '<td class="tableResult">' + bo.veiculoFurtado.cor + '</td>' +
                    '</tr>';
                $("#theftTable tbody:last").after(novaLinha);
            });
        },
        error: function (xhr, status, error) {
            $("#message").empty();
            $("#message").append('Erro na requisição!')
        }
    });
};

var listarProcessosFiltro = function () {
    $(".filtrarBoletim").on('click', function () {
        if ($(".form-select").val() == 'Escolha um filtro' || $("#filterValue").val() == '') {
            alert("Escolha um filtro!");
        }
        else {
            $.ajax({
                url: `http://localhost:8080/api/boletins?${$(".form-select").val()}=${$("#filterValue").val()}`,
                type: 'GET',
                async: true,
                contentType: 'application/json',
                success: function (boletins) {
                    $("#message").empty();
                    $("#loading").hide();
                    limparTabela();
                    $.each(boletins, function (index, bo) {
                        var novaLinha =
                            '<tr>' +
                            '<th class="tableResult">' + bo.identificador + '</th>' +
                            '<td class="tableResult">' + bo.dataOcorrido + '</td>' +
                            '<td class="tableResult">' + bo.periodoOcorrido + '</td>' +
                            '<td class="tableResult">' + bo.localOcorrido.cidade + '</td>' +
                            '<td class="tableResult">' + bo.localOcorrido.estado + '</td>' +
                            '<td class="tableResult">' + bo.veiculoFurtado.marca + '</td>' +
                            '<td class="tableResult">' + bo.veiculoFurtado.tipoVeiculo + '</td>' +
                            '<td class="tableResult">' + bo.veiculoFurtado.emplacamento.codigo + '</td>' +
                            '<td class="tableResult">' + bo.veiculoFurtado.cor + '</td>' +
                            '</tr>';
                        $("#theftTable tbody:last").after(novaLinha);
                    });
                },
                error: function (xhr, status, error) {
                    $("#message").empty();
                    $("#message").append('Erro na requisição!')
                }
            });
        }
    });
};

var consultar = function (urlContato) {
    sessionStorage.setItem("urlContato", urlContato);
    window.location.href = "consulta.html";
}

var limparTabela = function () {
    $("#theftTable").find("tr:gt(0)").remove();
}
