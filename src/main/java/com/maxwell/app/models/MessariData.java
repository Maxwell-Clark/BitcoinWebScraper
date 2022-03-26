package com.maxwell.app.models;

public class MessariData {
    private String id;
    private int serialId;
    private String symbol;
    private String name;
    private String slug;
    private MessariMarketData marketData;

    public MessariData(String id, int serialId, String symbol, String name, String slug, MessariMarketData marketData) {
        this.id = id;
        this.serialId = serialId;
        this.symbol = symbol;
        this.name = name;
        this.slug = slug;
        this.marketData = marketData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSerialId() {
        return serialId;
    }

    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public MessariMarketData getMarketData() {
        return marketData;
    }

    public void setMarketData(MessariMarketData marketData) {
        this.marketData = marketData;
    }

    @Override
    public String toString() {
        return "MessariData{" +
                "id='" + id + '\'' +
                ", serialId=" + serialId +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", marketData=" + marketData +
                '}';
    }
}
