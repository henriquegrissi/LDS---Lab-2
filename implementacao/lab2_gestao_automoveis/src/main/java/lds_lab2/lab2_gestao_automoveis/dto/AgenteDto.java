package lds_lab2.lab2_gestao_automoveis.dto;

import jakarta.validation.constraints.NotBlank;

public record AgenteDto(
                @NotBlank String nome,
                @NotBlank String endereco,
                @NotBlank String login,
                @NotBlank String senha,
                @NotBlank String cnpj,
                @NotBlank String tipoAgente) {
}
