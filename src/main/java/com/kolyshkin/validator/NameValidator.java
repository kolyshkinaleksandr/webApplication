package com.kolyshkin.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value= "nameValidator")
public class NameValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
        String string= (String)value;
        if(string.length()== 0){
       	String zeroLength= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
       			getString("zeroLength");
       	 throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, zeroLength, zeroLength));
        }else if (string.length()<= 1) {
			String lessSymbols= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
					getString("lessSymbols");
			 throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, lessSymbols, lessSymbols));
		}else if (string.length()>= 12) {
			String moreSymbols= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
					getString("moreSymbols");
			 throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, moreSymbols, moreSymbols));
		}
	}
}
