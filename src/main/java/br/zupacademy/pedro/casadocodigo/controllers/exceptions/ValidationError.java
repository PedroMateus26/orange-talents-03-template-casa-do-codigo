package br.zupacademy.pedro.casadocodigo.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    private List<FieldMessage> listError=new ArrayList<>();

    public List<FieldMessage> getListError() {
        return listError;
    }
    public void addError(String message, String error){
        listError.add(new FieldMessage(error,message));
    }
}
