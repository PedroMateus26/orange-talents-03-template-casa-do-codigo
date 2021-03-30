package br.zupacademy.pedro.casadocodigo.livro.dtos;

import br.zupacademy.pedro.casadocodigo.autor.Autor;
import br.zupacademy.pedro.casadocodigo.categoria.Categoria;
import br.zupacademy.pedro.casadocodigo.livro.Livro;
import br.zupacademy.pedro.casadocodigo.validator.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.time.Instant;


public class LivroRequestDTO {



    private Long id;
    @NotEmpty
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotEmpty
    @Size(max = 500)
    private String resumo;
    @NotEmpty
    private String sumario;
    @NotNull
    @Min(20)
    private Double preco;
    @Min(100)
    private Integer numeroPaginas;
    @UniqueValue(domainClass = Livro.class,fieldName = "isbn")
    private Long isbn;
    @Future
    private Instant dataPublicacao;

    private Long autorId;
    private Long categoriaid;

    public LivroRequestDTO() {
    }



    public LivroRequestDTO(Livro entity){
        this.titulo = entity.getTitulo();
        this.resumo = entity.getResumo();
        this.sumario = entity.getSumario();
        this.preco = entity.getPreco();
        this.numeroPaginas = entity.getNumeroPaginas();
        this.isbn = entity.getIsbn();
        this.dataPublicacao = entity.getDataPublicacao();
        this.autorId = entity.getAutor().getId();
        this.categoriaid = entity.getCategoria().getId();

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Instant getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Instant dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public void setCategoriaid(Long categoriaid) {
        this.categoriaid = categoriaid;
    }

    public Livro transformToEntityLivro() {
        Livro livro = new Livro(
                this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numeroPaginas,
                this.isbn,
                this.dataPublicacao,
                new Autor(autorId),
                new Categoria(categoriaid)
        );

        return livro;
    }

}
