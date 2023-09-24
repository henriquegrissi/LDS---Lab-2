package lds_lab2.lab2_gestao_automoveis.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lds_lab2.lab2_gestao_automoveis.enums.TipoAgente;

public record AgenteRequest(
        @NotBlank String nome,
        @NotBlank String endereco,
        @NotBlank String login,
        @NotBlank String senha,
        @NotBlank String cnpj,
        @NotNull TipoAgente tipoAgente) {
}
