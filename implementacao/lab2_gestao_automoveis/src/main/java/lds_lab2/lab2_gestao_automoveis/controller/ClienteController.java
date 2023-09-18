package lds_lab2.lab2_gestao_automoveis.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lds_lab2.lab2_gestao_automoveis.dto.ClienteDto;
import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;
import lds_lab2.lab2_gestao_automoveis.model.RendimentoModel;
import lds_lab2.lab2_gestao_automoveis.repository.ClienteRepository;
import lds_lab2.lab2_gestao_automoveis.repository.RendimentoRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clientRepository;

    @Autowired
    private RendimentoRepository rendimentoRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteModel> cadastrar(@RequestBody @Valid ClienteDto clienteDto){
        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);

        if(clienteDto.rendimentosAuferidos() != null && clienteDto.rendimentosAuferidos().size() > 3){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteModel);
        }

        ClienteModel clienteCadastrado = clientRepository.save(clienteModel);

        List<RendimentoModel> rendimentosAuferidos = clienteDto.rendimentosAuferidos();
        if(clienteDto.rendimentosAuferidos() != null && clienteDto.rendimentosAuferidos().size() > 0){
            for (RendimentoModel rendimento : rendimentosAuferidos) {
                rendimento.setIdCliente(clienteCadastrado.getCpf());
                rendimentoRepository.save(rendimento);
            }
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastrado);
    }

    @PostMapping("/update")
    public ClienteModel updateClient(@RequestBody ClienteModel updatedClient){
        return clientRepository.save(updatedClient);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable String cpf) {
        clientRepository.deleteById(cpf);
    }

    @GetMapping("/clientes")
    public Iterable<ClienteModel> returnAll(){
       return clientRepository.findAll();
    }
}
