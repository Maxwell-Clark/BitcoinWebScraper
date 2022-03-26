package com.maxwell.app.models;

public class MessariMarketData {
    private double priceUsd;
    private double priceBtc;
    private double priceEth;

    public MessariMarketData(double priceUsd, double priceBtc, double priceEth) {
        this.priceUsd = priceUsd;
        this.priceBtc = priceBtc;
        this.priceEth = priceEth;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public double getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(double priceBtc) {
        this.priceBtc = priceBtc;
    }

    public double getPriceEth() {
        return priceEth;
    }

    public void setPriceEth(double priceEth) {
        this.priceEth = priceEth;
    }


    @Override
    public String toString() {
        return "MessariMarketData{" +
                "price Of Bitcoin=" + priceBtc +
                ", price Of Usd to Bitcoin=" + priceUsd +
                ", price Of Ethereum to Bitcoin=" + priceEth +
                '}';
    }
}
