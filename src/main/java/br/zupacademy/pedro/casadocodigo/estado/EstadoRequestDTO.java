package br.zupacademy.pedro.casadocodigo.estado;

import br.zupacademy.pedro.casadocodigo.pais.Pais;
import br.zupacademy.pedro.casadocodigo.validator.ExistIdValue;
import br.zupacademy.pedro.casadocodigo.validator.UniqueValue;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

@Service
public class EstadoRequestDTO {

    @NotNull
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    @ExistIdValue(domainClass = Pais.class)
    private Long paisId;

    public EstadoRequestDTO() {
    }

    public EstadoRequestDTO(Estado entity){
        this.nome = entity.getNome();
        this.paisId = entity.getPais().getId();
    }

    public String getNome() {
        return nome;
    }

    public EstadoRequestDTO(Long paisId) {
        this.paisId = paisId;
    }

    public Estado convertToEstado() {
        return new Estado(
                this.nome,
                new Pais(this.paisId)
        );
    }
}
