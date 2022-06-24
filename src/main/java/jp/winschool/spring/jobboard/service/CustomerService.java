package jp.winschool.spring.jobboard.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.winschool.spring.jobboard.model.Customer;
import jp.winschool.spring.jobboard.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer createDefaultValuePerson() {
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
	
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
