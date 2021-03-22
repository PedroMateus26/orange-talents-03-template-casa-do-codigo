package br.zupacademy.pedro.casadocodigo.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    private AutorRepository autorRepository;

    @Autowired
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository=autorRepository;
    }

    @GetMapping(value="/{email}")
    public ResponseEntity<AutorRequestDTO> findByEmail(@PathVariable String email){
        Autor autor = autorRepository.findByEmail(email);
        return ResponseEntity.ok().body(new AutorRequestDTO(autor));
    }

    @PostMapping
    public ResponseEntity<AutorRequestDTO> inserirAutor(@Valid @RequestBody AutorRequestDTO autorDTO){
        Autor autor =  autorDTO.convertAutorDTOToAutorEntity(autorDTO);
        autor=autorRepository.save(autor);
        autorDTO=new AutorRequestDTO(autor);
        //URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autorDTO.getId()).toUri();
        //return ResponseEntity.created(uri).body(autorDTO);
        return ResponseEntity.ok().body(autorDTO);
    }




}
