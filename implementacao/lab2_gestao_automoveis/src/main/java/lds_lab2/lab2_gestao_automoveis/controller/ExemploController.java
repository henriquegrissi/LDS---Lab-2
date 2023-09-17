package lds_lab2.lab2_gestao_automoveis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lds_lab2.lab2_gestao_automoveis.model.ExemploModel;
import lds_lab2.lab2_gestao_automoveis.repository.ExemploRepository;

@RestController
public class ExemploController {
    @Autowired
    private ExemploRepository exemploRepository;
    
    @GetMapping("/")
    public String helloWorldController(){
        return "Hello World";
    }

    @PostMapping("/exemplo")
    public ExemploModel exemploModelController(@RequestBody ExemploModel exemplo){
        return exemploRepository.save(exemplo);
    }
}
