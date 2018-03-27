package com.kolyshkin.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value= "quizValidator")
public class QuizValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object quizValue) throws ValidatorException {
		// TODO Auto-generated method stub
		String inputString= (String)quizValue;
		String text= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
				getString("zeroLength");
		if (inputString.length()== 0 || "".equals(inputString)) {
			FacesMessage empty= new FacesMessage(FacesMessage.SEVERITY_ERROR, text, text);
			throw new ValidatorException(empty);
		}
	}
}
