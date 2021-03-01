package com.company;

public class User {
    double budget;
    VendingMachine machine;
    public User(double budget, VendingMachine machine){
        this.budget = budget;
        this.machine = machine;
    }
    public double getBudget(){
        return this.budget;
    }
    public void buyProduct(int code){
        Product product = this.machine.releaseProduct(code);
        this.budget = this.budget - product.getCost();
    }
}
