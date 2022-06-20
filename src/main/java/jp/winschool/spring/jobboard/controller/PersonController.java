package jp.winschool.spring.jobboard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.winschool.spring.jobboard.model.Account;
import jp.winschool.spring.jobboard.model.Person;
import jp.winschool.spring.jobboard.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@ModelAttribute("person")
	public Person currentPerson(Account account) {
		return account.getPerson();
	}
	
	@GetMapping("")
	public String index() {
		return "person/index";
	}
	
	@GetMapping("/edit")
	public String edit() {
		return "person/form";
	}
	
	@PostMapping("/edit")
	public String edit(@Valid Person person, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "person/form";
		}
		
		personService.updatePerson(person);
		return "redirect:/person";
	}

}
