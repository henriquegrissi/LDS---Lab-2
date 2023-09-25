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

import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;
import lds_lab2.lab2_gestao_automoveis.repository.AgenteRepository;
import lds_lab2.lab2_gestao_automoveis.repository.ClienteRepository;
import lds_lab2.lab2_gestao_automoveis.request.LoginRequest;
import lds_lab2.lab2_gestao_automoveis.response.LoginResponse;
import lds_lab2.lab2_gestao_automoveis.model.AgenteModel;

@RestController
@RequestMapping("usuario")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
    @Autowired
    private AgenteRepository agenteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String login = loginRequest.login();
        String senha = loginRequest.senha();
        Optional<AgenteModel> agente = agenteRepository.findByLoginAndSenha(login, senha);

        if (agente.isPresent()) {
            return ResponseEntity.ok(agente);
        } else {
            Optional<ClienteModel> cliente = clienteRepository.findByLoginAndSenha(login, senha);

            if (cliente.isPresent()) {
                LoginResponse response = new LoginResponse(cliente.get(), "Cliente");
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado! Login ou senha inválidos");
            }
        }
    }

}
