package br.zupacademy.pedro.casadocodigo.pais;

import javax.persistence.*;

@Entity
@Table(name = "tb_pais")
public class Pais {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}