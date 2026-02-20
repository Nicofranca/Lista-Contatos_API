package com.example.demo.Service;

import com.example.demo.dto.ContatoRequestDTO;
import com.example.demo.dto.ContatoResponseDTO;
import com.example.demo.mapper.ContatoMapper;
import com.example.demo.model.Categoria;
import com.example.demo.model.Contato;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContatoService {

    private final CategoriaRepository categoriaRepository;
    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository,
                          ContatoMapper contatoMapper,
                          CategoriaRepository categoriaRepository){
        this.contatoRepository = contatoRepository;
        this.contatoMapper = contatoMapper;
        this.categoriaRepository = categoriaRepository;
    }

    public ContatoResponseDTO save(ContatoRequestDTO contatoRequestDTO){
        Categoria categoria = categoriaRepository.findById(contatoRequestDTO.getCategoriaId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Categorira não encontrada com o ID: "+contatoRequestDTO.getCategoriaId()));

        Contato contato = contatoMapper.requestToEntity(contatoRequestDTO, categoria);
        Contato contatoSalvo = contatoRepository.save(contato);

        return contatoMapper.entityResponse(contatoSalvo);
    }

    public List<ContatoResponseDTO> findAll(){
        return contatoRepository.findAll().stream()
                .map(contatoMapper::entityResponse)
                .toList();
    }

    public ContatoResponseDTO findById(Long id){
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Contato não encontrado com o ID: "+id));

        return contatoMapper.entityResponse(contato);
    }

    public ContatoResponseDTO update(Long id, ContatoRequestDTO contatoRequestDTO){
        Contato newContato = contatoRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Contato não encontrado com o ID: "+id
                ));

        newContato.setNome(contatoRequestDTO.getNome());
        newContato.setTelefone(contatoRequestDTO.getTelefone());

        Contato contato = contatoRepository.save(newContato);

        return contatoMapper.entityResponse(contato);
    }

    public void delete(Long id){

        Contato contatoDelete = contatoRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Contato não encontrado com o ID: "+id));

        contatoRepository.delete(contatoDelete);
    }

}
