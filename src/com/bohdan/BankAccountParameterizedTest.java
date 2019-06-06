package com.bohdan;

import org.junit.jupiter.api.*;


public class BankAccountParameterizedTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setup() {
        bankAccount = new BankAccount("Bohdan", "Milenko", 1500.00, BankAccount.CHECKING);
        System.out.println("This a test");
    }


}
