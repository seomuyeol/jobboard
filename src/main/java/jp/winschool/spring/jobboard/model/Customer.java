package jp.winschool.spring.jobboard.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message = "ユーザーIDを入力してください")
	private String username;
    
	@NotBlank(message = "パスワードを入力してください")
	@Size(min = 8, message = "パスワードは8文字以上で入力してください")
	private String password;
    
    @NotBlank(message = "氏名を入力してください")
    @Size(max = 80, message = "氏名は80文字以内で入力してください")
    @Column(length = 80)
    private String name;

    @NotBlank(message = "メールアドレスを入力してください")
    @Email(message = "正しいメールアドレスを入力してください")
    @Size(max = 80, message = "メールアドレスは80文字以内で入力してください")
    @Column(length = 80)
    private String mail;
    
    @NotBlank(message = "電話番号を入力してください")
    @Pattern(regexp = "0\\d{1,2}-\\d{2,4}-\\d{4}", message = "電話番号はXXX-XXXX-XXXXの形式で入力してください")
    @Column(length = 20)
    private String tel;
    
    @NotNull(message = "誕生日を入力してください")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    
    @Size(max = 1000, message = "職歴は1000文字以内で入力してください")
    @Column(length = 1000)
    private String career;
    
}