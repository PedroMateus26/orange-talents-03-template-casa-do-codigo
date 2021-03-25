package br.zupacademy.pedro.casadocodigo.livro.dtos;

import br.zupacademy.pedro.casadocodigo.livro.Livro;

public class ExibirListaLivrosResponseDTO {

    private Long id;
    private String titulo;

    public ExibirListaLivrosResponseDTO() {
    }

    public ExibirListaLivrosResponseDTO(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public ExibirListaLivrosResponseDTO(Livro entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
