package lds_lab2.lab2_gestao_automoveis.dto.mapper;

import lds_lab2.lab2_gestao_automoveis.dto.ClienteDto;
import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;

public class ClientMapper {
    
        public ClienteDto toDTO(ClienteModel client) {
        if (client == null) {
            return null;
        }

        return new ClienteDto(client.getNome(), client.getEndereco(), client.getLogin(),
                                client.getSenha(),client.getProfissao(), client.getEntidadeEmpregaticia(),
                                client.getRendimentosAuferidos(), client.getCpf(),client.getRg());
    }

    public ClienteModel toEntity(ClienteDto ClientDTO) {
        if (ClientDTO == null) {
            return null;
        }
        ClienteModel client = new ClienteModel();

        client.setNome(ClientDTO.nome());
        client.setEndereco(ClientDTO.endereco());
        client.setLogin(ClientDTO.login());
        client.setSenha(ClientDTO.senha());
        client.setProfissao(ClientDTO.profissao());
        client.setEntidadeEmpregaticia(ClientDTO.entidadeEmpregaticia());
        client.setRendimentosAuferidos(ClientDTO.rendimentosAuferidos());
        client.setCpf(ClientDTO.cpf());
        client.setRg(ClientDTO.rg());

        return client;
    }

}
