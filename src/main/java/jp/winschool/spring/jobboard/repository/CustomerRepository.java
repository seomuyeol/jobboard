package jp.winschool.spring.jobboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.winschool.spring.jobboard.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
