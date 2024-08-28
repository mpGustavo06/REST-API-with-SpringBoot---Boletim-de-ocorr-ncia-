$(document).ready(function () {
    listarProcessos();
    listarProcessosFiltro();
    deletarBoletim();
    alterarBoletim();
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
                    '<th class="thResult user-select-all bg-dark">' + bo.identificador + '</th>' +
                    '<td class="thResult user-select-all bg-dark">' + bo.dataOcorrido + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + bo.periodoOcorrido + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + bo.localOcorrido.cidade + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + bo.localOcorrido.estado + '</td>' +
                    '<td class="thResult user-select-all bg-dark" style="width: 300px;">' + bo.crime + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + bo.veiculoFurtado.emplacamento.codigo + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + bo.veiculoFurtado.marca + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + bo.veiculoFurtado.tipoVeiculo + '</td>' +
                    '<td class="thResult user-select-all bg-dark">' + bo.veiculoFurtado.cor + '</td>' +
                    '</tr>';
                $("#theftTable tbody:last").after(novaLinha);
            });
        },
        error: function (xhr, status, error) {
            $("#message").empty();
            $("#message").append(xhr.responseText)
        }
    });
};

var listarProcessosFiltro = function () {
    $(".filtrarBoletim").on('click', function () {
        if ($(".form-select").val() == 'Escolha um filtro' && $("#filterValue").val() == '') {
            limparTabela();
            alert("Escolha um filtro!");
        }
        else if ($(".form-select").val() != 'Escolha um filtro' && $("#filterValue").val() == '') {
            window.location.reload(true);
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
                            '<tr class="trResult">' +
                            '<th class="thResult user-select-all bg-dark">' + bo.identificador + '</th>' +
                            '<td class="thResult user-select-all bg-dark">' + bo.dataOcorrido + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + bo.periodoOcorrido + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + bo.localOcorrido.cidade + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + bo.localOcorrido.estado + '</td>' +
                            '<td class="thResult user-select-all bg-dark" style="width: 300px;">' + bo.crime + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + bo.veiculoFurtado.emplacamento.codigo + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + bo.veiculoFurtado.marca + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + bo.veiculoFurtado.tipoVeiculo + '</td>' +
                            '<td class="thResult user-select-all bg-dark">' + bo.veiculoFurtado.cor + '</td>' +
                            '</tr>';
                        $("#theftTable tbody:last").after(novaLinha);
                    });
                },
                error: function (xhr, status, erro) {
                    limparTabela();
                    $("#message").empty();
                    $("#message").append('Erro ao procurar por ' + $(".form-select").val() + ': ' + $("#filterValue").val() + '!');
                }
            });
        }
    });
};

var deletarBoletim = function () {
    $(".deletar").on('click', function () {
        var identificador = $("#deleteValue").val();

        $.ajax({
            url: `http://localhost:8080/api/boletins?identificador=${identificador}`,
            type: 'DELETE',
            async: true,
            contentType: 'application/json',
            success: function (removido) {
                $("#message").empty();
                limparTabela();
                $("#message").html(removido)
            },
            error: function (xhr, status, error) {
                $("#message").empty();
                $("#message").append('Não foi possível remover: ' + registro)
            }
        });
    });
}

var alterarBoletim = function () {
    $(".alterar").on('click', function () {
        $.ajax({
            url: `http://localhost:8080/api/boletins?identificador=${$("#alterValue").val()}`,
            type: 'GET',
            async: true,
            contentType: 'application/json',
            success: function (boletins) {
                $("#message").empty();
                $("#loading").hide();
                limparTabela();
                $.each(boletins, function (index, bo) {
                    location.href = `alterar.html?identificador=${bo.identificador}&dataOcorrido=${bo.dataOcorrido}&periodoOcorrido=${bo.periodoOcorrido}&crime=${bo.crime}&envolvidos=${bo.envolvidos}&tipo=${bo.veiculoFurtado.tipoVeiculo}&marca=${bo.veiculoFurtado.marca}&cor=${bo.veiculoFurtado.cor}&ano=${bo.veiculoFurtado.anoFabricacao}&envolvidoEm=${bo.veiculoFurtado.envolvidoEm}&placa=${bo.veiculoFurtado.emplacamento.codigo}&cidadePlaca=${bo.veiculoFurtado.emplacamento.cidade}&estadoPlaca=${bo.veiculoFurtado.emplacamento.estado}&rua=${bo.localOcorrido.rua}&numero=${bo.localOcorrido.numero}&bairro=${bo.localOcorrido.bairro}&cidade=${bo.localOcorrido.cidade}&estado=${bo.localOcorrido.estado}`;
                });
            },
            error: function (xhr, status, erro) {
                limparTabela();
                $("#message").empty();
                $("#message").append('Erro ao procurar por identificador: '+ $("#alterValue").val() + '!');
            }
        });
    });
}

var limparTabela = function () {
    $("#theftTable").find("tr:gt(0)").remove();
}
