package lds_lab2.lab2_gestao_automoveis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;
import lds_lab2.lab2_gestao_automoveis.repository.ClienteRepository;

@RestController
public class ClientController {
    @Autowired
    private ClienteRepository clienRepository;
    
    @GetMapping("/")
    public String helloWorldController(){
        return "Hello World";
    }

    @PostMapping("/exemplo")
    public ClienteModel exemploModelController(@RequestBody ClienteModel exemplo){
        return clienRepository.save(exemplo);
    }

    @PostMapping("/update")
    public ClienteModel updateClient(@RequestBody ClienteModel updatedClient){
        return clienRepository.save(updatedClient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ClienteModel id) {
        clienRepository.delete(id);
    }

    @GetMapping("/user")
    public void returnAll(){
        clienRepository.findAll();
    }
    
}
