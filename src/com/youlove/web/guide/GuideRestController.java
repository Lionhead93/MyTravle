package com.youlove.web.guide;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youlove.common.TimeZoneId;
import com.youlove.common.api.OpenWeather;
import com.youlove.service.domain.City;
import com.youlove.service.domain.Time;
import com.youlove.service.domain.Weather;
import com.youlove.service.guide.GuideService;

@RestController
@RequestMapping("/guide/*")
public class GuideRestController {
	
	public GuideRestController() {
		System.out.println(this.getClass());
	}
	@RequestMapping("/json/getTime")
	public List<Time> getTime() throws Exception {
		
		List<Time> list = TimeZoneId.getTimezone();
		return list;
	}
	
	@RequestMapping(value = "/json/getWeather", method=RequestMethod.POST)
	public Weather getWeather(@RequestBody Weather weather) throws Exception {
		
		System.out.println("/json/getWeather : POST");
		
		weather = OpenWeather.getWeather(weather);
		
		
		return weather;
	}
	
	
}
