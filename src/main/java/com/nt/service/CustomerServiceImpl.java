package com.nt.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nt.exceptions.CustomerNotFoundException;
import com.nt.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	Map<String, Customer> map = new HashMap<String, Customer>();

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public String addCustomer(Customer c) {

		if (!map.containsKey(c.getCustomerId())) {
			map.put(c.getCustomerId(), c);
		} else {
			return "duplicate customerid not added";
		}

		return "Customer added sucessfully";
	}

	@Override
	public Customer getCustomerDetailsByID(String customerID) {
		if (map.containsKey(customerID.toString()))
			return map.get(customerID);
		else {
				throw new CustomerNotFoundException("Customer Id is not valid");
		}

		

	}
}
