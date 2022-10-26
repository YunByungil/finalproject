package joa.adminMovie.model;

import java.util.regex.Pattern;

import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@PropertySource("src/main/resources/properties/validation_ko.properties")
public class MovieValidator implements Validator{ 
	@Override
	public boolean supports(Class<?> clazz) { 
		return AdminMovieDTO.class.isAssignableFrom(clazz);
	}
	
	String onlynumber = "^[0-9]*$";
	String onlyenglish = "^[a-zA-Z]*$";
	String onlykorean = "[가-힣]*	";

	@Override
	public void validate(Object target, Errors errors) { 
		AdminMovieDTO AdminMovieDTO = (AdminMovieDTO)target;

		String running_time_s = Integer.toString(AdminMovieDTO.getMov_running_time());
		
		
		if(AdminMovieDTO.getMov_title() == null || AdminMovieDTO.getMov_title().trim().isEmpty()) {
				errors.rejectValue("mov_title", "NotBlank");}
		
		
		if(AdminMovieDTO.getMov_director() == null || AdminMovieDTO.getMov_director().trim().isEmpty()) { 
				errors.rejectValue("mov_director", "NotBlank");}
	
		
		if(AdminMovieDTO.getMov_start_date() == null || AdminMovieDTO.getMov_start_date().equals("nnnn-nn-nn") || AdminMovieDTO.getMov_start_date() == "" || AdminMovieDTO.getMov_start_date().length()==0 || AdminMovieDTO.getMov_start_date().trim().isEmpty()) { 
				errors.rejectValue("mov_start_date", "NotBlank");
				
		
		if(AdminMovieDTO.getMov_end_date() == null || AdminMovieDTO.getMov_end_date().trim().isEmpty()) {
				errors.rejectValue("mov_end_date", "NotBlank");}
		
		if(AdminMovieDTO.getMov_country() == null || AdminMovieDTO.getMov_country().trim().isEmpty()) {
				errors.rejectValue("mov_country", "NotBlank");}
		
		if(AdminMovieDTO.getMov_genre() == null || AdminMovieDTO.getMov_genre().trim().isEmpty()) { 
				errors.rejectValue("mov_genre", "NotBlank");}
		
		if(AdminMovieDTO.getMov_running_time() < 1 || AdminMovieDTO.getMov_running_time() < 999 ) {
				errors.rejectValue("mov_running_time", "Renge");}
		boolean mat=Pattern.matches(onlynumber, running_time_s);
		if(mat==false){errors.rejectValue("mov_running_time", "Pattern");}
		
		if(AdminMovieDTO.getMov_rate() == null || AdminMovieDTO.getMov_rate().equals("등급 선택") || AdminMovieDTO.getMov_rate().trim().isEmpty() || AdminMovieDTO.getMov_rate() == "") {
				errors.rejectValue("mov_rate", "NotBlank");}
		
		if(AdminMovieDTO.getMov_info() == null || AdminMovieDTO.getMov_rate().trim().isEmpty()) {errors.rejectValue("mov_info", "NotBlank");}
		if(AdminMovieDTO.getMov_info().length() > 200) { errors.rejectValue("mov_info", "Size");}
		
		if(AdminMovieDTO.getMov_poster() == null || AdminMovieDTO.getMov_poster().trim().isEmpty()) { errors.rejectValue("mov_poster", "NotBlank");
		}
				
		}
	}

}
