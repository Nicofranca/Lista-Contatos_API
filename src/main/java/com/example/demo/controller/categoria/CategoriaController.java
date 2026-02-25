package com.example.demo.controller.categoria;

import com.example.demo.Service.CategoriaService;
import com.example.demo.dto.Categoria.CategoriaRequestDTO;
import com.example.demo.dto.Categoria.CategoriaResponseDTO;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {


    private CategoriaRepository categoriaRepository;
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public CategoriaResponseDTO save(@RequestBody CategoriaRequestDTO categoriaRequestDTO){
        return categoriaService.save(categoriaRequestDTO);
    }

    @GetMapping
    public List<CategoriaResponseDTO> findAll(){
        return categoriaService.findAll();
    }
}
