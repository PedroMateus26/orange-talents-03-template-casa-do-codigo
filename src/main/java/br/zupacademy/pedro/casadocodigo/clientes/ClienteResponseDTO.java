package br.zupacademy.pedro.casadocodigo.clientes;

import br.zupacademy.pedro.casadocodigo.pais.EstadoAndPaisRequestDTO;

public class ClienteResponseDTO {
    private String nome;
    private String sobreNome;
    private String email;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private String telefone;
    private String cep;

    private EstadoAndPaisRequestDTO estadoAndPais;


    public ClienteResponseDTO(Cliente entity) {
        this.nome = entity.getNome();
        this.sobreNome = entity.getSobreNome();
        this.email = entity.getEmail();
        this.documento = entity.getDocumento();
        this.endereco = entity.getEndereco();
        this.complemento = entity.getComplemento();
        this.cidade = entity.getCidade();
        this.telefone = entity.getTelefone();
        this.cep = entity.getCep();

        if(entity.getEstado()!=null){
            this.estadoAndPais=new EstadoAndPaisRequestDTO(entity.getEstado().getId(),entity.getPais().getId());
        }else {
            this.estadoAndPais=new EstadoAndPaisRequestDTO(entity.getPais().getId());
        }

    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
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

    public EstadoAndPaisRequestDTO getEstadoAndPais() {
        return estadoAndPais;
    }

}
