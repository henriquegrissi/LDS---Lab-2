package lds_lab2.lab2_gestao_automoveis.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lds_lab2.lab2_gestao_automoveis.model.AgenteModel;

@Repository
public interface AgenteRepository extends CrudRepository<AgenteModel, String>{
    Optional<AgenteModel> findByLoginAndSenha(String login, String senha);
}
