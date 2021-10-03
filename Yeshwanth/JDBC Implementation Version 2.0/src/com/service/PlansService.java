package com.service;

import com.bean.Customer;
import com.bean.Plans;
import com.dao.PlansDAO;

public class PlansService {
	
	public static boolean enterDesiredPlans(Plans customerPlans, Customer customer) {
		
		PlansDAO dao= new PlansDAO();
		
		return dao.enterDesiredPlans(customerPlans, customer);
		
	}

}
