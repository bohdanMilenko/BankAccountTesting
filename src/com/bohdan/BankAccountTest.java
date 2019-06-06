package com.bohdan;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount  bankAccount;

    @BeforeAll
    static void setupOnce(){
        System.out.println("This is setting up before tests are executed");
    }

    @BeforeEach
    void setup() {
        bankAccount = new BankAccount("Bohdan", "Milenko", 1500.00, BankAccount.CHECKING);
        System.out.println("This a test");
    }


    @ParameterizedTest
    @ValueSource (doubles = {400.00,500.00,1000.00})
    void depositMoney(double amount) {
     double total =  bankAccount.depositMoney(amount,false);
     assertEquals(1500+amount,total,0);
    }

    @Test
    @DisplayName("Checking Exception...")
    void withdrawMoneyFail_notTeller(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            bankAccount.withdrawMoney(1100.00,false);
        });
    }

//    @ParameterizedTest
//    @ValueSource(doubles = {300.00,500.00,600.00})
//    @DisplayName("Checking Exception...")
    @Test
    void withdrawMoneyFail_notTellerParameterized(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            bankAccount.withdrawMoney(1200.00,false);
        });
    }

    @Test
    void withdrawMoney() {
      //  fail("This method is not implemented yet.");
    }

    @Test
    void getBalance() {
        double total =  bankAccount.depositMoney(500.00,false);
        assertEquals(2000,total,0);
    }

    @Test
    void isAccount_Checking(){
        assertTrue( bankAccount.isChecking(),"The account is not checking");
    }

    @AfterAll
    static void afterAllClean(){
        System.out.println("After all tests are completed");
    }

}