package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContatoRequestDTO {

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @NotBlank(message = "Telefone é obrigatório!")
    @Size(min = 15, max = 15, message = "O telefone deve ter pelo menos 15 digitos - (99)99999-9999")
    private String telefone;

    private Long categoriaId;

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public ContatoRequestDTO() {
    }

    public ContatoRequestDTO(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
