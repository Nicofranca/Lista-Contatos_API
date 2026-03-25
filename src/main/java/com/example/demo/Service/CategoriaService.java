package com.example.demo.Service;

import com.example.demo.dto.Categoria.CategoriaRequestDTO;
import com.example.demo.dto.Categoria.CategoriaResponseDTO;
import com.example.demo.mapper.CategoriaMapper;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    public final CategoriaRepository categoriaRepository;
    public final CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper){
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public CategoriaResponseDTO save(CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = categoriaMapper.requestToEntity(categoriaRequestDTO);

        categoriaRepository.save(categoria);



        return categoriaMapper.responseToEntity(categoria);
    }

    public List<CategoriaResponseDTO> findAll(){
        return categoriaRepository.findAll().stream()
                .map(categoriaMapper::responseToEntity)
                .toList();
    }
}
