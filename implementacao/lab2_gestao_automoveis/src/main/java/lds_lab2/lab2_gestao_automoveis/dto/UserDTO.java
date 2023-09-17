package lds_lab2.lab2_gestao_automoveis.dto;

public record UserDTO(
        Long id,
        String nome,
        String endereco,
        String login,
        String senha) {

}
