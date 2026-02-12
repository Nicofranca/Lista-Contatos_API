package com.example.demo.Service;

import com.example.demo.model.Contato;
import com.example.demo.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository){
        this.contatoRepository = contatoRepository;
    }

    public Contato save(Contato contato){

        return contatoRepository.save(contato);
    }

    public List<Contato> findAll(){
        return contatoRepository.findAll();
    }

    public Contato findById(Long id){
        return contatoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Contato não encontrado com o ID: "+id));
    }

    public Contato update(Long id, Contato contato){
        Contato newContato = contatoRepository.findById(id).get();

        newContato.setNome(contato.getNome());
        newContato.setTelefone(contato.getTelefone());

        contatoRepository.save(newContato);

        return newContato;
    }

    public void delete(Long id){

        Contato contatoDelete = contatoRepository.findById(id).get();

        contatoRepository.delete(contatoDelete);
    }

}
