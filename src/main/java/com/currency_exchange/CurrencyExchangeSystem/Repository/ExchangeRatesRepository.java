package com.currency_exchange.CurrencyExchangeSystem.Repository;

import com.currency_exchange.CurrencyExchangeSystem.Models.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRatesRepository extends JpaRepository <ExchangeRates,Integer>{

    @Query(value="select * from exchange ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ExchangeRates getLastEntryFromTable();

    @Query(value="SELECT e."+":columnName"+ " FROM exchange e", nativeQuery = true)
    List<Double> getAllColumnEntry(@Param("columnName") String columnName);

   // List<Double> findAllByColumnName(String column_name);
   @Query(value = "SELECT e.aud FROM exchange e",nativeQuery = true)
   List<Double> getAudColumn();

    @Query(value = "SELECT e.cad FROM exchange e",nativeQuery = true)
    List<Double> getCadColumn();

    @Query(value = "SELECT e.chf FROM exchange e",nativeQuery = true)
    List<Double> getChfColumn();

    @Query(value = "SELECT e.eur FROM exchange e",nativeQuery = true)
    List<Double> getEurColumn();

    @Query(value = "SELECT e.gbp FROM exchange e",nativeQuery = true)
    List<Double> getGbpColumn();

    @Query(value = "SELECT e.inr FROM exchange e",nativeQuery = true)
    List<Double> getInrColumn();

    @Query(value = "SELECT e.jpy FROM exchange e",nativeQuery = true)
    List<Double> getJpyColumn();

    @Query(value = "SELECT e.nok FROM exchange e",nativeQuery = true)
    List<Double> getNokColumn();

    @Query(value = "SELECT e.nzd FROM exchange e",nativeQuery = true)
    List<Double> getNzdColumn();

    @Query(value = "SELECT e.sek FROM exchange e",nativeQuery = true)
    List<Double> getSekColumn();






}
