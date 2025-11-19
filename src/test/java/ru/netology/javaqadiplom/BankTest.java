package ru.netology.javaqadiplom;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class BankTest {

    Account Roman = new Account();
    Account Alex = new Account();

    @Test
    public void shouldTransfer() {

        Roman.add(5000);
        Alex.add(2000);

        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(Roman, Alex, 1000));
        Assertions.assertEquals(4000, Roman.getBalance());
        Assertions.assertEquals(3000, Alex.getBalance());
    }

    @Test
    public void shouldNotTransfer() {

        Roman.add(5000);
        Alex.add(2000);

        Bank bank = new Bank();

        bank.transfer(Roman, Alex, 10_000);

        Assertions.assertFalse(bank.transfer(Roman, Alex, 10_000));
        Assertions.assertEquals(5000, Roman.getBalance());
        Assertions.assertEquals(2000, Alex.getBalance());
    }
}
