package br.zupacademy.pedro.casadocodigo.categoria.anotations;

import br.zupacademy.pedro.casadocodigo.categoria.Categoria;
import br.zupacademy.pedro.casadocodigo.categoria.CategoriaRepository;
import br.zupacademy.pedro.casadocodigo.categoria.CategoriaRequestDTO;
import br.zupacademy.pedro.casadocodigo.exceptions.handler.FieldMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CategoriaValidator implements ConstraintValidator<CategoriaValid, CategoriaRequestDTO> {

    private CategoriaRepository categoriaRepository;

    public CategoriaValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean isValid(CategoriaRequestDTO categoriaRequestDTO, ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> listErrors = new ArrayList<>();
        Categoria categoria = categoriaRepository.findByNomeCategoria(categoriaRequestDTO.getNomeCategoria());

        if(categoria!=null){
            listErrors.add(new FieldMessage("nomeCategoria","Categoria já cadastrada!"));
        }

        for (FieldMessage e : listErrors) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getError())
                    .addConstraintViolation();
        }

        return listErrors.isEmpty();
    }
}
