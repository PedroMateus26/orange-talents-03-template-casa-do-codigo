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

    private Autor autor;
    private Categoria categoria;

    public LivroRequestDTO() {
    }

    public LivroRequestDTO(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, Long isbn, Instant dataPublicacao, Autor autor, Categoria categoria) {
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

    public LivroRequestDTO(Livro entity){
        this.titulo = entity.getTitulo();
        this.resumo = entity.getResumo();
        this.sumario = entity.getSumario();
        this.preco = entity.getPreco();
        this.numeroPaginas = entity.getNumeroPaginas();
        this.isbn = entity.getIsbn();
        this.dataPublicacao = entity.getDataPublicacao();
        this.autor = entity.getAutor();
        this.categoria = entity.getCategoria();

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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Livro transformToEntityLivro(LivroRequestDTO livroRequestDTO, EntityManager entityManager) {
        Autor autor = entityManager.find(Autor.class, livroRequestDTO.getAutor().getId());
        Assert.state(autor!=null,"Você está querendo cadastrar um autor que não" +
                " existe no banco");
        Categoria categoria = entityManager.find(Categoria.class,livroRequestDTO.getCategoria().getId());
        Assert.state(categoria!=null,"Você está querendo cadastrar uma categoria que não existe no banco");
        Livro livro = new Livro(
                livroRequestDTO.getTitulo(),
                livroRequestDTO.getResumo(),
                livroRequestDTO.getSumario(),
                livroRequestDTO.getPreco(),
                livroRequestDTO.getNumeroPaginas(),
                livroRequestDTO.getIsbn(),
                livroRequestDTO.getDataPublicacao(),
                autor,
                categoria
        );

        return livro;
    }

}
