package lds_lab2.lab2_gestao_automoveis.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, String>{
    Optional<ClienteModel> findByLoginAndSenha(String login, String senha);
}
