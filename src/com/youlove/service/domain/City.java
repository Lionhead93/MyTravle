package com.youlove.service.domain;

public class City {
	
	private String cityName;
	private String countryCode;
	private double lat;
	private double lng;
	private String countryName;
	private String flagImage;
	private String payUnit;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getFlagImage() {
		return flagImage;
	}
	public void setFlagImage(String flagImage) {
		this.flagImage = flagImage;
	}
	public String getPayUnit() {
		return payUnit;
	}
	public void setPayUnit(String payUnit) {
		this.payUnit = payUnit;
	}
	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", countryCode=" + countryCode + ", lat=" + lat + ", lng=" + lng
				+ ", countryName=" + countryName + ", flagImage=" + flagImage + ", payUnit=" + payUnit + "]";
	}
	
	

}
