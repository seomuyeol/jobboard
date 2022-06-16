package jp.winschool.spring.jobboard.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountFormTest {
	private Validator validator;
	
	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	void testValidationSuccess() {
		AccountForm form = new AccountForm();
		form.setUsername("user");
		form.setPassword("12345678");
		
		Set<ConstraintViolation<AccountForm>> violations = 
				validator.validate(form);
		assertThat(violations.size()).isEqualTo(0);
	}
	
	@Test
	void testValidationFailUsername() {
		AccountForm form = new AccountForm();
		form.setPassword("12345678");
		
		Set<ConstraintViolation<AccountForm>> violations = 
				validator.validate(form);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<AccountForm> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(NotBlank.class);
		}
	}
	
	@Test
	void testValidationFailPasswordBlank() {
		AccountForm form = new AccountForm();
		form.setUsername("user");
		
		Set<ConstraintViolation<AccountForm>> violations = 
				validator.validate(form);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<AccountForm> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(NotBlank.class);
		}
	}
	
	@Test
	void testValidationFailPasswordSize() {
        AccountForm form = new AccountForm();
        form.setUsername("user");
        form.setPassword("1234");
        
        Set<ConstraintViolation<AccountForm>> violations = validator.validate(form);
        assertThat(violations.size()).isEqualTo(1);
        for (ConstraintViolation<AccountForm> violation : violations) {
            Object annotation = violation.getConstraintDescriptor().getAnnotation();
            assertThat(annotation).isInstanceOf(Size.class);
        }
    }
}
