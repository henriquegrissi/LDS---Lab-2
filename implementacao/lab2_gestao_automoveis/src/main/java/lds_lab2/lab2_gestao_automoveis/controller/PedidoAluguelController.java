package lds_lab2.lab2_gestao_automoveis.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lds_lab2.lab2_gestao_automoveis.enums.StatusPedido;
import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;
import lds_lab2.lab2_gestao_automoveis.model.PedidoAluguelModel;
import lds_lab2.lab2_gestao_automoveis.model.VeiculoModel;
import lds_lab2.lab2_gestao_automoveis.repository.ClienteRepository;
import lds_lab2.lab2_gestao_automoveis.repository.PedidoAluguelRepository;
import lds_lab2.lab2_gestao_automoveis.repository.VeiculoRepository;
import lds_lab2.lab2_gestao_automoveis.request.AtualizarPedidoRequest;
import lds_lab2.lab2_gestao_automoveis.request.AvaliarPedidoRequest;
import lds_lab2.lab2_gestao_automoveis.request.PedidoAluguelRequest;

@RestController
@RequestMapping("pedido")
@CrossOrigin(origins = "http://localhost:5173")
public class PedidoAluguelController {
    @Autowired
    private PedidoAluguelRepository pedidoAluguelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping("/listar")
    public Iterable<PedidoAluguelModel> listarPedidos() {
        return pedidoAluguelRepository.findAll();
    }

    @GetMapping("/listarPedidosCliente/{idCliente}")
    public ResponseEntity<?> listarPedidosCliente(@PathVariable int idCliente) {
        Optional<Iterable<PedidoAluguelModel>> pedidosAluguel = pedidoAluguelRepository.findByCliente_Id(idCliente);

        Optional<ClienteModel> cliente = clienteRepository.findById(idCliente);

        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não encontrado cliente para o id:" + idCliente);
        }

        return ResponseEntity.status(HttpStatus.OK).body(pedidosAluguel);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> criarPedido(@RequestBody @Valid PedidoAluguelRequest pedidoAluguelRequest) {
        PedidoAluguelModel pedidoAluguel = new PedidoAluguelModel();

        Optional<ClienteModel> cliente = clienteRepository.findById(pedidoAluguelRequest.idCliente());
        Optional<VeiculoModel> veiculo = veiculoRepository.findById(pedidoAluguelRequest.idVeiculo());
        
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não encontrado cliente para o id:" + pedidoAluguelRequest.idCliente());
        }
        
        if(veiculo.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não encontrado veiculo para o id:" + pedidoAluguelRequest.idVeiculo());
        }

        BeanUtils.copyProperties(pedidoAluguelRequest, pedidoAluguel);
        
        pedidoAluguel.setCliente(cliente.get());
        pedidoAluguel.setVeiculo(veiculo.get());
        pedidoAluguel.setStatusPedido(StatusPedido.Pendente);
        pedidoAluguel.setValorTotal(pedidoAluguel.calcularValorTotal());

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoAluguelRepository.save(pedidoAluguel));
    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<?> cancelar(@PathVariable int id) {
        Optional<PedidoAluguelModel> pedidoAluguel = pedidoAluguelRepository.findById(id);

        if(pedidoAluguel.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não encontrado pedido para o id:" + id);
        }

        PedidoAluguelModel pedidoAluguelModel = pedidoAluguel.get();

        if(pedidoAluguelModel.getStatusPedido() != StatusPedido.Pendente) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status inválido para cancelamento");
        }

        pedidoAluguelModel.setStatusPedido(StatusPedido.Cancelado);
        pedidoAluguelRepository.save(pedidoAluguelModel);

        return ResponseEntity.status(HttpStatus.OK).body("Pedido cancelado com sucesso");
    }

    @PutMapping("/update")
    public ResponseEntity<?> atualizar(@RequestBody @Valid AtualizarPedidoRequest atualizarPedidoRequest){
        int idPedido = atualizarPedidoRequest.idPedido();

        Optional<PedidoAluguelModel> pedidoAluguel = pedidoAluguelRepository.findById(idPedido);
        
        if(pedidoAluguel.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não encontrado pedido para o id:" + idPedido);
        }

        PedidoAluguelModel pedido = pedidoAluguel.get();

        if(pedido.getStatusPedido() != StatusPedido.Pendente) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status inválido para cancelamento");
        }

        if(atualizarPedidoRequest.idVeiculo() != null){
            Optional<VeiculoModel> veiculo = veiculoRepository.findById(atualizarPedidoRequest.idVeiculo());
            
            if(veiculo.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não encontrado veiculo para o id:" + atualizarPedidoRequest.idVeiculo());
            }
            pedido.setVeiculo(veiculo.get());
            pedido.setValorTotal(pedido.calcularValorTotal());
        }

        if(atualizarPedidoRequest.quantidadeDeDias() != null){
            pedido.setQuantidadeDeDias(atualizarPedidoRequest.quantidadeDeDias());
            pedido.setValorTotal(pedido.calcularValorTotal());
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(pedidoAluguelRepository.save(pedido));
    }

    @PutMapping("/avaliar")
    public ResponseEntity<?> avaliar(@RequestBody @Valid AvaliarPedidoRequest avaliarPedidoRequest){
        int idPedido = avaliarPedidoRequest.idPedido();

        Optional<PedidoAluguelModel> pedidoAluguel = pedidoAluguelRepository.findById(idPedido);
        
        if(pedidoAluguel.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não encontrado pedido para o id:" + idPedido);
        }

        PedidoAluguelModel pedido = pedidoAluguel.get();

        if(pedido.getStatusPedido() != StatusPedido.Finalizado) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status inválido para adicionar avaliação");
        }

        pedido.setNota(avaliarPedidoRequest.nota());
        if(avaliarPedidoRequest.comentariosAvaliacao() != null && !avaliarPedidoRequest.comentariosAvaliacao().trim().isEmpty()){
            pedido.setComentariosAvaliacao(avaliarPedidoRequest.comentariosAvaliacao());
        }

        return ResponseEntity.status(HttpStatus.OK).body(pedidoAluguelRepository.save(pedido));
    }

    @PutMapping("/atualizarStatus/{id}/{status}")
    public ResponseEntity<?> atualizarStatus(@PathVariable int id, @PathVariable StatusPedido status){
        Optional<PedidoAluguelModel> pedidoAluguel = pedidoAluguelRepository.findById(id);
        
        if(pedidoAluguel.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não encontrado pedido para o id:" + id);
        }

        PedidoAluguelModel pedido = pedidoAluguel.get();
        VeiculoModel veiculo = pedido.getVeiculo();

        if(status == StatusPedido.Aceito) {
            veiculo.setAlugado(true);
            veiculoRepository.save(veiculo);
        }
        if(status == StatusPedido.Cancelado || status == StatusPedido.Finalizado || status == StatusPedido.Recusado){
            veiculo.setAlugado(false);
            veiculoRepository.save(veiculo);
        }

        pedido.setStatusPedido(status);

        return ResponseEntity.status(HttpStatus.OK).body(pedidoAluguelRepository.save(pedido));
    }

}
