package lds_lab2.lab2_gestao_automoveis.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;
import lds_lab2.lab2_gestao_automoveis.repository.AgenteRepository;
import lds_lab2.lab2_gestao_automoveis.repository.ClienteRepository;

import lds_lab2.lab2_gestao_automoveis.model.AgenteModel;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private AgenteRepository agenteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/login/{login}/{senha}")
    public ResponseEntity<String> login(@PathVariable String login, @PathVariable String senha) {
        Optional<AgenteModel> agente = agenteRepository.findByLoginAndSenha(login, senha);

        if (agente.isPresent()) {
            return ResponseEntity.ok("Login efetuado");
        } else {
            Optional<ClienteModel> cliente = clienteRepository.findByLoginAndSenha(login, senha);
    
            if (cliente.isPresent()) {
                return ResponseEntity.ok("Login efetuado");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado! Login ou senha inválidos");
            }
        }
    }

}
