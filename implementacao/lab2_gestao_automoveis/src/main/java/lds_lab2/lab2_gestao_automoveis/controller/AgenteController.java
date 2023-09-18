package lds_lab2.lab2_gestao_automoveis.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lds_lab2.lab2_gestao_automoveis.dto.AgenteDto;
import lds_lab2.lab2_gestao_automoveis.model.AgenteModel;
import lds_lab2.lab2_gestao_automoveis.repository.AgenteRepository;

@RestController
@RequestMapping("agente")
public class AgenteController {
    @Autowired
    private AgenteRepository agenteRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<AgenteModel> cadastrar(@RequestBody @Valid AgenteDto agenteDto){
        AgenteModel agenteModel = new AgenteModel();
        BeanUtils.copyProperties(agenteDto, agenteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(agenteRepository.save(agenteModel));
    }

    @PostMapping("/update")
    public AgenteModel updateClient(@RequestBody AgenteModel updatedAgent){
        return agenteRepository.save(updatedAgent);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable AgenteModel cpf) {
        agenteRepository.delete(cpf);
    }

    @GetMapping("/clientes")
    public Iterable<AgenteModel> returnAll(){
       return agenteRepository.findAll();
    }
    
}
