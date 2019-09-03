package com.youlove.service.walletimpl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import com.youlove.service.domain.Exchange;
import com.youlove.service.wallet.ExchangeRatesDao;

@Repository("exchangeRatesDaoImpl")
public class ExchangeRatesDaoImpl implements ExchangeRatesDao {

	@Override
	public List<Exchange> exchangeRates() throws Exception{
		
		String url = "https://ko.exchange-rates.org/MajorRates/ByRegion/E";
		
		/*
		Document doc = Jsoup.connect(url)
					  .header("Content-Type", "application/json;charset=UTF-8")
					  .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36")
					  .get();
		*/
		
		Document doc = Jsoup.connect(url)
					  .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36")
					  .get();
		//System.out.println(doc);
		
		Elements element = doc.select("td.text-nowrapX");
		//System.out.println(element);
		
		Exchange exchange = null;
		List<Exchange> list = new ArrayList<Exchange>();
		
		int index = 1;
		for(Element el : element){
			exchange = new Exchange();
			
			//System.out.println(index);
			
			String str = (el.select("a + a").text()).replaceAll("스위스 크로나", "스웨덴 크로나").replaceAll("유로", "유럽연합 유로");
			exchange.setNation(str);
			//System.out.println(str);
			
			/*
			if((el.select("a + a").text()).indexOf(" ") != -1){
				String[] strArr = el.select("a + a").text().split(" ");
				exchange.setNation(strArr[0]);
				System.out.println(strArr[0]);
			}else {
				exchange.setNation(el.select("a + a").text());
				System.out.println(el.select("a + a").text());
			}
			*/
			
			exchange.setUnit(el.select("a + a").attr("title"));
			//System.out.println(el.select("a + a").attr("title"));
			
			str = el.parent().select("td:nth-child(2)").text();
			
			if(str.indexOf(",") != -1){
				String[] strArr = str.split(",");
				//System.out.println(strArr[0] + strArr[1]);
				str = strArr[0].toString() + strArr[1].toString();
			}
			
			double db = Math.round(Double.parseDouble(str)*100) / 100.0;
			exchange.setExchangeRate(db);
			//System.out.println(db);

			index++;
			
			list.add(exchange);
        }
		
		System.out.println(list);
		
		return list;
		
	}
	
	@Override
	public Exchange convertExchangeRate(Exchange exchange) throws Exception{
		
		System.out.println(exchange);
		
		// String url = "https://ko.exchange-rates.org/converter/" + from + "/" + to + "/" + amount + "/Y";
		String url = "https://ko.exchange-rates.org/converter/" + exchange.getFrom() + "/" + exchange.getTo() + "/" + exchange.getAmount() + "/Y";
		
		Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36").get();
		//System.out.println(doc);
		
		Elements element = doc.select("span#ctl00_M_lblConversion");
		System.out.println(element);
		
		String[] strArr = (element.text()).split(" = ");
		//System.out.println(strArr[0] + strArr[1]);
		
		strArr[1] = strArr[1].substring(0, strArr[1].lastIndexOf(" "));
		//System.out.println(strArr[1]);
		
		String str = "";
		
		if(strArr[1].indexOf(",") != -1){
			strArr = strArr[1].split(",");
			//System.out.println(strArr[0] + strArr[1]);
			
			str = strArr[0].toString() + strArr[1].toString();
		}else {
			str = strArr[1].toString();
		}
		
		//System.out.println(str);
		
		// double result = Double.parseDouble(str);
		exchange.setExchangeRate(Double.parseDouble(str));
		
		return exchange;
		
	}
	
}