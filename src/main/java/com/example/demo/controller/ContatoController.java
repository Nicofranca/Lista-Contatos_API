package com.example.demo.controller;

import com.example.demo.Service.ContatoService;
import com.example.demo.model.Contato;
import com.example.demo.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoRepository contatoRepository;
    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoRepository contatoRepository, ContatoService contatoService){
        this.contatoRepository = contatoRepository;
        this.contatoService = contatoService;
    }

    @GetMapping
    public List<Contato> findAll(){
        return contatoService.findAll();
    }

    @GetMapping("/{id}")
    public Contato findById(@PathVariable Long id){
        return contatoService.findById(id);
    }

    @PostMapping
    public Contato saveContato(@RequestBody Contato contato){
        return contatoService.save(contato);
    }

    @PutMapping("/{id}")
    public Contato update(@PathVariable Long id, @RequestBody Contato contato){
        return contatoService.update(id, contato);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        contatoService.delete(id);
    }

}
