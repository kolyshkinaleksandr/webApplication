package com.kolyshkin.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value= "passValidator")
public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent componentUi, Object passValue) throws ValidatorException {
		// TODO Auto-generated method stub
		//cast the value of the entered password to string
				String password= (String) passValue;
				//Obtain the component and submitted value of the confirm password component
				UIInput confirmComponent= (UIInput)componentUi.getAttributes().get("confirm");
				String confirm= (String)confirmComponent.getSubmittedValue();
				//check if both passwords are filled in
			 if(password.length()== 0){
			    String zeroPass= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
			    	   getString("zeroPass");
					 throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, zeroPass, zeroPass));}
				//compare the password with the confirm password
				  else if(!password.equals(confirm)){
					  String notEQPass= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
					    	   getString("notEQPass");
					confirmComponent.setValid(false); //mark it invalid
					throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, notEQPass, notEQPass));
		}
	}
}
