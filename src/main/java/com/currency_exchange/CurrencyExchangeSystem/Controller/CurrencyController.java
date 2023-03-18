package com.currency_exchange.CurrencyExchangeSystem.Controller;

import com.currency_exchange.CurrencyExchangeSystem.DTO.ConvertedResponseDTO;
import com.currency_exchange.CurrencyExchangeSystem.DTO.Rates;
import com.currency_exchange.CurrencyExchangeSystem.Models.ExchangeRates;
import com.currency_exchange.CurrencyExchangeSystem.Service.CurrencyService;
import com.currency_exchange.CurrencyExchangeSystem.Service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    ExchangeRateService exchangeRateService;

    @Autowired
    CurrencyService currencyService;


    @PostMapping("/addRates")
    public String addRates(@RequestBody ExchangeRates exchangeRates){
        return  exchangeRateService.addRates(exchangeRates);
    }

    @GetMapping("/convert/{base}/{destination}")
    public ConvertedResponseDTO convertCurrency(@PathVariable String base, @PathVariable String destination){
        return exchangeRateService.convertCurrency(base,destination);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Integer id){
        return exchangeRateService.deleteById(id);
    }

    @GetMapping("/predict/{baseCurrency}/{date}")
    public ConvertedResponseDTO predictCurrency(@PathVariable String baseCurrency, @PathVariable String date){
        return exchangeRateService.predictCurrency(baseCurrency,date);
    }





}
