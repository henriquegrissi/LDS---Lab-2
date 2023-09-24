package lds_lab2.lab2_gestao_automoveis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lds_lab2.lab2_gestao_automoveis.model.AgenteModel;

@Repository
public interface AgenteRepository extends JpaRepository<AgenteModel, Integer>{
    public Optional<AgenteModel> findByLogin(String login);
    public Optional<AgenteModel> findByLoginAndSenha(String login, String senha);
}