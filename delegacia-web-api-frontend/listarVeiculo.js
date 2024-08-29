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
                    '<th class="thResult user-select-all bg-dark">' + veic.emplacamento.codigo + '</th>' +
                    '<td class="thResult user-select-all bg-dark">' + veic.emplacamento.cidade + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + veic.emplacamento.estado + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + veic.anoFabricacao+ '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + veic.cor + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + veic.marca + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + veic.tipoVeiculo + '</td>' +
                    '</tr>';
                $("#carTable tbody:last").after(novaLinha);
            });
        },
        error: function (xhr, status, error) {
            $("#message").empty();
            $("#message").append(xhr.responseText)
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
                            '<th class="thResult user-select-all bg-dark">' + veic.emplacamento.codigo + '</th>' +
                            '<td class="thResult user-select-all bg-dark">' + veic.emplacamento.cidade + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + veic.emplacamento.estado + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + veic.anoFabricacao+ '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + veic.cor + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + veic.marca + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + veic.tipoVeiculo + '</td>' +
                            '</tr>';
                        $("#carTable tbody:last").after(novaLinha);
                    });
                    document.getElementById('filterValue').value = '';
                },
                error: function (xhr, status, error) {
                    $("#message").empty();
                    $("#message").append('Erro ao procurar por '+$(".form-select").val()+': '+$("#filterValue").val()+'!');
                    document.getElementById('filterValue').value = '';
                }
            });
        }
    });
};

var limparTabela = function () {
    $("#carTable").find("tr:gt(0)").remove();
}
