package jp.winschool.spring.jobboard.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OfferTest {
	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	void testValidationSuccess() {
		Offer offer = new Offer();
		offer.setTitle("Springエンジニア募集");
		offer.setPrefecture("東京都");
		offer.setAddress("新宿区");

		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(0);
	}

	@Test
	public void testValidationFailTitleBlank() {
		Offer offer = new Offer();
		offer.setPrefecture("東京都");      
		offer.setAddress("新宿区");         

		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Offer> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(NotBlank.class);
		}
	}

	@Test
	public void testValidationFailTitleSize() {
		Offer offer = new Offer();
		offer.setPrefecture("東京都");      
		offer.setAddress("新宿区");         

		// 制約違反になる長さの文字列を設定
		String s = "";
		for (int i = 0; i < 100; i++) {
			s += "1234567890";
		}
		offer.setTitle(s);

		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Offer> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(Size.class);
		}
	}
	
	@Test
	public void testValidationFailContentsFormat() {
		Offer offer = new Offer();
		offer.setTitle("Springエンジニア募集"); 
		offer.setPrefecture("東京都");      
		offer.setAddress("新宿区");
		
		// 制約違反になる長さの文字列を設定
				String s = "";
				for (int i = 0; i < 150; i++) {
					s += "1234567890";
				}
				offer.setContents(s);

		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Offer> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(Size.class);
		}
	}
	
	@Test
	public void testValidationFailPrefectureBlank() {
		Offer offer = new Offer();
		offer.setTitle("Springエンジニア募集"); 
		offer.setAddress("新宿区");         

		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Offer> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(NotBlank.class);
		}
	}
	
	@Test
	public void testValidationFailAddressBlank() {
		Offer offer = new Offer();
		offer.setTitle("Springエンジニア募集"); 
		offer.setPrefecture("東京都");      
		
		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Offer> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(NotBlank.class);
		}
	}
	
	@Test
	public void testValidationFailAddressFormat() {
		Offer offer = new Offer();
		offer.setTitle("Springエンジニア募集"); 
		offer.setPrefecture("東京都");      
		
		// 制約違反になる長さの文字列を設定
				String s = "";
				for (int i = 0; i < 150; i++) {
					s += "1234567890";
				}
				offer.setAddress(s);

		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Offer> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(Size.class);
		}
	}
	
	@Test
	public void testValidationFailSalaryFormat() {
		Offer offer = new Offer();
		offer.setTitle("Springエンジニア募集"); 
		offer.setPrefecture("東京都");      
		offer.setAddress("新宿区");
		
		// 制約違反になる長さの文字列を設定
				String s = "";
				for (int i = 0; i < 150; i++) {
					s += "1234567890";
				}
				offer.setSalary(s);

		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Offer> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(Size.class);
		}
	}
	
	@Test
	public void testValidationFailWorkingHoursFormat() {
		Offer offer = new Offer();
		offer.setTitle("Springエンジニア募集"); 
		offer.setPrefecture("東京都");      
		offer.setAddress("新宿区");
		
		// 制約違反になる長さの文字列を設定
				String s = "";
				for (int i = 0; i < 150; i++) {
					s += "1234567890";
				}
				offer.setWorkingHours(s);

		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Offer> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(Size.class);
		}
	}
	
	@Test
	public void testValidationFailHolidaysFormat() {
		Offer offer = new Offer();
		offer.setTitle("Springエンジニア募集"); 
		offer.setPrefecture("東京都");      
		offer.setAddress("新宿区");
		
		// 制約違反になる長さの文字列を設定
				String s = "";
				for (int i = 0; i < 150; i++) {
					s += "1234567890";
				}
				offer.setHoliday(s);

		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Offer> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(Size.class);
		}
	}
	
	@Test
	public void testValidationFailInsuranceFormat() {
		Offer offer = new Offer();
		offer.setTitle("Springエンジニア募集"); 
		offer.setPrefecture("東京都");      
		offer.setAddress("新宿区");
		
		// 制約違反になる長さの文字列を設定
				String s = "";
				for (int i = 0; i < 150; i++) {
					s += "1234567890";
				}
				offer.setInsurance(s);

		Set<ConstraintViolation<Offer>> violations = validator.validate(offer);
		assertThat(violations.size()).isEqualTo(1);
		for (ConstraintViolation<Offer> violation : violations) {
			Object annotation = violation.getConstraintDescriptor().getAnnotation();
			assertThat(annotation).isInstanceOf(Size.class);
		}
	}
	
}
