package jp.winschool.spring.jobboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.winschool.spring.jobboard.model.Company;
import jp.winschool.spring.jobboard.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public Company createDefaultValueCompany() {
		Company company = new Company();
		company.setName("名前を設定してください");
		company.setUrl("please set url");
		company.setMail("please@set.email");
		company.setTel("000-0000-0000");
		companyRepository.save(company);
		return company;
	}
}
