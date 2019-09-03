package com.youlove.service.wallet;

import java.util.List;

import com.youlove.service.domain.Exchange;

public interface ExchangeRatesService {

	public List<Exchange> exchangeRates() throws Exception;

	public Exchange convertExchangeRate(Exchange exchange) throws Exception;
	
}