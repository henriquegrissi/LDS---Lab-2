package lds_lab2.lab2_gestao_automoveis.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lds_lab2.lab2_gestao_automoveis.enums.TipoContrato;
import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;
import lds_lab2.lab2_gestao_automoveis.model.AgenteModel;
import lds_lab2.lab2_gestao_automoveis.model.ContratoModel;
import lds_lab2.lab2_gestao_automoveis.model.PedidoAluguelModel;
import lds_lab2.lab2_gestao_automoveis.repository.AgenteRepository;
import lds_lab2.lab2_gestao_automoveis.repository.ClienteRepository;
import lds_lab2.lab2_gestao_automoveis.repository.ContratoRepository;
import lds_lab2.lab2_gestao_automoveis.repository.PedidoAluguelRepository;
import lds_lab2.lab2_gestao_automoveis.request.CadastrarContratoRequest;

@RestController
@RequestMapping("contrato")
@CrossOrigin(origins = "http://localhost:5173")
public class ContratoController {
    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private PedidoAluguelRepository pedidoAluguelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AgenteRepository agenteRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastrarContratoRequest cadastrarContratoRequest) {
        Optional<PedidoAluguelModel> pedidoAluguel = pedidoAluguelRepository
                .findById(cadastrarContratoRequest.idPedido());

        if (pedidoAluguel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não encontrado pedido para o id:" + cadastrarContratoRequest.idPedido());
        }

        PedidoAluguelModel pedidoAluguelModel = pedidoAluguel.get();
        ContratoModel contrato = new ContratoModel();
        contrato.setPedidoAluguel(pedidoAluguelModel);
        contrato.setValor(pedidoAluguelModel.getValorTotal());
        contrato.setTipoContrato(cadastrarContratoRequest.tipoContrato());

        if (cadastrarContratoRequest.tipoContrato() == TipoContrato.Credito) {
            Optional<AgenteModel> agente = agenteRepository.findById(cadastrarContratoRequest.idAgenteProprietario());
            if (agente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Não encontrado agente para o id:" + cadastrarContratoRequest.idAgenteProprietario());
            }
            contrato.setProprietarioAgente(agente.get());

        } else {
            Optional<ClienteModel> cliente = clienteRepository.findById(cadastrarContratoRequest.idClienteProprietario());
            if (cliente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Não encontrado cliente para o id:" + cadastrarContratoRequest.idClienteProprietario());
            }
            contrato.setProprietarioCliente(cliente.get());

        }

        return ResponseEntity.status(HttpStatus.CREATED).body(contratoRepository.save(contrato));
    }
}
