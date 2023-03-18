package com.currency_exchange.CurrencyExchangeSystem.Service;


import com.currency_exchange.CurrencyExchangeSystem.DTO.ConvertedResponseDTO;
import com.currency_exchange.CurrencyExchangeSystem.DTO.CountryCode;
import com.currency_exchange.CurrencyExchangeSystem.DTO.Rates;
import com.currency_exchange.CurrencyExchangeSystem.Models.ExchangeRates;
import com.currency_exchange.CurrencyExchangeSystem.Repository.ExchangeRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ExchangeRateService {


    @Autowired
    ExchangeRatesRepository exchangeRatesRepository;

    //AUD,CAD,CHF,EUR,GBP,INR,JPY,NOK,NZD,SEK,USD

    public String addRates(ExchangeRates exchangeRates){

        String date = exchangeRates.getDate();

            exchangeRatesRepository.save(exchangeRates);

        return "Data added to the database, for " +date;
    }

    public String deleteById(Integer id){
        exchangeRatesRepository.deleteById(id);
        return "Row deleted!";
    }

    public ConvertedResponseDTO convertCurrency(String base, String destination){
        ConvertedResponseDTO convertedResponseDTO = new ConvertedResponseDTO();
        HashMap<String,String> convertMap = new HashMap<>();

        //separate number and string
        String baseCurrency = base.substring(base.length()-3);
        String baseQuantity = base.substring(0, base.length()-3);

        double baseQ = Double.parseDouble(baseQuantity); // Multiply with exchange rate

        //Get the latest entry from the exchange rate table ;
        ExchangeRates exchangeRates = exchangeRatesRepository.getLastEntryFromTable();

        CountryCode codeDest = new CountryCode(destination,exchangeRates);
        CountryCode codeBase = new CountryCode(baseCurrency,exchangeRates);

        //Get the values corresponding to the currencies
        double rate = codeDest.getValue();
        double baseRate = codeBase.getValue();

        double exRate = Math.round(baseQ*(1/baseRate)* rate*100);


        destination =  exRate/100 +" "+destination;

        convertMap.put(base,destination);
        convertedResponseDTO.setResponse(convertMap);

        return convertedResponseDTO;
    }


    public ConvertedResponseDTO predictCurrency(String baseCurrency, String date) {
        ConvertedResponseDTO convertedResponseDTO = new ConvertedResponseDTO();
        HashMap<String,String> predictMap = new HashMap<>();

//        String columnName = "inr";
//        List<Double> ColumnList = exchangeRatesRepository.getColumnEntry(columnName);

        List<Double> ColumnList = switch (baseCurrency) {
            case "AUD" -> exchangeRatesRepository.getAudColumn();
            case "CAD" -> exchangeRatesRepository.getCadColumn();
            case "CHF" -> exchangeRatesRepository.getChfColumn();
            case "EUR" -> exchangeRatesRepository.getEurColumn();
            case "GBP" -> exchangeRatesRepository.getGbpColumn();
            case "INR" -> exchangeRatesRepository.getInrColumn();
            case "JPY" -> exchangeRatesRepository.getJpyColumn();
            case "NOK" -> exchangeRatesRepository.getNokColumn();
            case "NZD" -> exchangeRatesRepository.getNzdColumn();
            case "SEK" -> exchangeRatesRepository.getSekColumn();
            default -> new ArrayList<>();
        };

        double sum = 0;
        double size = ColumnList.size();
        for(Double value: ColumnList){
            sum+=value;
        }

        double mean = Math.round((sum/size)*100);

        baseCurrency =  mean/100+" "+ baseCurrency;

        predictMap.put("predictedValue",baseCurrency);

        convertedResponseDTO.setResponse(predictMap);
        return convertedResponseDTO;

    }
}
