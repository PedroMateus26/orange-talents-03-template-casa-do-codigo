package br.zupacademy.pedro.casadocodigo.validator;

import br.zupacademy.pedro.casadocodigo.clientes.ClienteRequestDTO;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ValidatorSequence implements DefaultGroupSequenceProvider<ClienteRequestDTO> {


    @Override
    public List<Class<?>> getValidationGroups(ClienteRequestDTO clienteRequestDTO) {
        List<Class<?>> groups=new ArrayList<>();
        groups.add(ClienteRequestDTO.class);
        if(clienteRequestDTO!=null){
            Integer pessoaFisica=14;
            Integer pessoaJuridica=18;
            if(pessoaFisica.equals(clienteRequestDTO.getDocumento().length())){
                groups.add(PessoaFisica.class);
            }else if(pessoaJuridica.equals(clienteRequestDTO.getDocumento().length())){
                groups.add(PessoaJuridica.class);

            }
        }

        return groups;
    }
}
