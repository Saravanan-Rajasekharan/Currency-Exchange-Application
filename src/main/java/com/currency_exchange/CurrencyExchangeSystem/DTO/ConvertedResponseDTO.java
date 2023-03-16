package com.currency_exchange.CurrencyExchangeSystem.DTO;

import java.util.HashMap;

public class ConvertedResponseDTO {

    private HashMap<String,String> response;

    public ConvertedResponseDTO() {
        response = new HashMap<String,String>();
    }

    public HashMap<String, String> getResponse() {
        return response;
    }

    public void setResponse(HashMap<String, String> response) {
        this.response = response;
    }
}
