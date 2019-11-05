package com.nt.service;

import com.nt.model.Customer;

public interface CustomerService {
	
	public String addCustomer(Customer c);
	public Customer getCustomerDetailsByID(String customerID);

}
