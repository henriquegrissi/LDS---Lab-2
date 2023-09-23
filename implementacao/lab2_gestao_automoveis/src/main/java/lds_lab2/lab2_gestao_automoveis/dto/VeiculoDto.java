package lds_lab2.lab2_gestao_automoveis.dto;

import jakarta.validation.constraints.NotBlank;

public record VeiculoDto(
        @NotBlank Long id,
        @NotBlank String marca,
        @NotBlank String placa,
        @NotBlank String modelo,
        @NotBlank String ano,
        @NotBlank boolean alugado
        ) {

}
