package ru.netology.javaqadiplom;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class BankTest {

    Account roman = new Account();
    Account alex = new Account();

    @Test
    public void shouldTransfer() {

        roman.add(5000);
        alex.add(2000);

        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(roman, alex, 1000));
        Assertions.assertEquals(4000, roman.getBalance());
        Assertions.assertEquals(3000, alex.getBalance());
    }

    @Test
    public void shouldNotTransfer() {

        roman.add(5000);
        alex.add(2000);

        Bank bank = new Bank();

        bank.transfer(roman, alex, 10_000);

        Assertions.assertFalse(bank.transfer(roman, alex, 10_000));
        Assertions.assertEquals(5000, roman.getBalance());
        Assertions.assertEquals(2000, alex.getBalance());
    }
}
