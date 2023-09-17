package lds_lab2.lab2_gestao_automoveis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, String>{
    
}
