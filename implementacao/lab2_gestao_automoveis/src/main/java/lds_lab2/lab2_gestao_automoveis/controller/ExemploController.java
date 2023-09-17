package lds_lab2.lab2_gestao_automoveis.controller;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lds_lab2.lab2_gestao_automoveis.model.Client;
import lds_lab2.lab2_gestao_automoveis.repository.ExemploRepository;

@RestController
public class ExemploController {
    @Autowired
    private ExemploRepository clienRepository;
    
    @GetMapping("/")
    public String helloWorldController(){
        return "Hello World";
    }

    @PostMapping("/exemplo")
    public Client exemploModelController(@RequestBody Client exemplo){
        return clienRepository.save(exemplo);
    }

    @PostMapping("/update")
    public Client updateClient(@RequestBody Client updatedClient){
        return clienRepository.save(updatedClient);
    }

    // TA FALTANDO COISA AQUI
    // @DeleteMapping("/{id}")
    // @ResponseStatus(code = HttpStatus.NO_CONTENT)
    // @CrossOrigin(origins = "http://localhost:3000")
    // public void delete(@PathVariable Long id) {
    //     exemploRepository.delete(id);
    // }
    
}
