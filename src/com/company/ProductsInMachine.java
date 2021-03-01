package com.company;

public class ProductsInMachine {
    private Product product;
    private int quantity;
    public ProductsInMachine(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public Product getProduct(){
        return product;
    }
}
