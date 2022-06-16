package jp.winschool.spring.jobboard.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryTest {
	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	void testValidationSuccess() {
		Entry entry = new Entry();
		entry.setContents("春田");

		Set<ConstraintViolation<Entry>> violations = validator.validate(entry);
		assertThat(violations.size()).isEqualTo(0);
	}
	
	@Test
	void testValidationFail() {
		Entry entry = new Entry();

		// 制約違反になる長さの文字列を設定
		String s = "";
		for (int i = 0; i < 130; i++) {
			s += "1234567890";
		}
		entry.setContents(s);

		Set<ConstraintViolation<Entry>> violations = validator.validate(entry);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Entry> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(Size.class);
		}
	}
}
