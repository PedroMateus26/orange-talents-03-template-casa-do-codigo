package br.zupacademy.pedro.casadocodigo.autor.anotations;

import br.zupacademy.pedro.casadocodigo.autor.Autor;
import br.zupacademy.pedro.casadocodigo.autor.AutorRequestDTO;
import br.zupacademy.pedro.casadocodigo.autor.AutorRepository;
import br.zupacademy.pedro.casadocodigo.exceptions.handler.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class AutorValidator implements ConstraintValidator<AutorValid, AutorRequestDTO> {

    private AutorRepository autorRepository;

    @Autowired
    public AutorValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean isValid(AutorRequestDTO autorRequestDTO, ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> listErrors = new ArrayList<>();
        Autor autor = autorRepository.findByEmail(autorRequestDTO.getEmail());

        if(autor!=null){
            listErrors.add(new FieldMessage("email","Email já cadastrado!"));
        }

        for (FieldMessage e : listErrors) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getError())
                    .addConstraintViolation();
        }

        return listErrors.isEmpty();
    }
}
