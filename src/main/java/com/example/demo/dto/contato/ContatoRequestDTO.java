package com.example.demo.dto.contato;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

public record ContatoRequestDTO(
        @NotBlank(message = "Nome é obrigatório!")
        String nome,

        @NotBlank(message = "Telefone é obrigatório!")
        @Size(min = 15, max = 15, message = "O telefone deve ter pelo menos 15 digitos - (99)99999-9999")
        String telefone,

        Long categoriaId
) {
}
