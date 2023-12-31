package lds_lab2.lab2_gestao_automoveis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lds_lab2.lab2_gestao_automoveis.model.AgenteModel;
import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;
import lds_lab2.lab2_gestao_automoveis.model.RendimentoModel;
import lds_lab2.lab2_gestao_automoveis.repository.AgenteRepository;
import lds_lab2.lab2_gestao_automoveis.repository.ClienteRepository;
import lds_lab2.lab2_gestao_automoveis.repository.RendimentoRepository;
import lds_lab2.lab2_gestao_automoveis.request.ClienteRequest;

@RestController
@RequestMapping("cliente")
@CrossOrigin(origins = "http://localhost:5173")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RendimentoRepository rendimentoRepository;

    @Autowired
    private AgenteRepository agenteRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteRequest clienteRequest){
        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteRequest, clienteModel);

        Optional<AgenteModel> agente = agenteRepository.findByLogin(clienteRequest.login());
        Optional<ClienteModel> cliente = clienteRepository.findByLogin(clienteRequest.login());

        if(agente.isPresent() || cliente.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível realizar o cadastro, o login informado já existe.");
        }

        if(clienteRequest.rendimentosAuferidos() != null && clienteRequest.rendimentosAuferidos().size() > 3){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O máximo de rendimentos permitidos é 3");
        }

        ClienteModel clienteCadastrado = clienteRepository.save(clienteModel);
        
        List<RendimentoModel> rendimentosAuferidos = clienteRequest.rendimentosAuferidos();
        if(clienteRequest.rendimentosAuferidos() != null && clienteRequest.rendimentosAuferidos().size() > 0){
            for (RendimentoModel rendimento : rendimentosAuferidos) {
                rendimento.setCliente(clienteCadastrado);
                rendimentoRepository.save(rendimento);
            }
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastrado);
    }

    @PutMapping("/update")
    public ClienteModel updateClient(@RequestBody ClienteModel updatedClient){
        return clienteRepository.save(updatedClient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        clienteRepository.deleteById(id);
    }

    @GetMapping("/clientes")
    public Iterable<ClienteModel> returnAll(){
       return clienteRepository.findAll();
    }
}
