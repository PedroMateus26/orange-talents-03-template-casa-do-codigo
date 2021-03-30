package br.zupacademy.pedro.casadocodigo.pais;

import br.zupacademy.pedro.casadocodigo.estado.Estado;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pais")
public class Pais {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(fetch=FetchType.EAGER,mappedBy = "pais")
    List<Estado> listEstado =new ArrayList<>();

    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public Pais(Long paisId) {
        this.id=paisId;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
