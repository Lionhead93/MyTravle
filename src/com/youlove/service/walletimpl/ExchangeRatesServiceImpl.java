package com.youlove.service.walletimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.youlove.service.domain.Exchange;
import com.youlove.service.wallet.ExchangeRatesDao;
import com.youlove.service.wallet.ExchangeRatesService;

@Service("exchangeRatesServiceImpl")
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

	@Autowired
	@Qualifier("exchangeRatesDaoImpl")
	private ExchangeRatesDao exchangeRatesDao;
	
	@Override
	public List<Exchange> exchangeRates() throws Exception {
		return exchangeRatesDao.exchangeRates();
	}
	
	@Override
	public Exchange convertExchangeRate(Exchange exchange) throws Exception {
		return exchangeRatesDao.convertExchangeRate(exchange);
	}
	
}