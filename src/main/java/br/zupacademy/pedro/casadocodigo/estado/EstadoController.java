package br.zupacademy.pedro.casadocodigo.estado;

import br.zupacademy.pedro.casadocodigo.pais.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    @PersistenceContext
    private EntityManager entityManager;
    private Estadorepository estadorepository;

    public EstadoController(Estadorepository estadorepository) {
        this.estadorepository = estadorepository;
    }

    @PostMapping
    public ResponseEntity<EstadoRequestDTO> insertEstado(@RequestBody @Valid EstadoRequestDTO estadoRequestDTO){
        Estado estado = estadoRequestDTO.convertToEstado(estadoRequestDTO,entityManager);
        estado = estadorepository.save(estado);
        return ResponseEntity.ok().body(new EstadoRequestDTO(estado));
    }
}
