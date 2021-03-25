package br.zupacademy.pedro.casadocodigo.autor;

public class DetalheAutorResponse {

    private String nome;
    private String descricao;

    public DetalheAutorResponse(Autor autor){
        this.nome = getNome();
        this.descricao = getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
