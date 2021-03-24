package br.zupacademy.pedro.casadocodigo.livro;

public class LivroExibirRequestDTO {

    private Long id;
    private String titulo;

    public LivroExibirRequestDTO() {
    }

    public LivroExibirRequestDTO(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public LivroExibirRequestDTO(Livro entity) {
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
