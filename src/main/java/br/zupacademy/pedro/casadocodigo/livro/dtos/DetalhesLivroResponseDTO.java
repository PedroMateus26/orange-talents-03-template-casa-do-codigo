package br.zupacademy.pedro.casadocodigo.livro.dtos;

import br.zupacademy.pedro.casadocodigo.autor.Autor;
import br.zupacademy.pedro.casadocodigo.autor.DetalheAutorResponse;
import br.zupacademy.pedro.casadocodigo.livro.Livro;
import br.zupacademy.pedro.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.*;
import java.time.Instant;

public class DetalhesLivroResponseDTO {
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroPaginas;
    private Long isbn;
    private Instant dataPublicacao;

    private DetalheAutorResponse autor;

    public DetalhesLivroResponseDTO() {
    }

    public DetalhesLivroResponseDTO(Livro entity) {
        this.id=entity.getId();
        this.titulo = entity.getTitulo();
        this.resumo = entity.getResumo();
        this.sumario = entity.getSumario();
        this.preco = entity.getPreco();
        this.numeroPaginas = entity.getNumeroPaginas();
        this.isbn = entity.getIsbn();
        this.autor = new DetalheAutorResponse(entity.getAutor());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public Long getIsbn() {
        return isbn;
    }

    public Instant getDataPublicacao() {
        return dataPublicacao;
    }

    public DetalheAutorResponse getAutor() {
        return autor;
    }
}