package com.example.demo.dto;

public class ContatoResponseDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String nomeCategoria;

    public ContatoResponseDTO(Long id, String nome, String telefone, String nomeCategoria) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.nomeCategoria = nomeCategoria;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
