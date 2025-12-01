package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class BankTest {

    CreditAccount accountRoman = new CreditAccount(
            5000,
            1000,
            10
    );

    CreditAccount accountAlex = new CreditAccount(
            2000,
            1000,
            10
    );
    Bank bank = new Bank();

    @Test
    public void shouldTransfer() {

        Assertions.assertTrue(bank.transfer(accountRoman, accountAlex, 1000));
        Assertions.assertEquals(4000, accountRoman.getBalance());
        Assertions.assertEquals(3000, accountAlex.getBalance());
    }

    @Test
    public void shouldNotTransfer() {

        Assertions.assertFalse(bank.transfer(accountRoman, accountAlex, 10_000));
        Assertions.assertEquals(5000, accountRoman.getBalance());
        Assertions.assertEquals(2000, accountAlex.getBalance());
    }

    @Test
    public void shouldNotTransferIfAmountBelow0() {

        Assertions.assertFalse(bank.transfer(accountRoman, accountAlex, -1_000));
        Assertions.assertEquals(5000, accountRoman.getBalance());
        Assertions.assertEquals(2000, accountAlex.getBalance());
    }

    @Test
    public void TransferOverMaximumAmount() {

        SavingAccount accountRomanV = new SavingAccount(
                3_000,
                50,
                10_000,
                80
        );

        SavingAccount accountAlexS = new SavingAccount(
                9_000,
                500,
                10_000,
                10
        );
        Assertions.assertFalse(bank.transfer(accountRomanV, accountAlexS, 2_000));
        Assertions.assertEquals(3000, accountRomanV.getBalance());
        Assertions.assertEquals(9000, accountAlexS.getBalance());
    }
}