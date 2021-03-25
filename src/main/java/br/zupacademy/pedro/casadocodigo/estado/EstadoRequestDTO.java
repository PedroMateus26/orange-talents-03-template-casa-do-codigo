package br.zupacademy.pedro.casadocodigo.estado;

import br.zupacademy.pedro.casadocodigo.pais.Pais;
import br.zupacademy.pedro.casadocodigo.pais.PaisRepository;
import br.zupacademy.pedro.casadocodigo.validator.UniqueValue;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class EstadoRequestDTO {

    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    private Pais pais;

    public EstadoRequestDTO() {
    }

    public EstadoRequestDTO(Estado entity){
        this.nome = entity.getNome();
        this.pais = entity.getPais();
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado convertToEstado(EstadoRequestDTO estadoRequestDTO, EntityManager entityManager) {
        //Optional<Pais> paisOptional = paisRepository.findById(estadoRequestDTO.getPais().getId());
        Pais pais = entityManager.find(Pais.class,estadoRequestDTO.getPais().getId());
        Assert.state(pais!=null, "Você está tentando cadastrar um estádo no qual o país não existe");
        return new Estado(estadoRequestDTO.getNome(),pais);
    }
}
