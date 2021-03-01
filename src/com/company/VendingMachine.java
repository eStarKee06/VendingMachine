package com.company;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VendingMachine {
    private int numOfProducts, numUnitsPerProduct;
    private Map<Integer, ProductsInMachine> vendingInternal;

    public VendingMachine(){
        this(9, 10);
    }
    public VendingMachine(int numOfProducts, int numUnitsPerProduct){
        this.numOfProducts = numOfProducts;
        this.numUnitsPerProduct = numUnitsPerProduct;
        this.generateCodes();
    }
    private void generateCodes() {
        this.vendingInternal = new HashMap<>();
        for(int i = 0; i < numOfProducts; i++){
            int code = (int) (Math.random() * (9999 - 1000)) + 1000;
            if(!this.vendingInternal.containsKey(code)){
                this.vendingInternal.put(code, null);
            }
            else{
                i--;
            }
        }
    }

    private int findEmptyCode(){
        Iterator keySet = this.vendingInternal.keySet().iterator();
        while(keySet.hasNext()){
            Integer currentCode = (Integer) keySet.next();
            if(vendingInternal.get(currentCode) == null){
                return currentCode;
            }
        }
        return -1;
    }

    public int addProduct(Product product){
        return this.addProduct(1111, product);
    }

    public int addProduct(int code, Product product){
        if(vendingInternal.containsKey(code)){
            if(vendingInternal.get(code) == null){
                vendingInternal.put(code, new ProductsInMachine(product, this.numUnitsPerProduct));
                return code;
            }
        }
        int emptyCode = findEmptyCode();
        if(emptyCode != -1){
            vendingInternal.put(emptyCode,  new ProductsInMachine(product, this.numUnitsPerProduct));
            return emptyCode;
        }
        return -1;
    }

    public void restockAll(){
        Iterator keySet = this.vendingInternal.keySet().iterator();
        while(keySet.hasNext()){
            this.restockProduct((Integer) keySet.next());
        }
    }

    public void restockProduct(int code){
        if(this.vendingInternal.containsKey(code)){
            this.vendingInternal.get(code).setQuantity(this.numUnitsPerProduct);
        }
    }

    public void removeProduct(int code){
        if(this.vendingInternal.containsKey(code)){
            this.vendingInternal.put(code, null);
        }
    }

    public void replaceProduct(int code, ProductsInMachine productWrapper){
        if(this.vendingInternal.containsKey(code)){
            this.vendingInternal.put(code, productWrapper);
        }
    }

    public Product releaseProduct(int code) {
        if(this.vendingInternal.containsKey(code)) {
            int productQuantity = this.vendingInternal.get(code).getQuantity();
            Product product = this.vendingInternal.get(code).getProduct();
            if (productQuantity != 0) {
                this.vendingInternal.get(code).setQuantity(productQuantity - 1);
                return product;
            }
        }
        return null;
    }


}
