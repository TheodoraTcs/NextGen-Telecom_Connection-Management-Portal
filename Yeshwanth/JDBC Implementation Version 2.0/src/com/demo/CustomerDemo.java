package com.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bean.Bill;
import com.bean.Customer;
import com.bean.Plans;
import com.bean.TariffPlan;
import com.service.BillService;
import com.service.CustomerService;
import com.service.PlansService;
import com.service.TariffPlanService;

public class CustomerDemo {

	public static void main(String[] args) {

		Customer customer1 = new Customer(10500, "Yeshwanth", "Steyrerweg, Regensburg", "yesh@yesh.com", 4710180, "Don't know");
		System.out.println("Customer Registration status");
		System.out.println(CustomerService.registerCustomer(customer1));
		Customer customer2 = new Customer(10501, "Vishwa", "Hochweg, Regensburg", "vishy@yesh.com", 4710159, "Password");
		System.out.println("Customer Registration status");
		System.out.println(CustomerService.registerCustomer(customer2));
		
		TariffPlan planA = new TariffPlan(10, "Super saver", "internet+calls", 7.99, 2, true);
		System.out.println("Plan updation status");
		System.out.println(TariffPlanService.registerTariffPlan(planA));
		TariffPlan planB = new TariffPlan(11, "Extra benefit", "internet+calls+EUroaming", 9.99, 2, true);
		System.out.println("Plan updation status");
		System.out.println(TariffPlanService.registerTariffPlan(planB));
		TariffPlan planC = new TariffPlan(12, "Best in town", "internet+calls+International", 12.99, 2, false);
		System.out.println("Plan updation status");
		System.out.println(TariffPlanService.registerTariffPlan(planC));
		
		LocalDate dateOfStart = LocalDate.now();
		
		List<TariffPlan> tariffPlansCustomer1 = new ArrayList<TariffPlan>();
		tariffPlansCustomer1.add(planA);
		tariffPlansCustomer1.add(planC);
		
		Plans planDetailsCustomer1 = new Plans(tariffPlansCustomer1, customer1, dateOfStart);
		System.out.println("Tariff plans being added to the account of customer with the customer ID " + customer1.getCustomerId());
		if(PlansService.enterDesiredPlans(planDetailsCustomer1, customer1)) {
			System.out.println("Done");
		}
		else
			System.out.println("No plans have been selected by the customer yet.");
		
		Bill billOfCustomer1 = new Bill(525, customer1, planDetailsCustomer1);
		System.out.println("Bill generation successful for the customer with the customer no. " + customer1.getCustomerNumber());
		System.out.println(BillService.createBill(billOfCustomer1));
		
		System.out.println("Plans subscribed by the customer with the customer ID " + customer1.getCustomerId() + " are as follows:");
		for(TariffPlan plan : planDetailsCustomer1.getPlanNames()) {
			System.out.println(plan.getPlanName());
		}
		
		System.out.println("And the corresponding bill amount for " + billOfCustomer1.getMonth() + "th month is " + BillService.displayTotalAmount(billOfCustomer1) + " Euros.");
	}

}
