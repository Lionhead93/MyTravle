package com.youlove.service.domain;

public class Wallet {
	
	///Field
	private int walletDetailCode;
	private int walletCode;
	private String part;
	private String moneyUnit;
	private String expression;
	private double price;
	private double krwPrice;
	private String regDate;
	private String regTime;
	private String item;
	private String content;
	private String payOption;
	private double exchangeRate;
	private String category;
	private String walletImage;
	
	///Constructor
	public Wallet() {
	}
	public Wallet(int walletCode, String part) {
		this.walletCode = walletCode;
		this.part = part;
	}
	public Wallet(int walletCode, String part, String category) {
		this.walletCode = walletCode;
		this.part = part;
		this.category = category;
	}
	
	///Method(getter/setter)
	public int getWalletDetailCode() {
		return walletDetailCode;
	}
	public void setWalletDetailCode(int walletDetailCode) {
		this.walletDetailCode = walletDetailCode;
	}
	
	public int getWalletCode() {
		return walletCode;
	}
	public void setWalletCode(int walletCode) {
		this.walletCode = walletCode;
	}
	
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	
	public String getMoneyUnit() {
		return moneyUnit;
	}
	public void setMoneyUnit(String moneyUnit) {
		this.moneyUnit = moneyUnit;
	}
	
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getKrwPrice() {
		return krwPrice;
	}
	public void setKrwPrice(double krwPrice) {
		this.krwPrice = krwPrice;
	}
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getPayOption() {
		return payOption;
	}
	public void setPayOption(String payOption) {
		this.payOption = payOption;
	}
	
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getWalletImage() {
		return walletImage;
	}
	public void setWalletImage(String walletImage) {
		this.walletImage = walletImage;
	}
	
	@Override
	public String toString() {
		return "WalletVO : [walletDetailCode]" + walletDetailCode + " [walletCode]" + walletCode
				+ " [part]" + part + " [moneyUnit]" + moneyUnit + " [expression]" + expression
				+ " [price]" + price + " [krwPrice]" + krwPrice + " [regDate]" + regDate + " [regTime]" + regTime
				+ " [item]" + item + " [content]" + content + " [payOption]" + payOption
				+ " [exchangeRate]" + exchangeRate + " [category]" + category + " [walletImage]" + walletImage;
	}
	
}