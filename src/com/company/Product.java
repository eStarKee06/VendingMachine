package com.company;

public class Product {
    private double cost;
    private String name;
    public Product(String name, double cost){
        this.cost = cost;
        this.name = name;
    }
    public double getCost(){
        return cost;
    }
    public String getName(){
        return name;
    }
}
