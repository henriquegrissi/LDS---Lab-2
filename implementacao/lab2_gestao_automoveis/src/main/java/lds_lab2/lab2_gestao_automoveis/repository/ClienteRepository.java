package lds_lab2.lab2_gestao_automoveis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer>{
    public Optional<ClienteModel> findByLogin(String login);
    public Optional<ClienteModel> findByLoginAndSenha(String login, String senha);
}
