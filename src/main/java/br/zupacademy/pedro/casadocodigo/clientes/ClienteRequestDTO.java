package br.zupacademy.pedro.casadocodigo.clientes;

import br.zupacademy.pedro.casadocodigo.estado.Estado;
import br.zupacademy.pedro.casadocodigo.pais.EstadoAndPaisRequestDTO;
import br.zupacademy.pedro.casadocodigo.pais.Pais;
import br.zupacademy.pedro.casadocodigo.validator.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@GroupSequenceProvider(ValidatorSequence.class)
public class ClienteRequestDTO {
    @NotEmpty(message = "O nome é obrigatório")
    private String nome;
    @NotEmpty(message = "O sobrenome é obrigatório")
    private String sobreNome;
    @NotEmpty (message = "O email é obrigatório")
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    @Email(message = "Email inválido")
    private String email;
    @NotEmpty (message = "O documento é obrigatório")
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")

    @CPF(groups= PessoaFisica.class)
    @CNPJ(groups= PessoaJuridica.class)
    private String documento;
    @NotEmpty (message = "O nome é obrigatório")
    private String endereco;
    @NotEmpty (message = "O complemento é obrigatório")
    private String complemento;
    @NotEmpty (message = "A cidade é obrigatório")
    private String cidade;
    @NotEmpty (message = "O telefon é obrigatório")
    private String telefone;
    @NotEmpty (message = "O cep é obrigatório")
    private String cep;

    @NotNull
    @Valid
    @ExistStateIntoCountry
    private EstadoAndPaisRequestDTO estadoAndPaisRequestDTO;

    public ClienteRequestDTO() {
    }


    @Deprecated
    public ClienteRequestDTO(Cliente entity) {

        this.nome = entity.getNome();
        this.sobreNome = entity.getSobreNome();
        this.email = entity.getEmail();
        this.documento = entity.getDocumento();
        this.endereco = entity.getEndereco();
        this.complemento = entity.getComplemento();
        this.cidade = entity.getCidade();
        this.telefone = entity.getTelefone();
        this.cep = entity.getCep();
        this.estadoAndPaisRequestDTO.setEstadoId(entity.getEstado().getId());
        this.estadoAndPaisRequestDTO.setPaisId(entity.getPais().getId());

    }

    public ClienteRequestDTO(@NotEmpty(message = "O nome é obrigatório") String nome, @NotEmpty(message = "O sobrenome é obrigatório") String sobreNome, @NotEmpty(message = "O email é obrigatório") @Email(message = "Email inválido") String email, @NotEmpty(message = "O documento é obrigatório") String documento, @NotEmpty(message = "O nome é obrigatório") String endereco, @NotEmpty(message = "O complemento é obrigatório") String complemento, @NotEmpty(message = "A cidade é obrigatório") String cidade, @NotEmpty(message = "O telefon é obrigatório") String telefone, @NotEmpty(message = "O cep é obrigatório") String cep, @NotNull @Valid EstadoAndPaisRequestDTO estadoAndPaisRequestDTO) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.estadoAndPaisRequestDTO = estadoAndPaisRequestDTO;
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

    public EstadoAndPaisRequestDTO getEstadoAndPaisRequestDTO() {
        return estadoAndPaisRequestDTO;
    }

    public Cliente convertToCliente() {
        if(this.estadoAndPaisRequestDTO.getEstadoId()==null){
            return new Cliente(
                    this.nome,
                    this.sobreNome,
                    this.email,
                    this.documento,
                    this.endereco,
                    this.complemento,
                    this.cidade,
                    this.telefone,
                    this.cep,
                    new Pais(this.estadoAndPaisRequestDTO.getPaisId())
            );
        }
        return new Cliente(
                this.nome,
                this.sobreNome,
                this.email,
                this.documento,
                this.endereco,
                this.complemento,
                this.cidade,
                this.telefone,
                this.cep,
                new Estado(this.estadoAndPaisRequestDTO.getEstadoId()),
                new Pais(this.estadoAndPaisRequestDTO.getPaisId())
        );
    }
}
