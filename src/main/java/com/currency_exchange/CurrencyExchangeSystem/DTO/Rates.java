package com.currency_exchange.CurrencyExchangeSystem.DTO;

import com.currency_exchange.CurrencyExchangeSystem.Models.ExchangeRates;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Rates {

    private List<ExchangeRates> exchangeRatesList;

    public Rates() {
    }


    public Rates(List<ExchangeRates> exchangeRatesList) {
        this.exchangeRatesList = exchangeRatesList;
    }

    public List<ExchangeRates> getExchangeRatesList() {
        return exchangeRatesList;
    }

    public void setExchangeRatesList(List<ExchangeRates> exchangeRatesList) {
        this.exchangeRatesList = exchangeRatesList;
    }
}
