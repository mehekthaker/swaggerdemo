package com.cg.swagger.swaggerdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.swagger.swaggerdemo.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
