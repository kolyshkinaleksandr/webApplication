package com.kolyshkin.validator;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@FacesValidator(value= "fileValidator")
public class PictureValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object file) throws ValidatorException {
		// TODO Auto-generated method stub
		List<FacesMessage> messages= new ArrayList<>();
		Part picture= (Part)file;
			if (picture== null ||picture.getSize()<= 0 || picture.getContentType().isEmpty()) {
				String fileSize= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
						   getString("zeroFile");
				messages.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, fileSize, fileSize));
			}
			else if(picture.getSize()> 1000008) {
				String fileSize= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
					   getString("fileSize");
	          messages.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, fileSize, fileSize));
			}
			else if(!"image/jpg".equals(picture.getContentType()) && (!"image/jpeg".equals(picture.getContentType())) &&
                (!"image/png".equals(picture.getContentType())) ){
                String typeJpg= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
                       getString("typeJpg");
                messages.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, typeJpg, typeJpg));
}
		if(!messages.isEmpty()){
			throw new ValidatorException(messages);
		}
	}
}
