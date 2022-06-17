package jp.winschool.spring.jobboard.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.winschool.spring.jobboard.model.Person;
import jp.winschool.spring.jobboard.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public Person createDefaultValuePerson() {
		Person person = new Person();
		person.setName("名前を設定してください");
        person.setMail("please@set.email");
        person.setTel("000-0000-0000");
        person.setBirthday(LocalDate.of(1980, 1, 1));
        person.setCareer("");
        personRepository.save(person);
        return person;
	}

}
