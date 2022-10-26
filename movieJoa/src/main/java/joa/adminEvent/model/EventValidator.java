package joa.adminEvent.model;

import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@PropertySource("src/main/resources/properties/validation_ko.properties")
public class EventValidator implements Validator{ 
	@Override
	public boolean supports(Class<?> clazz) { 
		return AdminEventDTO.class.isAssignableFrom(clazz);
	}
	
	String onlynumber = "^[0-9]*$";
	String onlyenglish = "^[a-zA-Z]*$";
	String onlykorean = "[가-힣]*	";

	@Override
	public void validate(Object target, Errors errors) { 
		AdminEventDTO AdminEventDTO = (AdminEventDTO)target;

		if(AdminEventDTO.getEve_subject() == null || AdminEventDTO.getEve_subject().trim().isEmpty()) {
			errors.rejectValue("eve_subject", "NotBlank");}
		
		if(AdminEventDTO.getEve_category().equals("유형 선택")|| AdminEventDTO.getEve_category() == null ||  AdminEventDTO.getEve_category().trim().isEmpty()) {
			errors.rejectValue("eve_category", "NotBlank");}
	
	}

}
