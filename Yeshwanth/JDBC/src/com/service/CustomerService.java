package com.service;

import com.bean.Customer;
import com.bean.Plans;
import com.dao.CustomerDAO;

public class CustomerService {
	
public static boolean registerCustomer(Customer customer){
		
		
		CustomerDAO dao= new CustomerDAO();
		
		return dao.registerCustomer(customer);
	}

public static double displayTotalAmount(Plans customerPlans) {
	
	CustomerDAO dao= new CustomerDAO();
	
	return dao.displayTotalAmount(customerPlans);
	
	}

}
