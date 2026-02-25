package com.example.demo.mapper;

import com.example.demo.dto.Categoria.CategoriaRequestDTO;
import com.example.demo.dto.Categoria.CategoriaResponseDTO;
import com.example.demo.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria requestToEntity(CategoriaRequestDTO categoriaRequestDTO){
        return new Categoria(
                categoriaRequestDTO.nome()
        );
    }

    public CategoriaResponseDTO responseToEntity(Categoria categoria){
        return new CategoriaResponseDTO(
                categoria.getNome()
        );
    }
}
