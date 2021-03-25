package br.zupacademy.pedro.casadocodigo.pais;

import br.zupacademy.pedro.casadocodigo.validator.UniqueValue;

public class PaisRequestDTO {
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

    public Pais convertToRquestDTO(PaisRequestDTO paisRequestDTO) {
        return new Pais(paisRequestDTO.getNome());
    }
}