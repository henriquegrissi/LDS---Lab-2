package lds_lab2.lab2_gestao_automoveis.request;

import jakarta.validation.constraints.NotNull;

public record AtualizarPedidoRequest(
    @NotNull int idPedido,
    Integer idVeiculo,
    Integer quantidadeDeDias) {
    
}
