$(document).ready(function () {
    listarProcessos();
    listarProcessosFiltro();
});

var listarProcessos = function () {
    $.ajax({
        url: "http://localhost:8080/api/veiculos",
        type: 'GET',
        async: true,
        contentType: 'application/json',
        success: function (veiculos) {
            $("#message").empty();
            $("#loading").hide();
            limparTabela();
            $.each(veiculos, function (index, veic) {
                var novaLinha =
                    '<tr>' +
                    '<th class="tableResult">' + veic.emplacamento.codigo + '</th>' +
                    '<td class="tableResult">' + veic.anoFabricacao+ '</td>' +
                    '<td class="tableResult">' + veic.cor + '</td>' +
                    '<td class="tableResult">' + veic.marca + '</td>' +
                    '<td class="tableResult">' + veic.tipoVeiculo + '</td>' +
                    '</tr>';
                $("#carTable tbody:last").after(novaLinha);
            });
        },
        error: function (xhr, status, error) {
            $("#message").empty();
            $("#message").append('Erro na requisição!')
        }
    });
};

var listarProcessosFiltro = function () {
    $(".filtrarVeiculos").on('click', function () {
        if ($(".form-select").val() == 'Escolha um filtro' && $("#filterValue").val() == '') {
            limparTabela();
            alert("Escolha um filtro!");
        }
        else if ($(".form-select").val() != 'Escolha um filtro' && $("#filterValue").val() == '') {
            window.location.reload(true);
        }
        else {
            $.ajax({
                url: `http://localhost:8080/api/veiculos?${$(".form-select").val()}=${$("#filterValue").val()}`,
                type: 'GET',
                async: true,
                contentType: 'application/json',
                success: function (veiculos) {
                    $("#message").empty();
                    $("#loading").hide();
                    limparTabela();
                    $.each(veiculos, function (index, veic) {
                        var novaLinha =
                            '<tr>' +
                            '<th class="tableResult">' + veic.emplacamento.codigo + '</th>' +
                            '<td class="tableResult">' + veic.anoFabricacao+ '</td>' +
                            '<td class="tableResult">' + veic.cor + '</td>' +
                            '<td class="tableResult">' + veic.marca + '</td>' +
                            '<td class="tableResult">' + veic.tipoVeiculo + '</td>' +
                            '</tr>';
                        $("#carTable tbody:last").after(novaLinha);
                    });
                },
                error: function (xhr, status, error) {
                    $("#message").empty();
                    $("#message").append('Erro ao procurar por '+$(".form-select").val()+': '+$("#filterValue").val()+'!');
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
    $("#carTable").find("tr:gt(0)").remove();
}
