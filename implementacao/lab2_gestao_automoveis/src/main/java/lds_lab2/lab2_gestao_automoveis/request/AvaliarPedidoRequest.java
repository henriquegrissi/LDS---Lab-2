package lds_lab2.lab2_gestao_automoveis.request;

import jakarta.validation.constraints.NotNull;

public record AvaliarPedidoRequest(
    @NotNull int idPedido,
    @NotNull int nota,
    String comentariosAvaliacao) {
}
