package com.example.demo.controller;

import com.example.demo.dto.ContatoRequestDTO;
import com.example.demo.Service.ContatoService;
import com.example.demo.repository.ContatoRepository;
import jakarta.validation.Valid;
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
    public List<ContatoRequestDTO> findAll(){
        return contatoService.findAll();
    }

    @GetMapping("/{id}")
    public ContatoRequestDTO findById(@PathVariable Long id){
        return contatoService.findById(id);
    }

    @PostMapping
    public ContatoRequestDTO saveContato(@Valid @RequestBody ContatoRequestDTO contatoRequestDTO){
        return contatoService.save(contatoRequestDTO);
    }

    @PutMapping("/{id}")
    public ContatoRequestDTO update(@PathVariable Long id, @Valid @RequestBody ContatoRequestDTO contatoRequestDTO){
        return contatoService.update(id, contatoRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        contatoService.delete(id);
    }

}
