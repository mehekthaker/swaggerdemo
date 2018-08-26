package com.cg.swagger.swaggerdemo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.swagger.swaggerdemo.Customer;
import com.cg.swagger.swaggerdemo.service.ServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;

@RestController
@Api(value = "Customer", description = "Operations pertaining to customers in a shop")
public class CustomerController {

	@Autowired
	private ServiceImpl service;

	@ApiOperation(value = "Add a customer")
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addCustomer(@RequestBody Customer customer) {
		// System.out.println(service);
		service.addCustomer(customer);
		return new ResponseEntity<>("Customer saved successfully", HttpStatus.OK);

	}

	@ApiOperation(value = "View list of customers", response = Iterable.class)
	@RequestMapping(value = "/customer/show", method = RequestMethod.GET, produces = "application/json")
	public Iterable viewAllCustomers(Model model) {
		// System.out.println(service.viewAllCustomers());
		// Iterable<Customer> customerList = service.addCustomer(customer);

		Iterable customerList = service.viewAllCustomers();
		return customerList;
	}

	@ApiOperation(value = "Search a customer with an ID", response = Customer.class)
	@RequestMapping(value = "/customer/show/{customerId}", method = RequestMethod.GET, produces = "application/json")
	public Customer showCustomer(@PathVariable int customerId, Model model) {
		//Optional<Customer> customer = service.getCustomerById(id);
		Customer customer = service.getCustomerById(customerId);
		return customer;
	}

	@ApiOperation(value = "Update customer")
	@RequestMapping(value = "/customer/update/{customerId}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
		 Customer storedCustomer = service.getCustomerById(customerId);
		 storedCustomer.setCustomerName(customer.getCustomerName());
		 storedCustomer.setEmailId(customer.getEmailId());
		 storedCustomer.setDateOfBirth(customer.getDateOfBirth());
		 storedCustomer.setContactNumber(customer.getContactNumber());
	        service.updateCustomer(storedCustomer);
		
		
		//service.updateCustomer(customer);
		return new ResponseEntity<String>("Customer Updated Successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a product")
	@RequestMapping(value = "/customer/delete/{customerId}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCustomer(@PathVariable int customerId) {
		service.deleteCustomer(customerId);
		return new ResponseEntity<String>("Customer Deleted Successfully", HttpStatus.OK);
	}

}
