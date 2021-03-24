package br.zupacademy.pedro.casadocodigo.validator;

import br.zupacademy.pedro.casadocodigo.autor.AutorRepository;
import br.zupacademy.pedro.casadocodigo.categoria.CategoriaRepository;
import br.zupacademy.pedro.casadocodigo.exceptions.handler.FieldMessage;
import br.zupacademy.pedro.casadocodigo.livro.LivroRepository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UniqueValidatorValue implements ConstraintValidator<UniqueValue, Object> {

    @PersistenceContext
    private EntityManager entityManager;
    private String domainAttibute;
    private Class<?> klass;


    @Override
    public void initialize(UniqueValue params) {
        domainAttibute=params.fieldName();
        klass=params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("select 1 from "
                +klass.getName()
                +" where "
                +domainAttibute+
                "=:value");
        query.setParameter("value",value);
        List<?> list=query.getResultList();
            if(list.size()<=1){
                FieldMessage fieldMessage = new FieldMessage(""," Foi encontrado mais de um atributo "
                        +domainAttibute
                        +" = "
                        +value
                        + " registrdo." );
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(fieldMessage.getMessage())
                        .addConstraintViolation();
            }

        return list.isEmpty();
    }
}
