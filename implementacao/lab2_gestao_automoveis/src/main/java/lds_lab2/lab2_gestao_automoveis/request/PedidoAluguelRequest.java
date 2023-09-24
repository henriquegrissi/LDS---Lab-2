package lds_lab2.lab2_gestao_automoveis.request;

import jakarta.validation.constraints.NotNull;

public record PedidoAluguelRequest(
    @NotNull int idCliente,
    @NotNull int idVeiculo,
    @NotNull int quantidadeDeDias){
}
