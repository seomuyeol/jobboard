package jp.winschool.spring.jobboard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.winschool.spring.jobboard.model.AccountForm;
import jp.winschool.spring.jobboard.service.CustomerService;

@Controller
@RequestMapping
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("")
	public String index(Model model) {
//		List<Account> accounts = accountService.getAccountList();
//		model.addAttribute("accounts", accounts);
		
		return "index";
	}
	
	@GetMapping("/customer/create")
	public String create(AccountForm accountForm) {
		return "customer/create";
	}
	
	@PostMapping("/customer/create")
	public String create(@Valid AccountForm accountForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "customer/create";
		}
		try {
			String username = accountForm.getUsername();
			String password = accountForm.getPassword();
			boolean active = accountForm.getActive();
			
			customerService.createCustomer(username, password, active);
			return "redirect:/";
			
		} catch (DuplicateKeyException e) {
			bindingResult.addError(new FieldError("accountForm", "username", "既に存在するユーザIDです"));
			return "customer/create";
		}
	}
//	
//	@GetMapping("/{username}/edit")
//	public String edit(@PathVariable("username") Account account, AccountForm accountForm) {
//		accountForm.setType(account.getType());
//		accountForm.setUsername(account.getUsername());
//		accountForm.setActive(account.getActive());
//		return "account/edit";
//	}
//	
//	@PostMapping("/{username}/edit")
//	public String edit(@PathVariable("username") Account account, 
//			@Valid AccountForm accountForm, BindingResult bindingResult) {
//		//　パスワードが空の場合、変更は行わないのでバリデーションエラーは問題ない
//		if (!accountForm.getPassword().equals("") && bindingResult.hasErrors()) {
//			return "account/edit";
//		}
//		accountService.updateAccount(accountForm.getUsername(), accountForm.getPassword(), accountForm.getActive());
//		return "redirect:/account";
//	}
}
