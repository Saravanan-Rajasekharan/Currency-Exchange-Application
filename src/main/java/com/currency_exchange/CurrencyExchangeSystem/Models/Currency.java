package com.currency_exchange.CurrencyExchangeSystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name="currency")
public class Currency {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;

    private String countryCode;

    private double exchangeRate;  //wrt USD  1USD == 82INR ---> exchangeRate = 1/82



}
