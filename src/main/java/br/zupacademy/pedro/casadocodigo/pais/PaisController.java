package br.zupacademy.pedro.casadocodigo.pais;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<PaisRequestDTO> insertPais(@RequestBody @Valid PaisRequestDTO paisRequestDTO){
        Pais pais = paisRequestDTO.convertToRquestDTO(paisRequestDTO);
        pais = paisRepository.save(pais);
        return ResponseEntity.ok().body(new PaisRequestDTO(pais));
    }
}
