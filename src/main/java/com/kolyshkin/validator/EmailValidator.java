package com.kolyshkin.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value= "emailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valueObj) throws ValidatorException {
		// TODO Auto-generated method stub
		String email= (String)valueObj;//cast the value of the entered password to string
		Pattern pattern= Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,4}");
			Matcher matcher= pattern.matcher(email);//Match the given string with the pattern
			boolean foundMatches= matcher.matches();//Check whether match is found
		if(email.length()== 0){
			String zeroEmail= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
					getString("zeroEmail");
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, zeroEmail, zeroEmail));
		}else if(!foundMatches){
			String failEmail= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
					getString("failEmail");
			FacesMessage fMessage= new FacesMessage();
			fMessage.setDetail(failEmail);
			fMessage.setSummary(failEmail);
			fMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(fMessage);
		}
	}
}
