package com.nt.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.exceptions.ApiError;
import com.nt.exceptions.CustomerNotFoundException;
import com.nt.model.Customer;
import com.nt.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService custService;

	@PostMapping(value = "/add", consumes = { "application/json", "application/xml" })
	public String addCustomer(@RequestBody Customer c) {

		return custService.addCustomer(c);

	}

	@GetMapping(value = "/get/{customerID}", produces = { "application/json", "application/xml" })
	public Customer getCustomerBydId(@PathVariable String customerID) {
		return custService.getCustomerDetailsByID(customerID);

	}

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<ApiError> handleCustomerNotFoundException() {
		ApiError apierror=new ApiError(400, "customer id is not availabe", new Date());
		return new ResponseEntity<ApiError>(apierror,HttpStatus.BAD_REQUEST);

	}

}
