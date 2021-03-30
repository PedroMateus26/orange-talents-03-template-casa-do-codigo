package br.zupacademy.pedro.casadocodigo.validator;

import br.zupacademy.pedro.casadocodigo.estado.Estado;
import br.zupacademy.pedro.casadocodigo.estado.Estadorepository;
import br.zupacademy.pedro.casadocodigo.pais.EstadoAndPaisRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

public class ExistStateIntocountryValidator implements ConstraintValidator<ExistStateIntoCountry, EstadoAndPaisRequestDTO> {
    @Autowired
    private Estadorepository estadorepository;
    private Long idPais;
    private Long idEstado;


    @Override
    public boolean isValid(EstadoAndPaisRequestDTO estadoAndPaisRequestDTO, ConstraintValidatorContext constraintValidatorContext) {
        this.idPais=estadoAndPaisRequestDTO.getPaisId();
        this.idEstado=estadoAndPaisRequestDTO.getEstadoId();

        if(idEstado==null){

            List<Estado> estado=estadorepository.findByPaisId(idPais);
            return estado.isEmpty();
        }
        Optional<Estado> estado=estadorepository.findByidAndPaisId(idEstado,idPais);

        return estado.isPresent();
    }
}
