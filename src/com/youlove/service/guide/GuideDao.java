package com.youlove.service.guide;

import java.util.List;

import com.youlove.service.domain.City;

public interface GuideDao {
	
	public List<City> getCity(City city) throws Exception ;

	public List<City> getCityList(String value) throws Exception ;
}
