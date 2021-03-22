package br.zupacademy.pedro.casadocodigo.categoria;

import br.zupacademy.pedro.casadocodigo.categoria.anotations.CategoriaValid;

import javax.validation.constraints.NotEmpty;

@CategoriaValid
public class CategoriaRequestDTO {

    @NotEmpty(message = "Campo obrigatório")
    private String nomeCategoria;

    public CategoriaRequestDTO() {
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
