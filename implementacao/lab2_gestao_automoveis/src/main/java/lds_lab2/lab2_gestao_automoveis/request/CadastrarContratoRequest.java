package lds_lab2.lab2_gestao_automoveis.request;

import jakarta.validation.constraints.NotNull;
import lds_lab2.lab2_gestao_automoveis.enums.TipoContrato;

public record CadastrarContratoRequest(
        @NotNull int idPedido,
        @NotNull TipoContrato tipoContrato,
        int idClienteProprietario,
        int idAgenteProprietario
        ) {
}
