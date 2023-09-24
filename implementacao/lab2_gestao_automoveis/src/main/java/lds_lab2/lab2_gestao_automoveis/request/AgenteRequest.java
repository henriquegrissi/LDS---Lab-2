package lds_lab2.lab2_gestao_automoveis.request;

import jakarta.validation.constraints.NotBlank;

public record AgenteRequest(
        @NotBlank String nome,
        @NotBlank String endereco,
        @NotBlank String login,
        @NotBlank String senha,
        @NotBlank String cnpj,
        @NotBlank String tipoAgente) {
}
