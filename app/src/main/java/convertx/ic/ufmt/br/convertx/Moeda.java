package convertx.ic.ufmt.br.convertx;


import java.util.Date;
import java.util.List;

import convertx.ic.ufmt.br.convertx.Models.Rate;

public class Moeda {
    boolean success;
    String timestamp;
    String base;
    String date;
    Rate rates;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rate getRates() {
        return rates;
    }

    public void setRates(Rate rates) {
        this.rates = rates;
    }


}
