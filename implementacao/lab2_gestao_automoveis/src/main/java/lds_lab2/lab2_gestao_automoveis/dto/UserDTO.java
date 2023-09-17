package lds_lab2.lab2_gestao_automoveis.dto;
import org.antlr.v4.runtime.misc.NotNull;

public record UserDTO(
                Long id,
                String nome,
                String endereco,
                String login,
                String senha
                ) {

}
