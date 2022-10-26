package joa.adminCoupon.model;

import java.util.regex.Pattern;

import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@PropertySource("src/main/resources/properties/validation_ko.properties")
public class CouponValidator implements Validator{ 
	@Override
	public boolean supports(Class<?> clazz) { 
		return AdminCouponDTO.class.isAssignableFrom(clazz);
	}
	
	String onlynumber = "^[0-9]*$";
	String onlyenglish = "^[a-zA-Z]*$";
	String onlykorean = "[가-힣]*	";

	@Override
	public void validate(Object target, Errors errors) { 
		AdminCouponDTO AdminCouponDTO = (AdminCouponDTO)target;

		String discount_s = Integer.toString(AdminCouponDTO.getCou_discount());
		
		if(AdminCouponDTO.getCou_name() == null || AdminCouponDTO.getCou_name().trim().isEmpty()) {
			errors.rejectValue("cou_name", "NotBlank");}
		
		boolean mat=Pattern.matches(onlynumber, discount_s);
		if(mat==false){errors.rejectValue("cou_discount", "Pattern");}
		
		if(AdminCouponDTO.getCou_discount() < 1 || AdminCouponDTO.getCou_discount() > 99999 ) {
			errors.rejectValue("cou_discount", "Renge");}
	
	}

}
