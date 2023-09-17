package lds_lab2.lab2_gestao_automoveis.dto;

import java.util.List;

public record ClientDTO(
                Long id,
                String nome,
                String endereco,
                String login,
                String senha,
                String prfissao,
                String entidadeEmpregaticia,
                List<Integer> rendimentosAuferidos,
                String cpf,
                String rg                
                ){
    
}
