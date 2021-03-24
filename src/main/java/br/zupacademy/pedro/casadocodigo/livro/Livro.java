package br.zupacademy.pedro.casadocodigo.livro;

import br.zupacademy.pedro.casadocodigo.autor.Autor;
import br.zupacademy.pedro.casadocodigo.categoria.Categoria;
import br.zupacademy.pedro.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;


@Entity
@Table(name = "tb_livro")
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroPaginas;
    private Long isbn;
    private Instant dataPublicacao;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Categoria categoria;

    public Livro() {
    }

    public Livro( String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, Long isbn, Instant dataPublicacao, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
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

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setDataPublicacao(Instant dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
