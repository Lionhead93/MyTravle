package com.youlove.service.domain;

public class Exchange {
	
	private String from;
	private String to;
	private double amount;
	private String nation;
	private String unit;
	private double exchangeRate;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Override
	public String toString() {
		return "ExchangeVO : [from]" + from + " [to]" + to + " [amount]" + amount
				+ " [nation]" + nation + " [unit]" + unit + " [exchangeRate]" + exchangeRate;
	}
	
}