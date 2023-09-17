package lds_lab2.lab2_gestao_automoveis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lds_lab2.lab2_gestao_automoveis.model.AgenteModel;

@Repository
public interface AgenteRepository extends CrudRepository<AgenteModel, String>{
    
}
