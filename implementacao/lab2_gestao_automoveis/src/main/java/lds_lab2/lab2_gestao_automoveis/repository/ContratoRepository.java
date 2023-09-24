package lds_lab2.lab2_gestao_automoveis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lds_lab2.lab2_gestao_automoveis.model.ContratoModel;

@Repository
public interface ContratoRepository extends JpaRepository<ContratoModel, Integer>{
}
