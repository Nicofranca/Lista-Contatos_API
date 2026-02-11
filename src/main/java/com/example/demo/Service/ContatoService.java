package com.example.demo.Service;

import com.example.demo.model.Contato;
import com.example.demo.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository){
        this.contatoRepository = contatoRepository;
    }

    @PostMapping
    public Contato save(@RequestBody Contato contato){
        return contatoRepository.save(contato);
    }

    @GetMapping
    public List<Contato> findAll(){
        return contatoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Contato findById(@PathVariable Long id){
        Contato newContado = contatoRepository.findById(id).get();

        return newContado;
    }

    @PutMapping("/{id}")
    private void update()

}
