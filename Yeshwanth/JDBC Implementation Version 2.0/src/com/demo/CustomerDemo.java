package com.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.Bill;
import com.bean.Customer;
import com.bean.Plans;
import com.bean.TariffPlan;
import com.service.BillService;
import com.service.CustomerService;
import com.service.PlansService;
import com.service.TariffPlanService;

public class CustomerDemo {

	private static Scanner sc;

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
		
		System.out.println("Following plans are offered by our company at the moment:");
		System.out.println("Plan A: " + planA.getPlanName() + ", Offers: " + planA.getTypeOfPlan() + ", Monthly Tariff: " + planA.getTariffRate() + "€, Validity: " + planA.getValidity() + " yrs");
		System.out.println("Plan B: " + planB.getPlanName() + ", Offers: " + planB.getTypeOfPlan() + ", Monthly Tariff: " + planB.getTariffRate() + "€, Validity: " + planB.getValidity() + " yrs");
		System.out.println("Plan C: " + planC.getPlanName() + ", Offers: " + planC.getTypeOfPlan() + ", Monthly Tariff: " + planC.getTariffRate() + "€, Validity: " + planC.getValidity() + " yrs");
		
		System.out.println("Select the plans that you would like to subscribe to. For example, if you want to select plan A just type 'a'. If you want to select more than one plan, let's say plan B and C, then type 'bc'.");
		sc = new Scanner(System.in);
		System.out.print("Enter your choices: ");
		String str1= sc.nextLine();
		
		LocalDate dateOfStart = LocalDate.now();
		
		List<TariffPlan> tariffPlansCustomer1 = new ArrayList<TariffPlan>();
		if(str1 != null) {
			if(str1.toLowerCase().equals("a")) {
				tariffPlansCustomer1.add(planA);
			}
			else if(str1.toLowerCase().equals("b")) {
				tariffPlansCustomer1.add(planB);
			}
			else if(str1.toLowerCase().equals("c")) {
				tariffPlansCustomer1.add(planC);
			}
			else if(str1.toLowerCase().equals("ab") || str1.toLowerCase().equals("ba")) {
				tariffPlansCustomer1.add(planA);
				tariffPlansCustomer1.add(planB);
			}
			else if(str1.toLowerCase().equals("ac") || str1.toLowerCase().equals("ca")) {
				tariffPlansCustomer1.add(planA);
				tariffPlansCustomer1.add(planC);
			}
			else if(str1.toLowerCase().equals("bc") || str1.toLowerCase().equals("cb")) {
				tariffPlansCustomer1.add(planB);
				tariffPlansCustomer1.add(planC);
			}
			else if(str1.toLowerCase().equals("abc") || str1.toLowerCase().equals("bca")
					|| str1.toLowerCase().equals("cab") || str1.toLowerCase().equals("bac")
					|| str1.toLowerCase().equals("cba") || str1.toLowerCase().equals("acb")) {
				tariffPlansCustomer1.add(planA);
				tariffPlansCustomer1.add(planB);
				tariffPlansCustomer1.add(planC);
			}
			System.out.println("Thanks for your input! Selected plans have been added to the subscription.");
		}
		
		else {
			System.out.println("Invalid choice(s)...");
		}
		
		Plans planDetailsCustomer1 = new Plans(tariffPlansCustomer1, customer1, dateOfStart);
		System.out.println("Active tariff plans in the account of customer with the customer ID " + customer1.getCustomerId());
		if(PlansService.enterDesiredPlans(planDetailsCustomer1, customer1)) {
			System.out.println("Done");
		}
		else
			System.out.println("No records found");
		
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
