package com.youlove.common.api;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.youlove.service.domain.Weather;

public class OpenWeather {
	
	
	public static Weather getWeather(Weather weather) throws Exception {
		
		HttpClient httpClient = new DefaultHttpClient();
		
		//String lat = "51.499355"; // 위도  구글 lat  ( latitude )
		//String lon = "-0.127317"; // 경도  구글 lng  ( longitude )
		
		String url = "http://api.openweathermap.org/data/2.5/weather?lat="+weather.getLat()+"&lon="+weather.getLng()+"&appid=a3c251e05b60a7991107bb0d2992708d";
		//String url = "http://api.openweathermap.org/data/2.5/weather?q=London&appid=a3c251e05b60a7991107bb0d2992708d";
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type","application/json");
		try {
		HttpResponse httpResponse = httpClient.execute(httpGet);
//		System.out.println(httpResponse);
		
		HttpEntity httpEntity = httpResponse.getEntity();
		
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader ( new InputStreamReader(is,"UTF-8"));
		
		String serverData = br.readLine();
		
//		System.out.println(serverData);
		
		JSONObject json = (JSONObject)JSONValue.parse(serverData);
		
//		System.out.println(json.get("weather"));
//		System.out.println("Main : " + json.get("main"));
		JSONArray array = (JSONArray)json.get("weather");
		
//		System.out.println("아이콘 가져오자"+array.get(0));
		JSONObject json2 = (JSONObject)array.get(0);
		
		System.out.println("_"+json2.get("icon")+"_");
		
		weather.setIcon((String)json2.get("icon"));
		
		json = (JSONObject)json.get("main");
//		System.out.println("온도 "+json.get("temp"));
//		System.out.println("최소온도 "+json.get("temp_min"));
//		System.out.println("최대온도"+json.get("temp_max"));
//		System.out.println("습도 "+json.get("humidity"));
		
		double temp = Math.round(((Double)json.get("temp"))-273.15);
		double temp1 = Math.round(((Double)json.get("temp_min"))-273.15);
		double temp2 = Math.round(((Double)json.get("temp_max"))-273.15);
		weather.setTemp(temp+"℃");
		weather.setTempMax(temp2+"℃");
		weather.setTempMin(temp1+"℃");
		weather.setHumidity(json.get("humidity")+"%");
		
		
		
		// -273.15 온도 계산
		// main.temp (현재온도) main.temp_min (최저온도) main.temp_max (최고온도) main.humidity (습도 %)
		// weather.main (날씨 매개변수 그룹) weather.description (그룹 내의 기상조건) weather.id (날씨 상태 ID)
		// weather.icon (날씨 아이콘 ID)
		// wind.speed (풍속) 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return weather;
	}
}
