package com.bean;

import com.service.CustomerService;

public class Bill {

	private int billId;
	private int customerId;
	private int month;
	private double fee;
	private static int billCounter = 0;
	
	public Bill(int billId, Customer customer, Plans customerPlans) {
		super();
		this.billId = billId;
		this.customerId = customer.getCustomerId();
		this.month = customerPlans.getDateOfStart().getMonthValue();
		this.fee = CustomerService.displayTotalAmount(customerPlans);
		billCounter++;
	}
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public static int getBillCounter() {
		return billCounter;
	}
	public static void setBillCounter(int billCounter) {
		Bill.billCounter = billCounter;
	}
	
	
}
