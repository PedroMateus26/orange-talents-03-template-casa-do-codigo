package br.zupacademy.pedro.casadocodigo.controllers;

import br.zupacademy.pedro.casadocodigo.dtos.AutorDTO;
import br.zupacademy.pedro.casadocodigo.entities.Autor;
import br.zupacademy.pedro.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    private AutorRepository autorRepository;

    @Autowired
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository=autorRepository;
    }

    @PostMapping
    public ResponseEntity<AutorDTO> inserirAutor(@Valid @RequestBody AutorDTO autorDTO){
        Autor autor =  convertAutorDTOToAutorEntity(autorDTO);
        autor=autorRepository.save(autor);
        autorDTO=new AutorDTO(autor);
        //URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autorDTO.getId()).toUri();
        //return ResponseEntity.created(uri).body(autorDTO);
        return ResponseEntity.ok().body(autorDTO);
    }

    private Autor convertAutorDTOToAutorEntity(AutorDTO autorDTO){
        Autor autor = new Autor(
                autorDTO.getNome(),
                autorDTO.getEmail(),
                autorDTO.getDescricao()
        );
        return autor;
    }
}
