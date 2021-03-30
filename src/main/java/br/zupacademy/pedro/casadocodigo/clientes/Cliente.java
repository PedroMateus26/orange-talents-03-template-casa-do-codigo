package br.zupacademy.pedro.casadocodigo.clientes;

import br.zupacademy.pedro.casadocodigo.estado.Estado;
import br.zupacademy.pedro.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobreNome;
    private String email;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private String telefone;
    private String cep;

    @ManyToOne(fetch = FetchType.EAGER)
    private Estado estado;

    @ManyToOne(fetch = FetchType.EAGER)
    private Pais pais;

    public Cliente() {
    }

    public Cliente(String nome, String sobreNome, String email, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Estado estado, Pais pais) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.estado = estado;
        this.pais = pais;
    }

    public Cliente(String nome, String sobreNome, String email, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Pais pais) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public Pais getPais() {
        return pais;
    }
}
