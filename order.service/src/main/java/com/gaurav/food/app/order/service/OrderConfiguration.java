package com.gaurav.food.app.order.service;

public class OrderConfiguration {

    private int maximum;
    private int minimum;

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public OrderConfiguration(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public OrderConfiguration() {
    }

    @Override
    public String toString() {
        return "LimitsConfiguration{" +
                "maximum=" + maximum +
                ", minimum=" + minimum +
                '}';
    }
}
