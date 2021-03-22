package br.zupacademy.pedro.casadocodigo.categoria;

import javax.persistence.*;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nomeCategoria;

    public Categoria() {
    }

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
