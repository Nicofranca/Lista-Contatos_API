package com.example.demo.dto.Categoria;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

public record CategoriaRequestDTO(
        @NotBlank
        String nome
) {
}
