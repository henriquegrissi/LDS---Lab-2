package lds_lab2.lab2_gestao_automoveis.dto.mapper;

import java.util.Locale.Category;

import lds_lab2.lab2_gestao_automoveis.dto.ClientDTO;
import lds_lab2.lab2_gestao_automoveis.model.Client;

public class ClientMapper {
    
        public ClientDTO toDTO(Client client) {
        if (client == null) {
            return null;
        }
        return new ClientDTO(client.getId(), client.getNome(), client.getEndereco(), client.getLogin(),
                                client.getSenha(),client.getProfissao(), client.getEntidadeEmpregaticia(),
                                client.getRendimentosAuferidos(), client.getCpf(),client.getRg());
    }

    public Client toEntity(ClientDTO ClientDTO) {
        if (ClientDTO == null) {
            return null;
        }
        Client client = new Client();
        if (ClientDTO.id() != null) {
            client.setId(ClientDTO.id());
        }
        client.setNome(ClientDTO.nome());
        client.setEndereco(ClientDTO.endereco());
        client.setLogin(ClientDTO.login());
        client.setSenha(ClientDTO.senha());
        client.setProfissao(ClientDTO.prfissao());
        client.setEntidadeEmpregaticia(ClientDTO.entidadeEmpregaticia());
        client.setRendimentosAuferidos(ClientDTO.rendimentosAuferidos());
        client.setCpf(ClientDTO.cpf());
        client.setRg(ClientDTO.rg());

        return client;
    }

}
