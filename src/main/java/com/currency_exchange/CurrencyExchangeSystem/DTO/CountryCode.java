package com.currency_exchange.CurrencyExchangeSystem.DTO;

import com.currency_exchange.CurrencyExchangeSystem.Models.ExchangeRates;

public class CountryCode {

     private String code = "";

     private ExchangeRates exchangeRates;

    public CountryCode(String code, ExchangeRates exchangeRates) {
        this.code = code;
        this.exchangeRates = exchangeRates;
    }

    //Getters and Setters


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ExchangeRates getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(ExchangeRates exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    //Convertor function

    //AUD,CAD,CHF,EUR,GBP,INR,JPY,NOK,NZD,SEK,USD

    public double getValue(){
        switch(code){
            case "AUD":
                return exchangeRates.getAud();
            case "CAD":
                return exchangeRates.getCad();
            case "CHF":
                return exchangeRates.getChf();
            case "EUR":
                return exchangeRates.getEur();
            case "GBP":
                return exchangeRates.getGbp();
            case "INR":
                return exchangeRates.getInr();
            case "JPY":
                return exchangeRates.getJpy();
            case "NOK":
                return exchangeRates.getNok();
            case "NZD":
                return exchangeRates.getNzd();
            case "SEK":
               return exchangeRates.getSek();
            case "USD":
                return exchangeRates.getUsd();
            default:
                return 0;
        }
//        if(code.equals("AUD")){
//            return exchangeRates.getAud();
//        }
//        if(code.equals("CAD")){
//            return exchangeRates.getCad();
//        }
//        if(code.equals("CHF")){
//            return exchangeRates.getChf();
//        }
//        if(code.equals("EUR")){
//            return exchangeRates.getEur();
//        }
//        if(code.equals("GBP")){
//            return exchangeRates.getGbp();
//        }
//        if(code.equals("INR")){
//            return exchangeRates.getInr();
//        }
//        if(code.equals("JPY")){
//            return exchangeRates.getJpy();
//        }
//        if(code.equals("NOK")){
//            return exchangeRates.getNok();
//        }
//        if(code.equals("NZD")){
//            return exchangeRates.getNzd();
//        }
//        if(code.equals("SEK")){
//            return exchangeRates.getSek();
//        }
//        if(code.equals("USD")){
//            return exchangeRates.getUsd();
//        }
    }



}
