package com.example.demo.mapper;

import com.example.demo.dto.ContatoRequestDTO;
import com.example.demo.dto.ContatoResponseDTO;
import com.example.demo.model.Categoria;
import com.example.demo.model.Contato;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {
    public ContatoMapper() {
    }

    public Contato requestToEntity(ContatoRequestDTO requestDTO, Categoria categoria){
        Contato contato = new Contato();
        contato.setNome(requestDTO.getNome());
        contato.setTelefone(requestDTO.getTelefone());
        contato.setCategoria(categoria);

        return contato;
    }

    public ContatoResponseDTO entityResponse(Contato contato){

        String nomeCategoria = "Sem Categoria";

        if (contato.getCategoria() != null){
            nomeCategoria =  contato.getCategoria().getNome();
        }

        return new ContatoResponseDTO(
                contato.getId(),
                contato.getNome(),
                contato.getTelefone(),
                nomeCategoria
                );
    }
}
