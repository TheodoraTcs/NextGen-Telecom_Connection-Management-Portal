package com.service;

import com.bean.Customer;
import com.bean.Plans;
import com.dao.BillDAO;

public class BillService {

	public static double displayTotalAmount(Plans customerPlans, Customer customer) {
		
		BillDAO dao= new BillDAO();
		
		return dao.displayTotalAmount(customerPlans, customer);
		
		}
	
}
