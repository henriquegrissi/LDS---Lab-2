package lds_lab2.lab2_gestao_automoveis.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lds_lab2.lab2_gestao_automoveis.model.VeiculoModel;
import lds_lab2.lab2_gestao_automoveis.repository.VeiculoRepository;
import lds_lab2.lab2_gestao_automoveis.request.VeiculoRequest;

@RestController
@RequestMapping("veiculo")
@CrossOrigin(origins = "http://localhost:5173")
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<VeiculoModel> cadastrar(@RequestBody @Valid VeiculoRequest veiculoRequest) { 
        VeiculoModel veiculoModel = new VeiculoModel();
        BeanUtils.copyProperties(veiculoRequest, veiculoModel);

        VeiculoModel veiculoCadastrado = veiculoRepository.save(veiculoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoCadastrado);

    }

    @GetMapping("/veiculos")
    public Iterable<VeiculoModel> returnAll() { 
        return veiculoRepository.findAll();
    }

}
