package com.bean;

public class TariffPlan {
	
	private int id;
	private String planName;
	private String typeOfPlan;
	private double tariffRate;
	private int validity;
	private boolean rental;
	private static int tariffCounter = 0;
	
	public TariffPlan(int id, String planName, String typeOfPlan, double tariffRate, int validity, boolean rental) {
		super();
		this.id = id;
		this.planName = planName;
		this.typeOfPlan = typeOfPlan;
		this.tariffRate = tariffRate;
		this.validity = validity;
		this.rental = rental;
		tariffCounter++;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getTypeOfPlan() {
		return typeOfPlan;
	}
	public void setTypeOfPlan(String typeOfPlan) {
		this.typeOfPlan = typeOfPlan;
	}
	public double getTariffRate() {
		return tariffRate;
	}
	public void setTariffRate(double tariffRate) {
		this.tariffRate = tariffRate;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public boolean isRental() {
		return rental;
	}
	public void setRental(boolean rental) {
		this.rental = rental;
	}
	public static int getTariffCounter() {
		return tariffCounter;
	}
	public static void setTariffCounter(int tariffCounter) {
		TariffPlan.tariffCounter = tariffCounter;
	}
	

}
