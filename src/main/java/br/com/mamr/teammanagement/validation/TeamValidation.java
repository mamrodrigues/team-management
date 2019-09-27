package br.com.mamr.teammanagement.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.mamr.teammanagement.domain.Team;

public class TeamValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Team.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

//		Team produto = (Team) target;
//		if(produto.getPaginas() <= 0) {
//			errors.rejectValue("paginas", "field.required");
//		}		
	}
	
}
