package com.bohdan;

public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;
    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance,int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType=typeOfAccount;
    }

    public double depositMoney(double depositedSum, boolean dealingWithTeller){
        return this.balance+= depositedSum;
    }

    public double withdrawMoney(double withdrawnSum, boolean dealingWithTeller){
        if(withdrawnSum>= 1000.00 && !dealingWithTeller) {
            throw new IllegalArgumentException();
        }
        return this.balance-= withdrawnSum;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking(){
       return this.accountType==CHECKING;
    }
}
