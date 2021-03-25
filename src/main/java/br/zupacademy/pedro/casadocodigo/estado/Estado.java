package br.zupacademy.pedro.casadocodigo.estado;

import br.zupacademy.pedro.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
@Table(name = "tb_estado")
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }


}
