package com.youlove.service.domain;

public class Weather {
	
	private String icon;
	private String temp;
	private String tempMin;
	private String tempMax;
	private String humidity;
	private String lat;
	private String lng;
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getTempMin() {
		return tempMin;
	}
	public void setTempMin(String tempMin) {
		this.tempMin = tempMin;
	}
	public String getTempMax() {
		return tempMax;
	}
	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	@Override
	public String toString() {
		return "Weather [icon=" + icon + ", temp=" + temp + ", tempMin=" + tempMin + ", tempMax=" + tempMax
				+ ", humidity=" + humidity + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
	
	

}
