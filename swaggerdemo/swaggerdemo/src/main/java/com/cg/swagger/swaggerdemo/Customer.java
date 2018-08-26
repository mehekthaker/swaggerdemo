package com.cg.swagger.swaggerdemo;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Satyen Singh
 *
 *Maintaining customer details of money money bank
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer{
	@Id
    @ApiModelProperty(notes = "The application-specific customer ID")
	private int customerId;
	@ApiModelProperty(notes = "The name of customer")
	private String customerName;
	@ApiModelProperty(notes = "The contact number of customer")
	private long contactNumber;
	@ApiModelProperty(notes = "The email id of customer")
	private String emailId;
	@ApiModelProperty(notes = "The date of birth of customer")
	private String dateOfBirth;
	//private String url;

	/*private static int custId;
	
	static {
		custId = 200;
	}
	
	this.customerId = custId;*/
	
	
		
	public Customer(int customerId, String customerName, long contactNumber, String dateOfBirth, String email) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailId = email;
		//this.url = url;
	}
	
	public Customer() {
		
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

		
/*	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}*/
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + "]";
	}


	
}
