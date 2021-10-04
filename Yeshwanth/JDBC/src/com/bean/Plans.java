package com.bean;

import java.time.LocalDate;
import java.util.List;

public class Plans {
	
	private List<TariffPlan> planNames;
	private int customerId;
	private LocalDate dateOfStart;
	
	public Plans(List<TariffPlan> plans, Customer customer, LocalDate dateOfStart) {
		super();
		this.planNames = plans;
		this.customerId = customer.getCustomerId();
		this.dateOfStart = dateOfStart;
	}
	
	public List<TariffPlan> getPlanNames() {
		return planNames;
	}
	public void setPlanNames(List<TariffPlan> planNames) {
		this.planNames = planNames;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public LocalDate getDateOfStart() {
		return dateOfStart;
	}
	public void setDateOfStart(LocalDate dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	
}
