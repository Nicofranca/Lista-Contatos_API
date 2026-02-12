package com.example.demo.Service;

import com.example.demo.dto.ContatoRequestDTO;
import com.example.demo.model.Contato;
import com.example.demo.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository){
        this.contatoRepository = contatoRepository;
    }

    public ContatoRequestDTO save(ContatoRequestDTO contatoRequestDTO){

        Contato contato = new Contato();

        contato.setNome(contatoRequestDTO.getNome());
        contato.setTelefone(contatoRequestDTO.getTelefone());

        contatoRepository.save(contato);

        return new ContatoRequestDTO(contato.getNome(), contato.getTelefone());
    }

    public List<ContatoRequestDTO> findAll(){

        List<Contato> listContatos = contatoRepository.findAll();

        return listContatos.stream().
                map(entidade -> new ContatoRequestDTO(entidade.getNome(), entidade.getTelefone())).
                toList();
    }

    public ContatoRequestDTO findById(Long id){

        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Contato não encontrado com o ID: "+id));

        return new ContatoRequestDTO(contato.getNome(), contato.getTelefone());
    }

    public ContatoRequestDTO update(Long id, ContatoRequestDTO contatoRequestDTO){
        Contato newContato = contatoRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Contato não encontrado com o ID: "+id
                ));

        newContato.setNome(contatoRequestDTO.getNome());
        newContato.setTelefone(contatoRequestDTO.getTelefone());

        contatoRepository.save(newContato);

        ContatoRequestDTO newContatoRequestDTO = new ContatoRequestDTO();

        newContatoRequestDTO.setNome(newContato.getNome());
        newContatoRequestDTO.setTelefone(newContato.getTelefone());

        return newContatoRequestDTO;
    }

    public void delete(Long id){

        Contato contatoDelete = contatoRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Contato não encontrado com o ID: "+id));

        contatoRepository.delete(contatoDelete);
    }

}
