package br.zupacademy.pedro.casadocodigo.validator;

import br.zupacademy.pedro.casadocodigo.exceptions.handler.FieldMessage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistIdValue, Long> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<?> klass;


    @Override
    public void initialize(ExistIdValue constraintAnnotation) {
        this.klass=constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
        String jpql="select 1 from "+klass.getName()+" r where r.id=:aLong";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("aLong",aLong);
        return query.getResultList().size()==1;
    }
}
