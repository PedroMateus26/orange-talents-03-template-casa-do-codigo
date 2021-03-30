package br.zupacademy.pedro.casadocodigo.pais;

import br.zupacademy.pedro.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotNull;

public class PaisRequestDTO {

    @NotNull
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisRequestDTO() {
    }

    public PaisRequestDTO(Pais entity) {
        this.nome = entity.getNome();
    }

    public String getNome() {
        return nome;
    }

    public Pais convertToRquestDTO() {
        return new Pais(getNome());
    }
}
