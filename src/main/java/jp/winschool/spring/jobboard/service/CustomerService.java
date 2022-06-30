package jp.winschool.spring.jobboard.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.winschool.spring.jobboard.model.Account;
import jp.winschool.spring.jobboard.model.Customer;
import jp.winschool.spring.jobboard.repository.AccountRepository;
import jp.winschool.spring.jobboard.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private SpringUserService springUserService;
	
	@Autowired
	private CustomerService customerService;

	
	public Customer createDefaultValueCustomer() {
		Customer customer = new Customer();
		customer.setName("名前を設定してください");
		customer.setMail("please@set.email");
		customer.setTel("000-0000-0000");
		customer.setBirthday(LocalDate.of(1980, 1, 1));
		customer.setCareer("");
        customerRepository.save(customer);
        return customer;
	}
	
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	@Transactional
	public Account createCustomer(String username, String password, boolean active) {
        springUserService.createSpringUser(username, password, "CUSTOMER", active);
        
//        Customer customer = customerService.createDefaultValueCustomer();
        
        Account account = new Account();
        account.setUsername(username);
        account.setType("customer");
//        account.setCustomer(customer);
        account.setActive(active);	
        accountRepository.save(account);
        return account;
    }
	
//	@Transactional
//    public Customer joinCustomer(Customer customer){
//		springUserService.createSpringUser(customer.getUsername(), customer.getPassword(), "CUSTOMER", true);
//		
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//        customer.setUsername(customer.getUsername());
//        customer.setName(customer.getName());
//        customer.setMail(customer.getMail());
//        customer.setTel(customer.getTel());
//        customer.setBirthday(customer.getBirthday());
//        customer.setCareer(customer.getCareer());
//        customer.setUserAuth("USER");
//        customer.setAppendDate(localTime);
//        customer.setUpdateDate(localTime);
//        customer.setActive(customer.getActive());
//        customerRepository.save(customer);
//        return customer;
//    }

}
