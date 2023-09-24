package lds_lab2.lab2_gestao_automoveis.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @NotBlank String login,
    @NotBlank String senha){
}