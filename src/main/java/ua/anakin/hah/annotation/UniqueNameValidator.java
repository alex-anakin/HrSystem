package ua.anakin.hah.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.anakin.hah.repository.UserRepository;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String>{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UniqueName constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if (userRepository == null)
			return true;
		return userRepository.findByName(username) == null;
	}	

}
