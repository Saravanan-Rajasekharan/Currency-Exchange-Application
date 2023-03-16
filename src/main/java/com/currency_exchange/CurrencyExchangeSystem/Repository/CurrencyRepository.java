package com.currency_exchange.CurrencyExchangeSystem.Repository;

import com.currency_exchange.CurrencyExchangeSystem.Models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
}
