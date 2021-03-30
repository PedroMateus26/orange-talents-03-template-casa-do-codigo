package br.zupacademy.pedro.casadocodigo.clientes.dtos;

import br.zupacademy.pedro.casadocodigo.clientes.Cliente;
import br.zupacademy.pedro.casadocodigo.clientes.ClienteRepository;
import br.zupacademy.pedro.casadocodigo.estado.Estado;
import br.zupacademy.pedro.casadocodigo.estado.Estadorepository;
import br.zupacademy.pedro.casadocodigo.validator.UniqueValue;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteRequestDTO {

    private Long id;
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
    //@CPF @CNPJ
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
    private Estado estado;

    public ClienteRequestDTO() {
    }

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
        this.estado= entity.getEstado();
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

    public Estado getEstado() {
        return estado;
    }


    public Cliente convertToCliente(EntityManager entityManager, Estadorepository estadorepository) {
        //Estado estado = entityManager.find(Estado.class,getEstado().getId());
        Estado estado = estadorepository.getOne(getEstado().getId());
        Assert.state(estado!=null, "Você está tentando cadastrar um estádo no qual o país não existe");

        return new Cliente(
                getNome(),
                getSobreNome(),
                getEmail(),
                getDocumento(),
                getEndereco(),
                getComplemento(),
                getCidade(),
                getTelefone(),
                getCep(),
                estado
        );
    }
}
