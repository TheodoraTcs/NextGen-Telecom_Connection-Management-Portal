package com.service;

import com.bean.Bill;
import com.dao.BillDAO;

public class BillService {
	
	public static boolean createBill(Bill bill) {
		
		BillDAO dao= new BillDAO();
		
		return dao.createBill(bill);
		
	}

	public static double displayTotalAmount(Bill bill) {
		
		BillDAO dao= new BillDAO();
		
		return dao.displayTotalAmount(bill);
		
		}
	
}
