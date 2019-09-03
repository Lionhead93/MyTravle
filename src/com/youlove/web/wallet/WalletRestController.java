package com.youlove.web.wallet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youlove.service.domain.Exchange;
import com.youlove.service.wallet.ExchangeRatesService;
import com.youlove.service.wallet.WalletService;

@RestController
@RequestMapping("/wallet/*")
public class WalletRestController {
	
	@Autowired
	@Qualifier("exchangeRatesServiceImpl")
	private ExchangeRatesService exchangeRatesService;
	
	public WalletRestController() {
		System.out.println(this.getClass());
	}
		
	// https://ko.exchange-rates.org CRAWLING
	@RequestMapping(value = "/json/exchangeRates", method=RequestMethod.POST)
	public List<Exchange> exchangeRates() throws Exception{

		System.out.println("/wallet/json/exchangeRates ::: POST");
		
		List<Exchange> list = exchangeRatesService.exchangeRates();
		
		return list;
		
	}
	
	@RequestMapping(value = "/json/convert", method=RequestMethod.POST)
	public Exchange convert(@RequestBody Exchange exchange) throws Exception{

		System.out.println("/wallet/json/convert ::: POST");
		System.out.println(exchange);

		return exchangeRatesService.convertExchangeRate(exchange);
		
	}
	
}