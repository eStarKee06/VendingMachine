package com.company;

public class Main {

    public static void main(String[] args) {
        simpleTransactionTest();
    }

    public static void simpleTransactionTest(){
        VendingMachine machine = new VendingMachine();
        int code = machine.addProduct(new Product("Test", 2.00));
        System.out.println(code);
        User testUser = new User(5.00, machine);
        testUser.buyProduct(code);
        System.out.println(testUser.getBudget());
    }
}
