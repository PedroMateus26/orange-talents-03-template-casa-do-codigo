package br.zupacademy.pedro.casadocodigo.exceptions.handler;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    private List<FieldMessage> listError=new ArrayList<>();

    public List<FieldMessage> getListError() {
        return listError;
    }
    public void addError(String error,String message){
        listError.add(new FieldMessage(error,message));
    }
}
