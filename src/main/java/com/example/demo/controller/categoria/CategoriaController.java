package com.example.demo.controller.categoria;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @GetMapping
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }
}
