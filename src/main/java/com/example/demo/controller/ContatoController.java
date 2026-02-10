package com.example.demo.controller;

import com.example.demo.model.Contato;
import com.example.demo.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoRepository contatoRepository;

    @Autowired
    public ContatoController(ContatoRepository contatoRepository){
        this.contatoRepository = contatoRepository;
    }

    @GetMapping
    public List<Contato> findAll(){
        return contatoRepository.findAll();
    }

    @PostMapping
    public Contato saveContato(@RequestBody Contato contato){
        Contato newContato = contatoRepository.save(contato);

        return newContato;
    }

    @PutMapping("/{id}")
    public Contato update(@PathVariable Long id, @RequestBody Contato contato){
        Contato newContato = contatoRepository.findById(id).get();

        newContato.setNome(contato.getNome());
        newContato.setTelefone(contato.getTelefone());

        contatoRepository.save(newContato);

        return newContato;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        Contato contatoDelete = contatoRepository.findById(id).get();

        contatoRepository.delete(contatoDelete);
    }

}
