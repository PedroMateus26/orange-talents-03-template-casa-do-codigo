package br.zupacademy.pedro.casadocodigo.dtos;

import br.zupacademy.pedro.casadocodigo.entities.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @Email
    @NotBlank(message = "Campo obrigatório")
    private String email;

    @Size(max = 400, message = "O nome deve ter entre no máximo 400 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String descricao;

    public AutorDTO() {
    }

    public AutorDTO(Long id, String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public AutorDTO(Autor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.descricao = entity.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
