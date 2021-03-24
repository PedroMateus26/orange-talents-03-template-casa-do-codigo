package br.zupacademy.pedro.casadocodigo.categoria;

import br.zupacademy.pedro.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotEmpty;

public class CategoriaRequestDTO {

    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    @UniqueValue(domainClass = Categoria.class,fieldName = "nomeCategoria")
    private String nomeCategoria;

    public CategoriaRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public CategoriaRequestDTO(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public CategoriaRequestDTO(Categoria entity) {
        this.nomeCategoria = entity.getNomeCategoria();
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }


}
