package com.kolyshkin.validator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value= "converterValidator")
public class ConverterValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object object) throws ValidatorException {
		// TODO Auto-generated method stub
		String numbers= (String)object;
		String decimalPattern= "([0-9]*)\\.([0-9]*)";
		 boolean match= Pattern.matches(decimalPattern, numbers);
            if(match){
			FacesMessage symbols= new FacesMessage("Erase whitespaces!");
            throw new ValidatorException(symbols);
		}
	}
}
