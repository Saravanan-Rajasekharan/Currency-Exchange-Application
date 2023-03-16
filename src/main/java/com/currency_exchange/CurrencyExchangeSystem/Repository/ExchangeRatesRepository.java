package com.currency_exchange.CurrencyExchangeSystem.Repository;

import com.currency_exchange.CurrencyExchangeSystem.Models.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRatesRepository extends JpaRepository <ExchangeRates,Integer>{

    @Query(value="select * from exchange ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ExchangeRates getLastEntryFromTable();
}
