package lds_lab2.lab2_gestao_automoveis.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDto(
        @NotBlank String nome,
        @NotBlank String endereco,
        @NotBlank String login,
        @NotBlank String senha,
        @NotBlank String profissao,
        @NotBlank String entidadeEmpregaticia,
        @NotNull List<Integer> rendimentosAuferidos,
        @NotBlank String cpf,
        @NotBlank String rg) {

}
