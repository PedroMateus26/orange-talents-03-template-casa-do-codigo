package br.zupacademy.pedro.casadocodigo.autor;

import br.zupacademy.pedro.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AutorRequestDTO {

    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    private String nome;

    @Email
    @NotEmpty(message = "Campo obrigatório")
    @UniqueValue(domainClass = Autor.class,fieldName = "email")
    private String email;

    @Size(max = 400, message = "O nome deve ter entre no máximo 400 caracteres")
    @NotEmpty(message = "Campo obrigatório")
    private String descricao;

    public AutorRequestDTO() {
    }

    public AutorRequestDTO(Long id, String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public AutorRequestDTO(Autor entity) {
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

    public Autor convertAutorDTOToAutorEntity(){
        Autor autor = new Autor(
                this.nome,
                this.email,
                this.descricao
        );
        return autor;
    }
}
