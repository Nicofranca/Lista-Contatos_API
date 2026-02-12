package com.example.demo.mapper;

import com.example.demo.dto.ContatoRequestDTO;
import com.example.demo.dto.ContatoResponseDTO;
import com.example.demo.model.Contato;

public class ContatoMapper {
    public ContatoMapper() {
    }

    private Contato requestToEntity(ContatoRequestDTO requestDTO){
        Contato contato = new Contato();
        contato.setNome(requestDTO.getNome());
        contato.setTelefone(requestDTO.getTelefone());
        return contato;
    }

    private ContatoResponseDTO entityResponse(Contato contato){
        return new ContatoResponseDTO(
                contato.getId(),
                contato.getNome(),
                contato.getTelefone());
    }
}
