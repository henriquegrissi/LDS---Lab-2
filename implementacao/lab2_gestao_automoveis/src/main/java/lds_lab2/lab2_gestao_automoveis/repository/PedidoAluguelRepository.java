package lds_lab2.lab2_gestao_automoveis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lds_lab2.lab2_gestao_automoveis.model.PedidoAluguelModel;

@Repository
public interface PedidoAluguelRepository extends JpaRepository<PedidoAluguelModel, Integer>{
    public Optional<Iterable<PedidoAluguelModel>> findByCliente_Id(int idCliente);
}
