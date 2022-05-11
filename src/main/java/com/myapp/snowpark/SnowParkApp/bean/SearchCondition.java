package com.myapp.snowpark.SnowParkApp.bean;

public class SearchCondition {

    private boolean available;
    private String type;
    private int startingPrice;
    private int endingPrice;
    private String field;
    
    public SearchCondition() {
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }

    public int getEndingPrice() {
        return endingPrice;
    }

    public void setEndingPrice(int endingPrice) {
        this.endingPrice = endingPrice;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "SearchCondition [available=" + available + ", endingPrice=" + endingPrice + ", field=" + field
                + ", startingPrice=" + startingPrice + ", type=" + type + "]";
    }

}
