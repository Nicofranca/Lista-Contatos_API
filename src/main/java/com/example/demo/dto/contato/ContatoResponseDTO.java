package com.example.demo.dto.contato;

import org.springframework.stereotype.Component;

public record ContatoResponseDTO(
        Long id,
        String nome,
        String telefone,
        String nomeCategoria
) {

}
