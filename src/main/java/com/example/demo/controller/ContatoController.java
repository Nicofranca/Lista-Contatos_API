package com.example.demo.controller;

import com.example.demo.dto.ContatoRequestDTO;
import com.example.demo.Service.ContatoService;
import com.example.demo.dto.ContatoResponseDTO;
import com.example.demo.repository.ContatoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService){
        this.contatoService = contatoService;
    }

    @GetMapping
    public List<ContatoResponseDTO> findAll(){
        return contatoService.findAll();
    }

    @GetMapping("/{id}")
    public ContatoResponseDTO findById(@PathVariable Long id){
        return contatoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> saveContato(@Valid @RequestBody ContatoRequestDTO contatoRequestDTO){
        ContatoResponseDTO responseDTO = contatoService.save(contatoRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ContatoRequestDTO contatoRequestDTO){
        ContatoResponseDTO responseDTO = contatoService.update(id, contatoRequestDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        contatoService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
