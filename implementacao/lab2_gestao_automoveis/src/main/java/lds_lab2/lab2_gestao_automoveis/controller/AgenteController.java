package lds_lab2.lab2_gestao_automoveis.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import lds_lab2.lab2_gestao_automoveis.repository.AgenteRepository;
import lds_lab2.lab2_gestao_automoveis.repository.ClienteRepository;
import lds_lab2.lab2_gestao_automoveis.request.AgenteRequest;

@RestController
@RequestMapping("agente")
public class AgenteController {
    @Autowired
    private AgenteRepository agenteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AgenteRequest agenteRequest){
        AgenteModel agenteModel = new AgenteModel();
        BeanUtils.copyProperties(agenteRequest, agenteModel);

        Optional<AgenteModel> agente = agenteRepository.findByLogin(agenteRequest.login());
        Optional<ClienteModel> cliente = clienteRepository.findByLogin(agenteRequest.login());

        if(agente.isPresent() || cliente.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível realizar o cadastro, o login informado já existe.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(agenteRepository.save(agenteModel));
    }

    @PutMapping("/update")
    public AgenteModel updateClient(@RequestBody AgenteModel updatedAgent){
        return agenteRepository.save(updatedAgent);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        agenteRepository.deleteById(id);
    }

    @GetMapping("/clientes")
    public Iterable<AgenteModel> returnAll(){
       return agenteRepository.findAll();
    }
    
}
