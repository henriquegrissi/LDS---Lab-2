package lds_lab2.lab2_gestao_automoveis.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoRequest(
        @NotBlank String matricula,
        @NotBlank String marca,
        @NotBlank String placa,
        @NotBlank String modelo,
        @NotBlank String ano,
        @NotNull double valorAluguel
        ) {

}
